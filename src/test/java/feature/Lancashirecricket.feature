Feature: Test lancashirecricket
@LCC
Scenario: Test lancashirecricket Page

Given Launch the lancashirecricket Application
Then Click on Cricket option to go view circket updates
Then Click Fixtures & Results in the top nav
And click any results to visit the page
Then Refresh the page 5 times with a 10 second wait in between each refresh


@LCC
Scenario: Test News Module  of lancashirecricket Page

Given Launch the lancashirecricket App
Then Click on Cricket option to go view circket update
Then Click News in the Top navigation  to visit the page
And Check Clicked news page is displayed


@LCC
Scenario: Test News Module Emirates Old Trafford Page

Given Launch the lancashirecricket Applicatin
Then Click on Event option to go Events Update
Then Click News in the Top navigation
And Check news page is displayed

@LCC
Scenario: Test Enquire Module Emirates Old Trafford Page


Given Launch the lancashireCC Applicatin
Then Click on Event option to go Event Update
Then Click Enquire in the Top navigation
And Check  Enquire page is displayed
 