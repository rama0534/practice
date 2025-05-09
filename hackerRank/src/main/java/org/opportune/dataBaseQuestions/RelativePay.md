# Relative Pay
A company maintains an `EMPLOYEE` table with information for each of their `employee` write a query to produce a list containing two columns. 
The first column should include the name of an employee who earns less than some other employee. 
The second col should contain the name of a higher earning employee. 
All combinations of lesser anc greater earning employees should be included. 
Sort ascending, first by the lower earn `employee's ID`, then by the higher earning `employee's SALARY`.

### EMPLOYEE

| Name    | Type    | Description                                            |
|---------|---------|--------------------------------------------------------|
| ID      | Integer | The ID of the employee. This is a primary key.         |
| NAME    | String  | The name of the employee having [1, 20] characters.    |
| AGE     | Integer | Employee age in years.                                 |
| ADDRESS | String  | The address of the employee having [1, 25] characters. |
| SALARY  | Integer | The salary of the employee.                            |

### Solution
```mysql
SELECT 
    e1.NAME AS LOWER_EARNING_EMPLOYEE,
    e2.NAME AS HIGHT_EARNING_EMPLOYEE
FROM 
    EMPLOYEE e1
JOIN
    EMPLOYEE e2
ON 
    e1.SALARY < e2.SALARY
ORDER BY 
    e1.ID ASC, 
    e2.SALARY ASC;
```

#### Explanation
- `e1 and e2` are two copies of the `EMPLOYEE` table.
- `e1.SALARY < e2.SALARY` ensure we only pick pairs where e1 earns less than e2.
- `ORDER BY e1.ID ASC, e2.SALARY ASC` sorts first by the lower-earning `employee's ID`, and for the same employee, by the higher `salary` in ascending order. 