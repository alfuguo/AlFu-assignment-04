# College Enrollment Data Management

## Situation

As a Data Scientist for a college, the task is to assist Professors in managing their student enrollment data. The Professors have a master CSV file containing all student enrollments across various courses. However, each Professor requires a filtered list showing only the students enrolled in their respective classes.

## Job

The primary job is to process the master list and divide the data into three separate CSV files, each representing a different course. These files should list students enrolled in the specific course and sort them by grade in descending order.

The output CSV files should be named as follows:
- `course1.csv`
- `course2.csv`
- `course3.csv`

## Hints

- Handle null entries when sorting arrays to prevent crashes.
- Use `"\n"` to insert new lines when writing to files.
- Convert string inputs to integers using `Integer.parseInt(myStringVal)`.

## Example Output

### course1.csv

```csv
Student ID,Student Name,Course,Grade
28,Justin Conrad,COMPSCI 310,99
37,Simone Scott,COMPSCI 312,91
...
