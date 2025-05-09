# Largest Number of Orders
A company maintains information about its orders in table called `ORDERS`. 
Write a query to find the `CUSTOMER_ ID` of the customer who has placed the largest number of orders. 
If there is more than one customer with the same number of orders, then print the one with the smallest `CUSTOMER_ID`.

### Orders
| Name        | Type    | Description                                                                                             |
|-------------|---------|---------------------------------------------------------------------------------------------------------|
| ID          | Integer | A number in the inclusive range [1, 1000] which uniquely identifies the order. This is the primary key. |
| ORDER_DATE  | Date    | The date when the order was placed.                                                                     |
| STATUS      | String  | This is the order status. It can be PLACED, SHIPPED, IN TRANSIT, DELIVERED.                             |
| CUSTOMER_ID | Integer | A number in the inclusive range [1, 1000] which uniquely identifies the customer who placed the order.  |

### Output Format
The output of the query should be the `CUSTOMER_ID` from the ORDERS table for the customer who has placed the largest number of orders. 
If there is more than one customer with the same number of orders, then print the one with the smallest `CUSTOMER ID`.

`ORDERS.CUSTOMER_ID`

### Solution
```mysql
SELECT CUSTOMER_ID
FROM ORDERS
GROUP BY CUSTOMER_ID
ORDER BY COUNT(*) DESC, CUSTOMER_ID ASC
LIMIT 1;
```


### Explanation:
GROUP BY CUSTOMER_ID: Groups the orders by each customer.

COUNT(*): Counts the number of orders each customer placed.

ORDER BY COUNT(*) DESC: Sorts by the number of orders in descending order (highest first).

CUSTOMER_ID ASC: For tie-breakers, sorts by CUSTOMER_ID in ascending order (smallest ID wins).

LIMIT 1: Returns only the top result.