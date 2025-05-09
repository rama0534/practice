# Price Check
There is a shop with old-style cash registers. Rather than scanning items and pulling the price from a database, the price of each item is typed in manually.
This method sometimes leads to errors. Given a list of items and their correct prices, compare the prices to those entered when each item was sold. Determine the number of errors in selling prices.

Example
````
products = ['eggs', 'milk', cheese']
productPrices = [2.89, 3.29, 5.79]
productSold = ['eggs, 'eggs', 'cheese', 'milk']
soldPrice = [2.89, 2.99, 5.97, 3.29].
````

#### Price
| Product | Actual | Expected | Error |
|---------|--------|----------|-------|
| eggs    | 2.89   | 2.89     |       |
| eggs    | 2.99   | 2.89     | 1     |
| cheese  | 5.97   | 5.79     | 1     |
| milk    | 3.29   | 3.29     |       |

The second sale of eggs has a wrong price, as does the sale of cheese. There are `2` errors in pricing.

#### Function Description
Complete the function priceCheck in the editor below.
priceCheck has the following parameter(s):
string `products[n]`: each `products[i]` is the name of an item for sale.

#### Solution

```java
private static int priceCheck(List<String> products, List<Double> productPrices, List<String>  productSold, List<Double> soldPrice) {
        int totalErrors = 0;
        int n = productPrices.size();
        HashMap<String, Double> productActualPrices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            productActualPrices.put(products.get(i), productPrices.get(i));
        }

        for (int i = 0; i < productSold.size(); i++) {
            String product = productSold.get(i);
            double actualPrice = productActualPrices.get(product);
            if (Double.compare(actualPrice, soldPrice.get(i)) != 0)   totalErrors++;
        }

        return totalErrors;
    }
```