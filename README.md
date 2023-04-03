# Develop an API service that provides US stock dividend information

:page_with_curl: project introduction
- Analyze web pages and use scraping techniques to extract and save necessary data
- Can manage user-specific data and calculate expected dividend amount
- Understand the need for caching in services and configure cache servers

<br> 

:books: project stack
- Spring boot, Java
- H2 DB(memory DB Mode)
- To access the DB, use Spring data jpa
- Configuring the cache server utilizes Embedded redis
- Each API has its own request and response object structure.


DB
###Company
![image](https://user-images.githubusercontent.com/94863168/229596475-a4978324-782d-4340-bb45-e2827f98500f.png)
###Dividend
![image](https://user-images.githubusercontent.com/94863168/229596489-744b9ebc-7683-4bad-936d-6c13eae2ba2e.png)

<br>

:black_circle: Project function

<br>

:one: API description
<br>
1. GET - finance/dividen/{companyName} 
- Receives a company name as input and returns the company's meta information and dividend information
- 잘Returns 400 status code and error message when wrong company name is input

<br>

2. GET - company/autocomplete
- API for autocomplete functionality
- Receives the prefix to be searched as an input and returns 10 of the list of company names searched for with the prefix.

<br>

3. GET - company
- Returns a list of all companies managed by the service
- The return result is in the form of a Page interface.

<br>

4. POST - company
- Add new company information
- Receive the ticker of the company you want to add as an input, scrape and save the information of the company
- Returns a 400 status code and an appropriate error message if the company's information is already in your possession
- Returns 400 status code and appropriate error message for non-existent company ticker

<br>

5. DELETE - company/{ticker}
- Delete the company information corresponding to the ticker
- When deleting, the company's dividend information and cache must also be deleted.

<br>


6. POST - auth/signup
- Membership API
- Duplicate IDs not allowed
- Passwords must be stored in encrypted form

<br>


7. POST - auth/signin
- Login API
- If registered as a member and the ID/password information is correct, JWT is issued


