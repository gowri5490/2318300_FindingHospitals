Feature: TS_004_Surgeries Page Validation

  Scenario: Surgeries Page
    Given Navigate to Surgeries Page
    When Get PractoCare Phone number
    Then Validate the Phone number
    When Get Popular Surgeries data
    Then Validate the Popular Surgeries
    When Get Our Departments data
    Then Valiadate the Our Departments
    When Get the PractoCare Benifits Data
    Then Validate PractoCare Data availability

  
