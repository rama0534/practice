# 1. List of movie names in ascending order
- In this challenge, the REST API contains information about movies. The provided API allows querying movies by subtitle. Your task is to list the movie name in ascending order.
- To access a collection of movies, perform GET requests to https://jsonmock.hackerrank.com/api/movies/search/?Title= where title is the movie title.
- sample output for https://jsonmock.hackerrank.com/api/movies/search/?title=world
````
{
    "page": 1,
    "per_page": 10,
    "total": 2770,
    "total_pages": 277,
    "data": [ 
                {
                "Title": "Waterworld",
                "Year": 1995,
                "imdbID": "tt0114898"
                },
                .....
        ]
}
````