package com.meetSky.step_definitions;

import com.meetSky.pages.FilesPage_MeetSky;
import com.meetSky.pages.LoginPage_MeetSky;
import com.meetSky.utilities.ConfigurationReader;
import com.meetSky.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class File_functionalities_stepDefinitions {

    LoginPage_MeetSky loginPage_meetSky = new LoginPage_MeetSky();
    FilesPage_MeetSky filesPage_meetSky = new FilesPage_MeetSky();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        loginPage_meetSky.loginWithConfig();
    }

    //AC-01
    @When("User should click FILES icon at left top")
    public void user_should_click_files_icon_at_left_top() {
        loginPage_meetSky.filesButton.click();
    }
    @When("User should click PLUS sign")
    public void user_should_click_plus_sign() {
        filesPage_meetSky.plusIcon.click();
    }
    @When("Click the UPLOAD FILE option and select a file to upload.")
    public void click_the_option_and_select_a_file_to_upload() {
        String path = "/Users/emirizgubarlar/Downloads/hu-chen--ibpQdaorT8-unsplash.jpg";
        filesPage_meetSky.uploadFileButton.sendKeys(path);
    }
    @Then("Verify that the user can upload a file and see the uploaded file.")
    public void verify_that_the_user_can_upload_a_file_and_see_the_uploaded_file() {

    }

    //AC-02_1 --> DONE
    @When("Click the NEW FOLDER option and name the folder then click the arrow")
    public void click_the_option_and_name_the_folder_then_click_the_arrow() {
        filesPage_meetSky.plusIcon.click();
        filesPage_meetSky.plusIcon.click();
        filesPage_meetSky.newFolder.click();
        filesPage_meetSky.inputNewFolderName.clear();
        filesPage_meetSky.inputNewFolderName.sendKeys(ConfigurationReader.getProperty("new.file.name") + Keys.ENTER);
    }
    @Then("Verify that new created folder is appeared on the folder lists")
    public void verify_that_new_created_folder_is_appeared_on_the_folder_lists() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        boolean result = false;

        wait.until(ExpectedConditions.visibilityOf(filesPage_meetSky.visibility_control_file_info));

        Thread.sleep(4000);

        List<WebElement> list = filesPage_meetSky.listOfFiles;

        for (WebElement each : list) {
            if (each.getText().equalsIgnoreCase(ConfigurationReader.getProperty("new.file.name"))){
                result = true;
                if (result == true){
                    break;
                }
            }
        }

        Assert.assertTrue(result);
    }

    //AC-02_2 --> DONE
    @When("Click the NEW FOLDER option and name the folder with an already existing name then click the arrow")
    public void click_the_option_and_name_the_folder_with_an_already_existing_name_then_click_the_arrow() {
        filesPage_meetSky.plusIcon.click();
        filesPage_meetSky.plusIcon.click();
        filesPage_meetSky.newFolder.click();
        filesPage_meetSky.inputNewFolderName.clear();
        filesPage_meetSky.inputNewFolderName.sendKeys(ConfigurationReader.getProperty("new.file.name") + Keys.ENTER);
    }
    @Then("Verify that folderName already exists message is displayed")
    public void verify_that_already_exists_message_is_displayed() {
        Assert.assertTrue(filesPage_meetSky.getFileAlreadyExistsMessage.isDisplayed());
    }

    //AC-03_1 --> Done
    @When("User should click three dots of a folder and select Move or copy option")
    public void user_should_click_three_dots_of_a_folder_and_select_move_or_copy_option() {
        filesPage_meetSky.threeDots.click();
        filesPage_meetSky.moveOrCopy.click();
    }

    public static String copiedFileName;

    @When("user should select a target folder and click to copy to folderName")
    public void user_should_select_a_target_folder_and_click_to_copy_to_folder_name() {
        copiedFileName = filesPage_meetSky.copiedFile.getText();
        filesPage_meetSky.chooseTargetFolder.click();
        filesPage_meetSky.copyToButton.click();
    }
    @Then("verify that chosen folder is copied into the target folder")
    public void verify_that_chosen_folder_is_copied_into_the_target_folder() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(filesPage_meetSky.fileButton));
        Thread.sleep(4000);
        filesPage_meetSky.fileButton.click();

        boolean result = false;

        wait.until(ExpectedConditions.visibilityOf(filesPage_meetSky.visibility_control_file_info));

        List<WebElement> list = filesPage_meetSky.listOfFiles;

        for (WebElement each : list) {
            if (each.getText().equalsIgnoreCase(copiedFileName)){
                result = true;
                if (result == true){
                    break;
                }
            }
        }

        Assert.assertTrue(result);

    }

    //AC-03_2

    public static String movedFileName;
    @When("user should select a target folder and click to move to folderName")
    public void user_should_select_a_target_folder_and_click_to_move_to_folder_name() {
        movedFileName = filesPage_meetSky.copiedFile.getText();

        filesPage_meetSky.chooseTargetFolder.click();
        filesPage_meetSky.moveToButton.click();
    }
    @Then("verify that chosen folder is moved to the target folder")
    public void verify_that_chosen_folder_is_moved_to_the_target_folder() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(filesPage_meetSky.fileButton));
        filesPage_meetSky.fileButton.click();

        boolean result = false;


        wait.until(ExpectedConditions.visibilityOf(filesPage_meetSky.visibility_control_file_info));

        List<WebElement> list = filesPage_meetSky.listOfFiles;

        for (WebElement each : list) {
            if (each.getText().equalsIgnoreCase(movedFileName)){
                result = true;
                if (result == true){
                    break;
                }
            }
        }

        Assert.assertTrue(result);


    }

    //AC-04 --> DONE
    public static String fileName;

    @When("User should click three dots of a folder and select Delete folder option")
    public void user_should_click_three_dots_of_a_folder_and_select_option() {

         fileName = filesPage_meetSky.getFileName_2.getText();
        System.out.println(fileName);

        filesPage_meetSky.threeDotsDeleted.click();
        filesPage_meetSky.deleteFolderButton.click();
    }
    @Then("Verify that newly deleted file appeared inside the Deleted files")
    public void verify_that_newly_deleted_file_appeared_inside_the()  {

        filesPage_meetSky.deletedFilesButton.click();

        boolean result = false;

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(filesPage_meetSky.visibility_control_file_info_2));

        List<WebElement> list = filesPage_meetSky.listOfDeletedFiles;

        for (WebElement each : list) {
            System.out.println(each.getText());
            if (each.getText().equalsIgnoreCase(fileName)){
                result = true;
                if (result == true){
                    break;
                }
            }
        }

        Assert.assertTrue(result);

    }

    //AC-05 --> DONE
    @Then("Verify that User should see the total number of files and folders under the files list table")
    public void verify_that_user_should_see_the_total_number_of_files_and_folders_under_the_files_list_table() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(filesPage_meetSky.infoFiles));
        Assert.assertTrue(filesPage_meetSky.infoFiles.isDisplayed());
    }

    //AC-06_1 --> DONE
    @When("User should click PLUS sign and select the New text file option name the folder and click the arrow")
    public void user_should_click_plus_sign_and_select_the_new_text_file_option_name_the_folder_and_click_the_arrow() {
        filesPage_meetSky.plusIcon.click();
        filesPage_meetSky.newTextFile.click();
        filesPage_meetSky.inputNewTextName.clear();
        filesPage_meetSky.inputNewTextName.sendKeys(ConfigurationReader.getProperty("new.text.file.name"));
        filesPage_meetSky.textArrowButton.click();
        filesPage_meetSky.closeButton.click();
    }
    @Then("Verify that new created text file is appeared on the folder lists")
    public void verify_that_new_created_text_file_is_appeared_on_the_folder_lists()  {
        String expectedTextFileName = ConfigurationReader.getProperty("new.text.file.name");

        boolean result = false;

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(filesPage_meetSky.visibility_control_file_info));

        System.out.println("expectedTextFileName = " + expectedTextFileName);

        List<WebElement> list = filesPage_meetSky.listOfFilesName;

        System.out.println("------------------");

        for (WebElement each : list) {
            System.out.println(each.getText());
            if (each.getText().equalsIgnoreCase(expectedTextFileName)){
                result = true;
                if (result == true){
                    break;
                }
            }
        }

        Assert.assertTrue(result);

    }

    //AC-06_2 --> DONE
    @When("User should click PLUS sign and select the New text file option name the folder with an existing text file name and click the arrow")
    public void user_should_click_plus_sign_and_select_the_new_text_file_option_name_the_folder_with_an_existing_text_file_name_and_click_the_arrow() {
        filesPage_meetSky.plusIcon.click();
        filesPage_meetSky.newTextFile.click();
        filesPage_meetSky.inputNewTextName.clear();
        filesPage_meetSky.inputNewTextName.sendKeys(ConfigurationReader.getProperty("new.text.file.name")+".md");
    }
    @Then("Verify that textFileName already exists message is displayed")
    public void verify_that_message_is_displayed() {
        Assert.assertTrue(filesPage_meetSky.fileAlreadyExistsMessage.isDisplayed());
    }




}
