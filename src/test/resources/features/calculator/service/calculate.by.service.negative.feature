Feature: As a calculator service client I want to be able to calculate returns for a deal even if no fx rate exists

  Scenario Outline: Given non USD amount and a deal and parameters calculate interest return to given currency if no fx rate exists
    Given No rates exist
    When I call calculator service with <currency> <amount> as amount
    And with annual rate <% rate>
    And with <period> years period
    And with <interval> compound interval
    Then the service should calculate to <return> <currency> return for <deal> interest deal
    Examples:
      | currency | amount  | % rate | period | interval  | return | deal   |
      | EUR      | 1000.00 | 10.6   | 1      | daily     | 111.80 | Simple |
      | TRL      | 1000.00 | 10.5   | 1      | none      | 105.00 | Annual |
      | USD      | 1000.00 | 10.5   | 1      | quarterly | 109.21 | Simple |
