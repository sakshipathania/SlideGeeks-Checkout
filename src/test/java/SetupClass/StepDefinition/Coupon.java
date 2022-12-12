package SetupClass.StepDefinition;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SetupClass.SetupClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Coupon extends SetupClass {

	WebDriverWait wait = new WebDriverWait(driver, 60);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@Given("^user is already on Website Home Page cc$")
	public void user_is_already_on_Website_Home_Page_cc() throws Throwable {
		driver.get(AppURL);
		Thread.sleep(3000);
		ClearBrowserCache();

		Thread.sleep(3000);

		WebElement pricing = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Pricing']")));
		pricing.click();
		Thread.sleep(2000);
		WebElement Join_now = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@id = 'Individual']/div[1]/div[2]/div[3]/span[1]/form[1]/a[1]/span[1]")));

		Join_now.click();
		Thread.sleep(3000);

		System.out.println("user shoud be on login page = " + driver.getCurrentUrl());
		WebElement signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='signupclass']")));

		signup.click();
		Thread.sleep(3000);
		driver.get("https://www.slidegeeks.com/register?checkout=1&74.44");
		Thread.sleep(3000);

		WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_name")));
		Thread.sleep(3000);
		name.sendKeys("Automated Program");
		Thread.sleep(3000);

		// Generate Random Email Address
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();

		System.out.println(generatedString);

		String signup_email = generatedString;
		String full_email = "selenium.testing." + generatedString + "@gmail.com";
		System.out.println(full_email);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);

		/*
		 * WebElement name = wait
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//input[@id='site_signup_name']"))); Thread.sleep(3000);
		 * name.sendKeys("Automated Program"); Thread.sleep(3000);
		 * 
		 * WebElement new_email = wait
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//input[@id='site_signup_email']"))); new_email.sendKeys(full_email);
		 * Thread.sleep(3000); WebElement password = wait
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//input[@id='site_signup_password']"))); password.sendKeys("Geeks@123");
		 * WebElement captcha =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//input[@id='captchtext']"))); captcha.sendKeys("Y3Tt6bfwI"); WebElement
		 * selectRadioBtn = wait
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//input[@id='site_signup_checkbox']"))); selectRadioBtn.click(); WebElement
		 * register_btn = wait .until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//button[@id='site_signup_btn']"))); Thread.sleep(3000);
		 * register_btn.click(); Thread.sleep(5000);
		 */

		// without pop-up

		WebElement new_email = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_email")));
		new_email.clear();
		new_email.sendKeys(full_email);
		Thread.sleep(3000);

		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_password")));
		password.clear();
		password.sendKeys("Geeks@123");
		Thread.sleep(3000);

		WebElement confirm_passwoed = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_password2")));
		confirm_passwoed.sendKeys("Geeks@123");
		Thread.sleep(3000);

		/*
		 * WebElement captcha =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
		 * "#captchtext"))); captcha.sendKeys("Y3Tt6bfwI"); Thread.sleep(3000);
		 */

		WebElement register_btn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pg-register-button-new")));
		register_btn.click();
		Thread.sleep(5000);

	}

	@Then("^user is redirected to pricing page and choose the plan to pay cc$")
	public void user_is_redirected_to_pricing_page_and_choose_the_plan_to_pay_cc() throws Throwable {

	}

	@Then("^user is redirected checkout page cc$")
	public void user_is_redirected_checkout_page_cc() throws Throwable {
		System.out.println("user shoud be on checkout page = " + driver.getCurrentUrl());

	}

	@Then("^user proceed to pay with paypal pp cc$")
	public void user_proceed_to_pay_with_paypal_pp_cc() throws Throwable {

		try {
			WebElement cp_btn = driver.findElement(By.xpath("//label[@for='payment_radio_1_2__stripe_2']"));
			Thread.sleep(2000);
			cp_btn.click();
			Thread.sleep(3000);
		} catch (NoSuchElementException popup) {
			// TODO: handle exception
		}

		// Apply coupon
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);
		WebElement Coupon = driver.findElement(By.cssSelector("label[for='discount-checkbox']"));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", Coupon);

		WebElement Add_Coupon = driver.findElement(By.xpath("//input[@id='hikashop_checkout_coupon_input_1_3']"));
		Thread.sleep(3000);
		Add_Coupon.sendKeys("5OFF");
		Thread.sleep(3000);
		WebElement Apply_Coupon = driver.findElement(By.xpath("//button[normalize-space()='APPLY COUPON']"));
		Thread.sleep(3000);
		Apply_Coupon.click();
		Thread.sleep(3000);

		System.out.println("copon applied");
		// Remove Coupon
		WebElement Remove_Coupon = driver.findElement(By.xpath("//button[@id='cancel_coupon']")); //
		Thread.sleep(3000);
		Remove_Coupon.click();
		Thread.sleep(3000);

		// Aplly Coupon Again // WebElement Coupon1= //
		driver.findElement(By.cssSelector("label[for='discount-checkbox']")); //
		Thread.sleep(3000); // Coupon1.click(); // Thread.sleep(3000);
		WebElement Add_Coupon1 = driver.findElement(By.xpath("//input[@id='hikashop_checkout_coupon_input_1_3']"));
		Thread.sleep(3000);
		Add_Coupon1.sendKeys("5OFF");
		Thread.sleep(3000); //
		WebElement Apply_Coupon1 = driver.findElement(By.xpath("//button[normalize-space()='APPLY COUPON']"));
		Thread.sleep(3000);
		Apply_Coupon1.click();
		Thread.sleep(3000);

		WebElement Value_after_coupon = driver.findElement(By.cssSelector(".cart_price"));

		String expected = "$47.49";
		String actual = Value_after_coupon.getText();
		System.out.println("after coupon applied price is = " + actual);

		Assert.assertTrue("Price does not matched", actual.equals("$47.49"));

		Thread.sleep(1000);
		try {

			WebElement place_order_btn = driver.findElement(By.xpath("//button[@id='hikabtn_checkout_next']"));
			Thread.sleep(2000);
			js.executeScript("arguments[0].scrollIntoView();", place_order_btn);
			// js.executeScript("arguments[0].click();", place_order_btn);
			Thread.sleep(2000);
			place_order_btn.click();
			Thread.sleep(5000);
		} catch (NoSuchElementException popup) {
		}

	}

	@Then("^paypal popup appears and user navigates back to my account pp cc$")
	public void paypal_popup_appears_and_user_navigates_back_to_my_account_pp_cc() throws Throwable {

		// page title
		String pp_page_title = driver.getTitle();
		Thread.sleep(3000);
		System.out.println("Title of the Page is --> " + pp_page_title);

	}

	@Then("^user Signout account PP cc$")
	public void user_Signout_account_PP_cc() throws Throwable {
		Thread.sleep(3000);
		driver.get("https://www.slidegeeks.com/checkout");
		Thread.sleep(2000);
		WebElement Account = driver.findElement(By.xpath("//a[normalize-space()='Account']//i"));
		Thread.sleep(3000);
		Account.click();
		Thread.sleep(3000);
		WebElement Delete_Account = driver.findElement(By.xpath("//a[normalize-space()='Delete Account']"));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", Delete_Account);
		Thread.sleep(3000);
		Delete_Account.click();
		Thread.sleep(3000);
		WebElement Delete_Account_reason = driver.findElement(By.cssSelector("#only-free-download-product"));
		Thread.sleep(3000);
		Delete_Account_reason.click();
		Thread.sleep(3000);
		WebElement Delete_Profile = driver.findElement(By.xpath("//button[@id='delete_profile']"));
		Thread.sleep(3000);
		Delete_Profile.click();
		Thread.sleep(3000);
		WebElement No_Delete = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div[3]/button[2]"));
		Thread.sleep(3000);
		No_Delete.click();
		Thread.sleep(30000);
		String verifyDeleteAccountMessage = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='alert-message login-sucesmsg']")))
				.getText();
		System.out.println("verifyText1 = " + verifyDeleteAccountMessage);
		Assert.assertTrue("Your are not on paypal page",
				verifyDeleteAccountMessage.contentEquals("Your Account has been deleted successfully."));
		Thread.sleep(3000);

	}

}
