# REST API: Products in Range
A REST API contains information about items in an inventory. 
Given the product category, minimum price, and maximum price parameters, the goal is to use the APl to get the total number of products that belong to this category and have a price in the given range, inclusive. 
The API returns paginated data.

To access the inventory information, perform an HTTP GET request to:
`https://jsonmock.hackerrank.com/api/inventory?category=<category>&page=<pageNumber>`
where `<category>` is the category to get products for and `<pageNumber>` is an integer that denotes the page of the results to return.

For example, a GET request to
`https://jsonmock.hackerrank.com/api/inventory?category=Accessories&page=2`
returns data associated with category `Accessories`, and on the second page of the results.

Similarly, a GET request to `https://jsonmock.hackerrank.com/api/inventory?category=Tops&page=1`
returns data associated with category `Tops`, and on the first page of the results.
The response to such a request is a JSON with the following 5 fields:
- page: The current page of the results.
- per_page: The maximum number of items returned per page.
- total: The total number of items in the inventory.
- total_pages: The total number of pages with results.
- data: Either an empty array or an array of item records (Array of objects). Each item record has the following schema:
- barcode: a string that denotes the barcode of the item
- item: a string that denotes the name of the item
- category: a string that denotes the category of the item queried
- price: a float that denotes the price of the item
- item: a string that denotes the name of the item
- category: a string that denotes the category of the item queried
- price: a float that denotes the price of the item
- discount: a float that denotes the discount on the item
- available: an integer that denotes the number of units of the item available in the inventory (0 denotes unavailable, 1 denotes available)

Below is an example of an item record:
````
{
"barcode": "74000848",
"item": "Chemise",
"category": "Accessories"
"price": 898.0,
"discount":13.1,
"available" :1
}
````

Given a string category, numerical minimum price minPrice, numerical maximum price maxPrice, 
return the total number of items that belong to the category with a price greater than or equal to minPrice and price less than or equal to maxPrice.

#### Function Description
Complete the function getProductsInRange in the editor below.

getProducts/nRange has the following parameter(s):
- string category: string denoting the category we want to query for 
- int minPrice: the lower price limit 
- int maxPrice: the higher price limit

#### Returns
int: the total number of items matching the given criteria

#### Constraints
The given category will always have data returned from the API.

**NOTE:** Please perform pagination in order to get all the results.

##### Input Format For Custom Testing
In the first line, there is a string, category.

In the second line, there is an integer, minPrice.

In the third line, there is an integer, maxPrice.
#### Sample Case 0
````
Sample Input For Custom Testing
STDIN          Function  
Accessories    → category = 'Accessories'
3000           → minPrice = 3000
4000           → maxPrice = 4000
````

#### Sample Output
`131`

##### Explanation
The function makes paginated calls and counts the Accessories with a price greater than or equal to 3000 and less than or equal to 4000. It then returns the total count which is printed by the stub
#### Sample Case 1
Sample Input For Custom Testing
````
Tops
0
1000
````
#### Sample Output
`100`
#### Explanation
The function make paginated calls and counts 'Tops' with a price greater than or equal to 0 and less than or equal to 1000. It then returns the total count which is printed by the stub code.


#### Solution
````
private static int getProducts(String category, int minPrice, int maxPrice) {
        int totalProduct = 0;
        int page = 1;
        int totalPages = 1;
        String url = "https://jsonmock.hackerrank.com/api/inventory?category";
        try {
            String encodedCategory = URLEncoder.encode(category, StandardCharsets.UTF_8);
            do {
                String urlString = String.format(url + "=%s&page=%d", encodedCategory, page);
                JSONObject jsonObject = APICall.getAPIResponse(urlString);
                totalPages = jsonObject.getInt("total_pages");
                JSONArray data = jsonObject.getJSONArray("data");
                if (!data.isEmpty()) {
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject product = data.getJSONObject(i);
                        int price = product.getInt("price");
                        if (minPrice <= price && price <= maxPrice) {
                            totalProduct++;
                        }
                    }
                }
                page++;
            }while (page <= totalPages);

        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }

        return totalProduct;
}

private static JSONObject getAPIResponse(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try(BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(connection.getInputStream())
        )) {
            StringBuilder content = new StringBuilder();
            String lineRead;
            while ((lineRead = bufferedReader.readLine()) != null) {
                content.append(lineRead);
            }
            return new JSONObject(content.toString());
        } finally {
            connection.disconnect();
        }
    }

````