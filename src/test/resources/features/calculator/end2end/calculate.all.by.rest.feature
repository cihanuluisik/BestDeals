Feature: As a calculate all RESTFul webservice client I want to be able to calculate aggregated returns of all deals of a customer

  Scenario : Given a customer with some deals then calculate aggregated returns of all his deals
    Given Following cross usd fx rates exist for the day :
      | currency | rate |
      | EUR      | 1.2  |
      | GBP      | 1.3  |
    And following customer exists :
      | id | name | surname |
      | 1  | Alex | Carter  |
    And following deals exist for the customer :
      | deal   | currency | amount  | % rate | period | interval  | usd return |
      | Simple | GBP      | 1000.00 | 10.5   | 1      | quarterly | 141.97     |
      | Annual | EUR      | 1000.00 | 10.5   | 1      | none      | 126.00     |
    When I call calculate all service with customer id as parameter
    Then the service should calculate to 267.97 USD