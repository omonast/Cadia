Narrative:
As a user
I should be able to send a request
So that I can get a information in response (only GETS)

Scenario: [GET] Sample test /w Kharkiv
When User sends a forecast request for 'Kharkiv' city
Then User gets response for 'Kharkiv' city
And User sees city id '706483' in response

Scenario: [GET] Test /w invalid query parameter
When User sends a forecast request for 'Sonic the Hedgehog' city
Then User gets 404 in response for 'Sonic the Hedgehog' city

Scenario: [GET] Test 5 days schedule
When User sends a forecast request for 'Kharkiv' city and 'ua'
Then User gets 200 OK in response for 'Kharkiv' and 'UA'
And User prints response body

Scenario: [GET] Test /w coordinates params
When User sends a forecast request with coordinates '36.23' and '49.99'
Then User gets response for 'Kharkiv' city

Scenario: [GET] Test /w invalid coordinates params
When User sends a forecast request with coordinates '999999999.99' and '9999999999.99'
Then User gets 400 in response