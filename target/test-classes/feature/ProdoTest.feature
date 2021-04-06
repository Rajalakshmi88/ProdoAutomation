Feature: Test Franklin
@Prodo
Scenario Outline: Test the Franklin
Given Launch the Franklin Application
Then Enter username "<Username>" and password "<Password>" to login into tenant profile
Then Click on Account to view Account details
And Click on Make payment button to make a payment for House
Then Go to Payment Page and enter Customer Reference "<Reference>" and Amount "<Amount>"
Then Click Next button to complete the Payment
Then Click Repairs option in Home Page
Then Click Report Repair button to log the repair
Then Click the Bathroom option 
And Click Toilet Option
And Click Toilet is leaking Option
And Click Cistern Option and Submit the Repair


Examples:
|Username|Password|Reference|Amount|
|tenant@prodo.com|Digital2020!|Cust123|1002|