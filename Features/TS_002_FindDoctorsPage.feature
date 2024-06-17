Feature: TS_002_FindDoctors validation

  Scenario: FindDoctors Page
    Given Navigate to Find Doctors page
    When Send the value to searchbox
    Then Validate the Doctors Name
    And Valiadate the Book Free option
