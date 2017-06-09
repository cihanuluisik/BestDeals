Feature: As a calculator service client I want to be able to calculate return of a deal

  Scenario Outline: Given USD amount and a deal and parameters calculate interest return
    When I call calculator service with <currency> <amount> as amount
    And with annual rate <% rate>
    And with <period> years period
    And with <interval> compound interval
    Then the service should calculate to <usd return> USD return for <deal> interest deal
    Examples:
      | currency | amount  | % rate | period | interval   | usd return | deal   |
      | USD      | 1000.00 | 10.6   | 1      | daily      | 111.80     | Simple |
      | USD      | 1000.00 | 10.5   | 1      | monthly    | 110.20     | Simple |
      | USD      | 1000.00 | 10.5   | 1      | quarterly  | 109.21     | Simple |
      | USD      | 1000.00 | 10.5   | 2      | biannually | 227.12     | Simple |
      | USD      | 1000.00 | 10.5   | 1      | yearly     | 105.00     | Simple |
      | USD      | 1000.00 | 10.5   | 1      | none       | 105.00     | Annual |


  Scenario Outline: Given non USD amount and a deal and parameters calculate interest return
    Given Following cross usd fx rates exist for the day :
      | currency | rate |
      | EUR      | 1.2  |
      | GBP      | 1.3  |
    When I call calculator service with <currency> <amount> as amount
    And with annual rate <% rate>
    And with <period> years period
    And with <interval> compound interval
    Then the service should calculate to <usd return> USD return for <deal> interest deal
    Examples:
      | currency | amount  | % rate | period | interval  | usd return | deal   |
      | GBP      | 1000.00 | 10.5   | 1      | quarterly | 141.97     | Simple |
      | EUR      | 1000.00 | 10.5   | 1      | none      | 126.00     | Annual |