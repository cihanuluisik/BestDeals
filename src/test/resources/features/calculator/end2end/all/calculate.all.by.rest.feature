Feature: As a calculate all RESTFul webservice client I want to be able to calculate aggregated returns of all deals of a client

  Scenario: Given a client with some deals then calculate aggregated returns of all his deals
    Given Following cross usd fx rates exist :
      | currency | rate |
      | EUR      | 1.2  |
      | GBP      | 1.3  |
    And following client exists :
      | id | name | surname |
      | 1  | Alex | Carter  |
    And following deals exist for the client :
      | deal type | currency | amount  | rate | period | interval type |
      | Simple    | GBP      | 1000.00 | 10.5 | 1      | quarterly     |
      | Annual    | EUR      | 1000.00 | 10.5 | 1      | none          |
    When I call calculate all service with client id as parameter
    Then the service should calculate to 267.97 USD