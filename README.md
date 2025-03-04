# Airelogic Technical Test
**Name:** Laura Gandia Garcia-Morales

**University:** Leeds Beckett University

**Start date:** 26/02/2025

**Deadline:** 05/02/2025

## Task analysis
### Abstraction of the problem
An aggregate scoring system of the following: respiration rate, oxygen saturation, level of consciousness/new confusion
and temperature. A score is allocated to each of these which then determines how ill someone is based on the deviation 
from expected (normal) values.

All the scores are added together, and 2 additional points may be added for patients requiring supplemental oxygen.
Typical scores range from 0 to 14.

- AIR or OXYGEN:
    - Air: 0 points
    - Oxygen: 2 points
- Consciousness:
  - ALERT (0 points)
  - CVPU (3 points)
- Respiration Range:
  - ≤8: 3 points 
  - 9–11: 1 point 
  - 12–20: 0 points 
  - 21–24: 1 point 
  - ≥25: 3 points
- SpO2:
  - ≤83: 3 points 
  - 84–85: 2 points 
  - 86–87: 1 point 
  - 88–92: 0 points 
  - 93–94 on oxygen: 1 point 
  - 95–96 on oxygen: 2 points 
  - ≥97 on oxygen: 3 points
- Temperature:
  - ≤35.0: 3 points 
  - 35.1–36.0: 1 point 
  - 36.1–38.0: 0 points 
  - 38.1–39.0: 1 point 
  - ≥39.1: 3 points

#### Bonus problem breakdown
For this problem, I must be able to somehow track the time to know when the last reading was.
A solution could be to either have an array that stores the time, along with the other stats and have these extracted to
be analysed by the program. Another possible solution, albeit slightly harder to execute, to have a database that would 
use the patient's ID or number as primary key and store the stats periodically.

For this problem it is specified that the time of monitoring varies between patients depending on the condition so the 
program must adjust to that. This will involve calculations of how long it has passed since the last reading, 24 hours 
for the alerting trends point, then 2 hours for the CBG. There must be a way to identify and compare the readings from
24hr and 2hrs ago reliably.

For simplicity, I will to use an array rather than an actual database, due to having to install and
manage Database server, along with dependencies.

After some trial and error, I managed to include the CBG scoring system, and possibly implement the 24-hour detection
system. However, I am unsure if it is working since I am not fully familiar with the date/time library in java. The code
creates a record with a time stamp, which in a real setting should work as it goes updating and comparing the real-time 
hours for each patient. The CBG is based on recording whether the patient is fasting or not rather than the time variable
given since I was not able to get the time library to work as I wanted, and so depends on a boolean.

## Notes
* NEWS2 stands for National Early Warning Score 2, a tool used to assess how likely a patient is to deteriorate. 
It's used in the NHS to identify patients who are acutely ill.

# Task
## Medi Score Calculation

### Background

Write a function to calculate the score for a patient. This is a simple rule-of-thumb score used to identify ill 
patients.

### Introduction

The Medi Score is a simple aggregate scoring system created for this test based on other scores used widely 
in healthcare in which a score is calculated based on patients' physiological measurements. 
For some patients these readings may be taken every hour or even more frequently depending on their condition.
While this scoring system is similar to recognised scores like NEWS2 it is distinct from it and has some nuance of its own.

The following observations are routinely taken when patients present to (or are being monitored in) hospital:

 1. respiration rate
 2. oxygen saturation
 3. level of consciousness or new confusion (whether the patient is newly confused, disorientated or agitated)
 4. temperature

A score for each property is allocated as the property is measured. The score for the property reflects how different
the measurement is from the range of expected values.

The scores for each property are added together, and 2 additional points are added for patients requiring
supplemental oxygen to maintain their oxygen saturation level. This final sum is the Medi score, which ranges from
0 to 14.

### Application Requirements

The Medi score for a patient is the **sum** of the scores for each property in the following table. Ranges are inclusive.

Your function can either take these measures as separate parameters, or take a single struct/object containing these values as attributes/properties. 

The Medi score for the patient should be returned as an **integer**.

The middle column in the table below represents a **normal** range for readings which map to a score of 0 and the columns either side represent abnormal values that will accrue a score, those abnormal ranges exist above and below the normal range for some of the parameters.


