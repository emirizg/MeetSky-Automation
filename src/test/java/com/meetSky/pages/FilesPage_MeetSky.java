package com.meetSky.pages;

import com.meetSky.utilities.ConfigurationReader;
import com.meetSky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage_MeetSky {

    public FilesPage_MeetSky(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement plusIcon;

    @FindBy(xpath = "//span[text()='Upload file']")
    public WebElement uploadFileButton;

    @FindBy(xpath = "//span[@class='info']")
    public WebElement infoFiles;



    @FindBy(xpath = "//span[@class='nametext']/span[1]")
    public WebElement getFileName;

    @FindBy(xpath = "(//a[@data-action='menu'])[10]/../preceding-sibling::span/span[1]")
    public WebElement getFileName_2;

    @FindBy(xpath = "//a[@data-action='Delete']")
    public WebElement deleteFolderButton;

    @FindBy(xpath = "//a[text()='Deleted files']")
    public WebElement deletedFilesButton;

    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> listOfDeletedFiles;

    @FindBy(xpath = "//span[text()='New text file']")
    public WebElement newTextFile;

    @FindBy(xpath = "//input[@id='view11-input-file']")
    public WebElement inputNewTextName;

    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement textArrowButton;

    @FindBy(xpath = "//button[@class='action-item action-item--single header-close undefined undefined has-tooltip']")
    public WebElement closeButton;

    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> listOfFilesName;

    @FindBy(xpath = "//div[contains (@id,'tooltip')]")
    public WebElement fileAlreadyExistsMessage;

    @FindBy(xpath = "//span[text()='New folder']")
    public WebElement newFolder;

    @FindBy(id = "view11-input-folder")
    public WebElement inputNewFolderName;

    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> listOfFiles;

    @FindBy(xpath = "//div[@class='tooltip-inner']")
    public WebElement getFileAlreadyExistsMessage;

    @FindBy(xpath = "(//span[.='Move or copy'])[2]")
    public WebElement moveOrCopy;

    @FindBy(xpath = "//tr[@data-entryname='file6']")
    public WebElement chooseTargetFolder;

    //to check if it clickable
    @FindBy(xpath = "//span[@class='nametext']//span[text()='file6']")
    public WebElement fileButton;

    @FindBy(xpath = "//button[contains (text(), 'Copy to')]")
    public WebElement copyToButton;

    @FindBy(xpath = "(//span[.='Talk'])[3]")
    public WebElement talkFileButton;

    @FindBy(xpath = "(//a[@data-action='menu'])[8]/../preceding-sibling::span/span[1]")
    public WebElement copiedFile;

    @FindBy(xpath = "(//a[@data-action='menu'])[8]")
    public WebElement threeDots;

    @FindBy(xpath = "(//a[@data-action='menu'])[10]")
    public WebElement threeDotsDeleted;

    @FindBy(xpath = "//button[@class='primary']")
    public WebElement moveToButton;

    @FindBy(xpath = "//span[@class='info']")
    public WebElement visibility_control_file_info;

    @FindBy(xpath = "(//span[@class='info'])[2]")
    public WebElement visibility_control_file_info_2;


}
