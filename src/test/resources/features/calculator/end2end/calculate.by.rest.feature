Feature: As a calculator RESTFul webservice client I want to be able to calculate returns for deal(s)

  Scenario Outline: Call calculator RESTFul webservice
    When I call calculator webservice with <currency> <amount> amount
    And annual rate <% rate>
    And for <period> years period
    And by <interval> compound interval
    Then the webservice should calculate to <usd return> USD return for <deal> interest deal
    Examples:
      | currency | amount  | % rate | period | interval  | usd return | deal   |
      | USD      | 1000.00 | 10.5   | 1      | yearly    | 105.00     | Simple |
      | USD      | 1000.00 | 10.5   | 1      | none      | 105.00     | Annual |