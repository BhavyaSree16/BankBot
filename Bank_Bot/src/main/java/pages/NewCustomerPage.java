package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import utils.ConfigReader;

public class NewCustomerPage extends BasePage {

    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }

    private By newCustomerLink = By.linkText("New Customer");

    private By name = By.name("name");
    private By gender = By.xpath("//input[@value='f']");
    private By dob = By.name("dob");
    private By address = By.name("addr");
    private By city = By.name("city");
    private By state = By.name("state");
    private By pin = By.name("pinno");
    private By mobile = By.name("telephoneno");
    private By email = By.name("emailid");
    private By password = By.name("password");
    private By submit = By.name("sub");

    private By successMessage = By.xpath("//p[@class='heading3']");
    private By customerId = By.xpath("//td[text()='Customer ID']/following-sibling::td");

    public void clickNewCustomer() {
        click(newCustomerLink);
    }

    public void enterDOB() {
        driver.findElement(dob).clear();
        driver.findElement(dob).sendKeys(ConfigReader.get("custDob"));
    }

    public void fillCustomerForm(String email) {

        type(name, ConfigReader.get("custName"));
        click(gender);

        enterDOB(); // ✅ DOB from config

        type(address, ConfigReader.get("custAddress"));
        type(city, ConfigReader.get("custCity"));
        type(state, ConfigReader.get("custState"));
        type(pin, ConfigReader.get("custPin"));
        type(mobile, ConfigReader.get("custMobile"));
        type(this.email, email); // dynamic email
        type(password, ConfigReader.get("custPassword"));
    }

    public void submit() {
        click(submit);
    }

    public String getCustomerId() {
        return getText(customerId);
    }

    public String getSuccessMessage() {
        return getText(successMessage);
    }
}