| Property                       | Score 3  | Score 2      | Score 1         | Score 0                        | Score 1               | Score 2               | Score 3          |
| ------------------------------ | -------- | ------------ | --------------- | ------------------------------ | --------------------- | --------------------- | ---------------- |
| Air or oxygen?                 |          | Oxygen       |                 | Air                            |                       |                       |                  |
| Consciousness                  |          |              |                 | Alert                          |                       |                       | CVPU             |
| Respiration rate (per minute)  | &le;8    |              | 9&ndash;11      | 12&ndash;20                    |                       | 21&ndash;24           | &ge;25           |
| SpO<sub>2</sub> (%)            | &le;83   | 84&ndash;85  | 86&ndash;87     | 88&ndash;92 (or &ge;93 on air) | 93&ndash;94 on oxygen | 95&ndash;96 on oxygen | &ge;97 on oxygen |
| Temperature (&deg;C)           | &le;35.0 |              | 35.1&ndash;36.0 | 36.1&ndash;38.0                | 38.1&ndash;39.0       | &ge;39.1              |                  |

The values of the observations will be the following data types:

| Property                | Data type      | Comment                                           |
| ----------------------- | -------------- | ------------------------------------------------- |
| Air or oxygen?          | Enum (integer) | `0` if air, `2` if on oxygen                      |
| Consciousness           | Enum (integer) | `0` if alert, non-zero if CVPU                    |
| Respiration range       | Integer        |                                                   |
| SpO<sub>2</sub>         | Integer        |                                                   |
| Temperature             | Float          | This should be rounded to a single decimal place. |

### Examples

Here are some examples of patients and their Medi scores.

#### Patient 1

| Property                | Observation | Score | Comment                                                                  |
| ----------------------- | ----------- | ----- | ------------------------------------------------------------------------ |
| Air or oxygen?          | 0           | 0     | The patient is breathing air, and does not require supplementary oxygen. |
| Consciousness           | 0           | 0     | The patient is conscious.                                                |
| Respiration range       | 15          | 0     |                                                                          |
| SpO<sub>2</sub>         | 95          | 0     | As the patient is breathing air, this is a normal range.                 |
| Temperature             | 37.1        | 0     |                                                                          |

This patient's final Medi score is **0**.

#### Patient 2

| Property                | Observation | Score | Comment                                               |
| ----------------------- | ----------- | ----- | ----------------------------------------------------- |
| Air or oxygen?          | 2           | 2     | The patient requires supplementary oxygen.            |
| Consciousness           | 0           | 0     | The patient is conscious.                             |
| Respiration range       | 17          | 0     |                                                       |
| SpO<sub>2</sub>         | 95          | 2     | As the patient is breathing oxygen, this is elevated. |
| Temperature             | 37.1        | 0     |                                                       |

This patient's final Medi score is **4**.

#### Patient 3

| Property                | Observation | Score | Comment                                                             |
| ----------------------- | ----------- | ----- | ------------------------------------------------------------------- |
| Air or oxygen?          | 2           | 2     | The patient requires supplementary oxygen.                          |
| Consciousness           | 1           | 3     | The patient is unconscious or confused.                             |
| Respiration range       | 23          | 2     |                                                                     |
| SpO<sub>2</sub>         | 88          | 0     | This is a normal range for patients breathing either air or oxygen. |
| Temperature             | 38.5        | 1     |                                                                     |

This patient's final Medi score is **8**.

### Bonus 

If you've completed the Medi score calculation and feel you have enough time left to spend then please attempt to solve any of the following issues, you will need additional fields in the input to satisfy these requirements:

- Alerting for trends in the Medi score - While the score is useful on its own to assess the urgency of treatment, an increasing score over a short period of time would be worth notifying someone about. Can your system flag up an additional risk if a score has raised by more than 2 points within a 24 hour period?

- Capillary Blood Glucose is another metric that is regularly recorded, but its range changes depending on when the patient last ate. The ranges (in mmol/L) and scores are as follows:

| Property                       | Score 3       | Score 2      | Score 1         | Score 0             | Score 1               | Score 2               | Score 3          |
| ------------------------------ | ------------- | ------------ | --------------- | ------------------- | --------------------- | --------------------- | ---------------- |
| CBG (When Fasting)             | 3.4 and below | 3.5 - 3.9    |                 | 4.0 - 5.4           |                       | 5.5 - 5.9             | 6.0 and above    |
| CBG (2 hours after eating)     | 4.5 and below | 4.5 - 5.8    |                 | 5.9 - 7.8           |                       | 7.9 - 8.9             | 9.0 and above    |
