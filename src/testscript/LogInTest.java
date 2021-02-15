package testscript;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.MyProfilePage;
import pojo.CreateAccountDetailspojo;

public class LogInTest extends TestBase {
	
	
	@Test
	public void automationPracticeLogin() {

		
		HomePage homePage = new HomePage();

		System.out.println("STEP - Click On SignIn");
		AuthenticationPage authenticationPage = homePage.ClickOnSignIn();

		System.out.println("STEP - Authentication Header is Display");

		boolean AuthenticationHeader = authenticationPage.isAuthenticationHeaderVisible();
		Assert.assertTrue(AuthenticationHeader);

		System.out.println("STEP - Enter Email-Address");
		authenticationPage.enterEmailAddress("mlkhb@gmail.com");

		CreateAccountPage createAccountPage = authenticationPage.clickOnCreateAccount();
		System.out.println("Verify Create Account Header Text");
		boolean headingText = createAccountPage.isPageHeadingTextDisplayed();
		Assert.assertTrue(headingText,"Header Text is not display");
		System.out.println("Navigate to create account page");
		CreateAccountDetailspojo createAccountDetailspojo = new CreateAccountDetailspojo();
		createAccountDetailspojo.setMale(true);
		createAccountDetailspojo.setfName("pooja");
		createAccountDetailspojo.setLname("pekhale");
		createAccountDetailspojo.setPassword("123245664");
		createAccountDetailspojo.setDays("20");
		createAccountDetailspojo.setMonth("January");
		createAccountDetailspojo.setYear("1996");
		createAccountDetailspojo.setCompany("EC-Mobility");
		createAccountDetailspojo.setAddress("pinto-Colony Tal & Dis -Nashik");
		createAccountDetailspojo.setCity("Nashik");
		createAccountDetailspojo.setState("Maine");
		createAccountDetailspojo.setPostcode("00000");
		createAccountDetailspojo.setAddtionalInfo("PQR");
		createAccountDetailspojo.setHomephone("0253-2228087");
		createAccountDetailspojo.setMobileNumber("7030402323");
		createAccountDetailspojo.setAliasAddress("NA");
		createAccountPage.enterCreateAccountDetails(createAccountDetailspojo);
		MyProfilePage myProfilePage = createAccountPage.clickOnRegistration();

		String actual = myProfilePage.getHeaderText();
		String expected = "pooja pekhale";

		Assert.assertEquals(actual, expected, "Verification not happend");

	}
	@Test
	public void loginTestUIValidationTest() {
		
		HomePage homePage = new HomePage();

		System.out.println("STEP-ClickedOnSignIn");
		AuthenticationPage authenticationPage = homePage.ClickOnSignIn();

		System.out.println("Verify-Authentication Header is displayed");
		boolean authenticationHeaderFlag = authenticationPage.isAuthenticationHeaderVisible();
		Assert.assertTrue(authenticationHeaderFlag);

		System.out.println("STEP-Enter E-mail Address");
		authenticationPage.enterEmailAddress("klhgf@gmail.com");
		CreateAccountPage createAccoutnPage = authenticationPage.clickOnCreateAccount();

		System.out.println("Verify-Create Account Header");
		boolean isHeadingText = createAccoutnPage.isPageHeadingTextDisplayed();
		Assert.assertTrue(isHeadingText, "Header Text was not Displayed");

		System.out.println("Navigate to create account page");
		CreateAccountDetailspojo creatAccountDetailsPojo = new CreateAccountDetailspojo();
		// creatAccountDetailsPojo.setMale(true);
		// creatAccountDetailsPojo.setfName("Yogita");

		createAccoutnPage.enterCreateAccountDetails(creatAccountDetailsPojo);
		MyProfilePage profilePage = createAccoutnPage.clickOnRegistration();
		List<String> expectdErrorMessages = new ArrayList<String>();
		expectdErrorMessages.add("There are 8 errors");
		expectdErrorMessages.add("You must register at least one phone number.");
		expectdErrorMessages.add("lastname is required.");
		expectdErrorMessages.add("firstname is required.");
		expectdErrorMessages.add("passwd is required.");
		expectdErrorMessages.add("address1 is required.");
		expectdErrorMessages.add("city is required.");
		expectdErrorMessages.add("The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
		expectdErrorMessages.add("This country requires you to choose a State.");

		List<String> actualErrorMessages = createAccoutnPage.getErrorMsg();
		System.out.println("Print Actual Error Messages");
		System.out.println(actualErrorMessages);

		System.out.println("Print Expected Error Messages");
		System.out.println(expectdErrorMessages);
		Assert.assertEquals(actualErrorMessages, expectdErrorMessages);

	}
}
