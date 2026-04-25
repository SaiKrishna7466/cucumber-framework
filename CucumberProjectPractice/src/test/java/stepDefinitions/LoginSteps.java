package stepDefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;
import pages.LoginPage;
import pages.HomePage;
import base.BaseClass;
import io.cucumber.java.en.*;

public class LoginSteps {
	
	LoginPage loginPage;
    HomePage homePage;

    @Given("user is on login page {string}")
    public void open_login_page(String url) {
        BaseClass.driver.get(url);
        loginPage = new LoginPage(BaseClass.driver);
    }

    @When("user enters username {string} and password {string}")
    public void enter_credentials(String username, String password) {
    	BaseClass.driver.findElement(By.id("username")).sendKeys(username);
        BaseClass.driver.findElement(By.id("password")).sendKeys(password);
    }
    
    @When("user enters the username {string} and password {string}") 
    public void enterCredentials(String user, String pass){
    	 loginPage.enterUsername(user);
         loginPage.enterPassword(pass);
    }
    
    @And("user clicks login button")
    public void click_login() {
    	BaseClass.driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
    
    @And("user clicks on Login button")
    public void clickLogin() {
    	 loginPage.clickLogin();
    }
    
    
    @Then("user should be logged in successfully")
    public void verify_login() {
        String message = BaseClass.driver.findElement(By.id("flash")).getText();
        System.out.println("Login message: " + message);
        Assert.assertEquals(message,"You logged into a secure area!");
    }
    
    @Then("user should be logged into home page successfully")
    public void verifyLogin() {
    	 homePage = new HomePage(BaseClass.driver);

         String actualTitle = homePage.getPageTitle();
         System.out.println("Login message: " + actualTitle);

         Assert.assertEquals(actualTitle, "Products");
    }

}
