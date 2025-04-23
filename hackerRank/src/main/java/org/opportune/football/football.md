# 1. REST API: Total Goals by a Team
- In this challenge, the REST API contains information about football matches. The provided API allows querying matches by teams and year. 
Your task is to get the total number of goals scored by a given team in a given year.
- To access a collection of matches, perform GET requests to
https://jsonmock.hackerrank.com/api/football_matches?year=<year>&team1=<team>&page= <page>
https://jsonmock.hackerrank.com/api/football_matches?year=<year>&team2=<team>&page= <page>
where < year> is the year of the competition, < team> is the name of the team, and <page> is the page of the results to request. 
The results might be divided into several pages. Pages are num @red from 1.
- Notice that the above two URLs are different. The first URL specifies the team1 parameter (denoting the home team) while the second URL specifies the team parameter (denoting the visiting team). Thus, in order to get all matches that a particular team played in, you need to retrieve matches where the team was the home team and the visiting team.
- For example, a GET request to
https://jsonmock.hackerrank.com/api/football_matches?year=2011&team1=Barcelona&page=1
returns data associated with matches in the year 2011, where team1 (the home team) was Barcelona, on the second page of the results.
- Similarly, a GET request to
https://jsonmock.hackerrank.com/api/football_matches?year=2011&team2=Barcelona&page=1
returns data associated with matches in the year 2011 where team2 (the visiting team) was Barcelona, on the first page of the results.
- The response to such a request is a JSON with the following 5 fields:
  - page: The current page of the results.
  - per_page: The maximum number of matches returned per page.
  - total: The total number of matches on all pages of the results.
  - total_pages: The total number of pages with results.
  - data: An array of objects containing matches information on the requested page.
  - Sample output for https://jsonmock.hackerrank.com/api/football_matches?year=2011&team1=Barcelona&page=1
  ```
   {
      "page": 1,
      "per_page": 10,
      "total": 6,
      "total_pages": 1,
      "data": [
                  {
                      "competition": "UEFA Champions League",
                      "year": 2011,
                      "round": "GroupH",
                      "team1": "Barcelona",
                      "team2": "AC Milan",
                      "team1goals": "2",
                      "team2goals": "2"
                  },
                    .....
     ]     
  }
  ```
# 2. Number of Drawn matches
- Use the URL https://jsonmock.hackerrank.com/api/football_matches?year=%d&team1goals=%d&team2goals=%d to get the draw matches for a specific year.
- The Goal range from 0 to 10
- Sample output for https://jsonmock.hackerrank.com/api/football_matches?year=2011&team1goals=0&team2goals=0
```
  {
      "page": 1,
      "per_page": 10,
      "total": 162,
      "total_pages": 17,
      "data": [
          {
              "competition": "UEFA Champions League",
              "year": 2011,
              "round": "GroupE",
              "team1": "KRC Genk",
              "team2": "Valencia CF",
              "team1goals": "0",
              "team2goals": "0"
          },
          .....
     ]
 }
 ```
# 3. Football competition winner team goal
- To access winner perform GET requests to https://jsonmock.hackerrank.com/api/football_competitions/?year=%d&name=%s where name is league name.
- sample output for https://jsonmock.hackerrank.com/api/football_competitions/?year=2011&name=English%20Premier%20League
``` 
 {
    "page": 1,
    "per_page": 10,
    "total": 1,
    "total_pages": 1,
    "data": [
        {
        "name": "English Premier League",
        "country": "England",
        "year": 2011,
        "winner": "Manchester City",
        "runnerup": "Manchester United"
        }
    ]
}
```