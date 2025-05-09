# Youngest Employees
There are two data tables with employee information: `EMPLOYEE` and`EMPLOYEE_UIN`.
Query the tables to generate a list of all employees who are less than 25 years old first in order of `NAME`, then of `ID`, 
both ascending. The result should include the `UIN` followed by the `NAME`.
**Note:** While the secondary sort is by `ID`, the result includes `UIN` but not `ID`.

## Schema
### EMPLOYEE

| Name    | Type    | Description                                            |
|---------|---------|--------------------------------------------------------|
| ID      | Integer | The ID of the employee. This is a primary key.         |
| NAME    | String  | The name of the employee having [1, 20] characters.    |
| AGE     | Integer | The age of the employee.                               |
| ADDRESS | String  | The address of the employee having [1, 25] characters. |
| SALARY  | Integer | The salary of the employee.                            |

### EMPLOYEE_UIN
| Name     | Type    | Description                                            |
|----------|---------|--------------------------------------------------------|
| ID       | Integer | The ID of the employee. This is a primary key.         |
| UIN      | String  | The unique identification number of the employee.      | 

#### Sample Output
```
63868-453 Dave
63550-194 Mary
57520-0440 Sherrie
```
#### Explanation
- Sherrie is 23 years old and has UIN 57520-0440. This record is printed.
- Paulis 30 years old and has UIN 49638-001. This record is not printed.
- A similar analysis is done on the remaining records.
- None of the three names of people less than 25 years old is repeated, so print them in alphabetical order. 
There is no additional sorting by ID in this case.
#### Solution
```mysql
SELECT eu.UIN, e.NAME 
FROM EMPLOYEE e
JOIN EMPLOYEE_UIN eu ON e.ID = eu.ID
WHERE e.age < 25 
ORDER BY e.Name ASC, e.id ASC;
```
