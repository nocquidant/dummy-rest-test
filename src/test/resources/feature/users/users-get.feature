Feature: get user

Background:
* url baseUrl

Scenario: Test GET request exact response

Given path '/user/get'
When method GET
Then status 200
And match $ == {id:"#notnull",name:"John Smith"}