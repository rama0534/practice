# 1. Get temperature by city name
- A REST API contains weather details of various cities. Given a city name, get the current temperature of the city.
- To access the weather information, perform an HTTP GET request to: https://jsonmock.hackerrank.com/api/weather?name=<name>
where ‹name> is the city name to query. The name not case-sensitive.
- For example, a GET request to:
https://jsonmock.hackerrank.com/api/weather?name=Dallas
will return the weather information for Dallas.
- The response to a request is a JSON with the following 5 fields:
  - page: the current page of the results
  - per_page: the maximum number of results returned per page
  - total: the total number of results
  - total_ pages: the total number of pages with results
  - data: Either an empty array or an array of weather records as JSON objects. Return the data from the first record in the array. Each record has multiple properties but below properties are only needed for this question: o name: city name for which we have queried [STRING] o weather: weather conditions of the city in the format "‹temperature>
degree" [STRING] and value temperature here is an integer

- Below is an example of a weather record:
````
    {
        "page": 1,
        "per_page": 10,
        "total": 1,
        "total_pages": 1,
        "data": [
            {
                "name": "Dallas",
                "weather": "12 degree",
                "status": [
                    "Wind: 2Kmph",
                    "Humidity: 5%"
                ]
            },
            {
                "name": "Denver",
                "weather": "-3 degree",
                "status": [
                        "Wind: 10Kmph",
                        "Humidity: 73%"
                 ]
            },
            ....
        ]
    }
````