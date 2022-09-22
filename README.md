**Getting the timeline and Posting to a Twitter**

**Getting timeline in the root**
- To start the project first run the springTwitter application in the background

- In the next step open the onboarding-ui application and run this application in the terminal by typing: *node src/main.js* or *nodemon src/main.js*

- Now in the browser type *localhost:9000* to get the timeline

**For getting timeline in json format and posting tweet in twitter**
- Open the postman website
- In the *GET* method type *http://localhost:8080/api/1.0/twitter/timeline* to get the timeline from the twitter account
- In the *GET* method type *http://localhost:8080/api/1.0/twitter/timeline/filter* to get filtered tweets (Note - in this project i have filtered tweets with keyword -*India*)
- In the *POST* method type *http://localhost:8080/api/1.0/twitter/tweet* and in the body , select raw and type the text you want to post it on twitter.
The *GET* method works on browser too but *POST* method works only in Postman.

(Note : In the customer.yml file in the springTwitter application type the api keys and access tokens what you have generated in the twitter developer account)
