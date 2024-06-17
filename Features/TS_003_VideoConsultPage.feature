Feature: TS_003_VideoConsult validation

  Scenario: VideoConsult Page
    Given Navigate to video Consult page
    When Locate the video consult element
    Then Validate Consult Now button is present
    When Get all specialities datas
    Then Validate specialities availability
    When Get all Common Health Concern datas and price
    Then Validate CommonHealthConcern availability
    When Get all Offer details
    Then Validate Consult Offers availability
