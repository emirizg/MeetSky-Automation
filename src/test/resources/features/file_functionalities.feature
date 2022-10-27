Feature: US-003 Upload/Edit/Delete File Functionality
  Agile Story: As a user, I should be able to upload a file, move or delete any selected file under the Files module


  Background: Login as a user
    Given user is on the login page

    #1
  Scenario: User can upload a file
    When User should click FILES icon at left top
    And User should click PLUS sign
    And Click the "UPLOAD FILE" option and select a file to upload.
    Then Verify that the user can upload a file and see the uploaded file.

    #2
  Scenario: User can create a new folder
    When User should click FILES icon at left top
    And User should click PLUS sign
    And Click the "NEW FOLDER" option and name the folder then click the arrow
    Then Verify that new created folder is appeared on the folder lists

    #3
  Scenario: User can move or copy any selected item to any folder
    When User should click FILES icon at left top
    And User should click three dots of a folder and select "Move or copy" option
    And user should select a target folder and click to "copy to folderName"
    Then Verify that "Choose target folder" frame is opened



    #4
  Scenario: User can delete any selected item from its three dots menu
    When User should click FILES icon at left top
    And User should click three dots of a folder and select "Delete folder" option
    Then Verify that newly deleted file appeared inside the "Deleted files"

      #5
  Scenario: User can see the total number of files and folders under the files list table
    When User should click FILES icon at left top
    Then Verify that User should see the total number of files and folders under the files list table

        #6
  Scenario: User can create a new text document
    When User should click FILES icon at left top
    And User should click PLUS sign and select the New text file option name the folder and click the arrow
    Then Verify that new created text file is appeared on the folder lists






