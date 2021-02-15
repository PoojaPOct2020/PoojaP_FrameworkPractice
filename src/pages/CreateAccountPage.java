package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import pojo.CreateAccountDetailspojo;

public class CreateAccountPage extends PredefinedActions {

	WebDriverWait wait;

	public boolean isPageHeadingTextDisplayed() {
		wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.textToBe(By.cssSelector("#noSlide h1"), "CREATE AN ACCOUNT"));
	}

	public void selectGendor(boolean isMale) {
		wait = new WebDriverWait(driver, 50);
		WebElement titleElement;
		System.out.println("STEP - Select title");
		if (isMale) {
			titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));
		} else {

			titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2")));
		}
		wait.until(ExpectedConditions.elementToBeClickable(titleElement));
		titleElement.click();
	}

	private void enterFirstName(String firstName) {
		if (firstName != null) {
			System.out.println("STEP - Enter First Name");
			driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
		} else {
			System.out.println("STEP - FirstName field is blank");
		}
	}

	private void enterLastName(String lastName) {
		if (lastName != null) {
			System.out.println("STEP - Enter Last Name");
			driver.findElement(By.id("customer_lastname")).sendKeys(lastName);

		} else {
			System.out.println("LastName field is blank");
		}
	}

	private void enterPassword(String password) {
		if (password != null) {
			System.out.println("STEP - Enter Password");
			driver.findElement(By.id("passwd")).sendKeys(password);

		} else {
			System.out.println("password field is blank");
		}
	}

	private void enterCompany(String company) {
		if (company != null) {
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("company"))).sendKeys("ABC");
			driver.findElement(By.id("company")).sendKeys(company);
		} else {
			System.out.println("company field is blank");
		}
	}

	private void enterAddressName(String addressName) {
		if (addressName != null) {
			driver.findElement(By.id("address1")).sendKeys(addressName);
		} else {
			System.out.println("address field is blank");
		}
	}

	private void enterCityName(String city) {
		if (city != null) {
			driver.findElement(By.id("city")).sendKeys(city);
		} else {
			System.out.println("city field id blank");
		}
	}

	private void enterState(String state) {
		if (state != null) {
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("uniform-id_state")))).click();
			Select s = new Select(driver.findElement(By.id("id_state")));
			s.selectByVisibleText(state);
		}
	}

	private void enterDay(String day) {
		if (day != null) {
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("uniform-days")))).click();
			Select s = new Select(driver.findElement(By.id("days")));
			s.selectByValue(day);

		} else {
			System.out.println("Day Field is not given ");
		}
	}

	private void enterMonth(String month) {
		if (month != null) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-months"))).click();
			Select s = new Select(driver.findElement(By.id("months")));
			s.selectByVisibleText(month+" ");
		} else {
			System.out.println("Month filed is not given");
		}
	}

	private void enterYear(String year) {
		if (year != null) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-years"))).click();
			Select s = new Select(driver.findElement(By.id("years")));
			s.selectByValue(year);
		} else {
			System.out.println("Year filed is not given");
		}
	}

	private void enterPostcode(String postCode) {
		if (postCode != null) {
			driver.findElement(By.id("postcode")).sendKeys(postCode);
		} else {
			System.out.println("PostCode Field is Blank ");
		}
	}

	private void enterAdditionalInfo(String additionalInfo) {
		if (additionalInfo != null) {
			driver.findElement(By.id("other")).sendKeys(additionalInfo);
		} else {
			System.out.println("AdditionalInfo Field is Blank");
		}
	}

	private void enterhomeMobileNumber(String homeMobileNumber) {
		if (homeMobileNumber != null) {
			driver.findElement(By.id("phone")).sendKeys(homeMobileNumber);
		} else {
			System.out.println("HomeMobileNumber Field is Blank");
		}
	}

	private void enterMobileNumber(String MobileNumber) {
		if (MobileNumber != null) {
			driver.findElement(By.id("phone_mobile")).sendKeys(MobileNumber);

		} else {
			System.out.println("MobileNumber field is blank");
		}
	}

	public void enterCreateAccountDetails(CreateAccountDetailspojo createAccountDetailspojo) {

		selectGendor(createAccountDetailspojo.isMale());
		enterFirstName(createAccountDetailspojo.getfName());
		enterLastName(createAccountDetailspojo.getLname());
		enterPassword(createAccountDetailspojo.getPassword());
		enterDay(createAccountDetailspojo.getDays());
		enterMonth(createAccountDetailspojo.getMonth());
		enterYear(createAccountDetailspojo.getYear());
		enterCompany(createAccountDetailspojo.getCompany());
		enterAddressName(createAccountDetailspojo.getAddress());
		enterCityName(createAccountDetailspojo.getCity());
		enterState(createAccountDetailspojo.getState());
		enterPostcode(createAccountDetailspojo.getPostcode());
		enterAdditionalInfo(createAccountDetailspojo.getAddtionalInfo());
		enterhomeMobileNumber(createAccountDetailspojo.getHomephone());
		enterhomeMobileNumber(createAccountDetailspojo.getMobileNumber());

	}
	public MyProfilePage clickOnRegistration() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submitAccount"))).click();
		System.out.println("Details Registered in Application");
		return new MyProfilePage();

	}

	/*public List<String> getErrorMessage() {
		List<WebElement> listOfErrorElement = driver.findElements(By.cssSelector("ol>li"));
		List<String>listOfErrorMessage = new ArrayList<String>();
		String errorCount=driver.findElement(By.cssSelector(".alert.alert-danger>p")).getText();
		listOfErrorMessage.add(0,errorCount);
		for(WebElement element :listOfErrorElement ) {
			listOfErrorMessage .add(element.getText());
		}
	return listOfErrorMessage;

	}*/
	
	public List<String> getErrorMsg() {
		List<WebElement> listOfErrorElement = driver.findElements(By.cssSelector("ol>li"));
		List<String> listOfErrorTxt = new ArrayList<String>();
		String errorCount = driver.findElement(By.xpath("//div[@class='alert alert-danger']/p")).getText();
		listOfErrorTxt.add(errorCount);
		for (WebElement element : listOfErrorElement) {
			listOfErrorTxt.add(element.getText());
		}
		return listOfErrorTxt;
	}
	}
