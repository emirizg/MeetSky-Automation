Feature: US-003 Upload/Edit/Delete File Functionality
  Agile Story: As a user, I should be able to upload a file, move or delete any selected file under the Files module

  Background: Login as a user
    Given user is on the login page


    #1
  #Scenario: User can upload a file
   # When User should click FILES icon at left top
   # And User should click PLUS sign
    #And Click the UPLOAD FILE option and select a file to upload.
    #Then Verify that the user can upload a file and see the uploaded file.


    #2_1 --> DONE
  @ETSKY-866
  Scenario: User can create a new folder
    When User should click FILES icon at left top
    And User should click PLUS sign
    And Click the NEW FOLDER option and name the folder then click the arrow
    Then Verify that new created folder is appeared on the folder lists

    #2_2 Negative --> DONE
  @ETSKY-867
  Scenario: User can NOT create a new folder with already used name
    When User should click FILES icon at left top
    And User should click PLUS sign
    And Click the NEW FOLDER option and name the folder with an already existing name then click the arrow
    Then Verify that folderName already exists message is displayed


    #3_1
  @ETSKY-868
  Scenario: User can copy any selected item to any folder
    When User should click FILES icon at left top
    And User should click three dots of a folder and select Move or copy option
    And user should select a target folder and click to copy to folderName
    Then verify that chosen folder is copied into the target folder

    #3_2
  @ETSKY-869
  Scenario: User can move any selected item to any folder
    When User should click FILES icon at left top
    And User should click three dots of a folder and select Move or copy option
    And user should select a target folder and click to move to folderName
    Then verify that chosen folder is moved to the target folder

    #4 --> DONE
  @ETSKY-870
  Scenario: User can delete any selected item from its three dots menu
    When User should click FILES icon at left top
    And User should click three dots of a folder and select Delete folder option
    Then Verify that newly deleted file appeared inside the Deleted files

    #5 --> DONE
  @ETSKY-871
  Scenario: User can see the total number of files and folders under the files list table
    When User should click FILES icon at left top
    Then Verify that User should see the total number of files and folders under the files list table

    #6_1 --> DONE
  @ETSKY-872
  Scenario: User can create a new text document
    When User should click FILES icon at left top
    And User should click PLUS sign and select the New text file option name the folder and click the arrow
    Then Verify that new created text file is appeared on the folder lists

    #6_2 Negative --> DONE
  @ETSKY-873
  Scenario: User can NOT create a new text document with an existing text file name
    When User should click FILES icon at left top
    And User should click PLUS sign and select the New text file option name the folder with an existing text file name and click the arrow
    Then Verify that textFileName already exists message is displayed





