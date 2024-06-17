Feature: TS_005_SearchPage validation

  Scenario: Practo Search City
    When Select Bangalore city and Search Hospitals
    Then Validate Bangalore city hospitals are displayed
    When Locate all day opened hospitals element
    Then Validate all day hospitals opened
    When Get the rating of more than three hospitals
    Then Validate the hospitals more than three of rating
    When Get the top city hospitals
    Then Validate top city hospitals
