package SetupClass.StepDefinition;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SetupClass.SetupClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Email_Sign_up_Correct_Data_2 extends SetupClass {

	WebDriverWait wait = new WebDriverWait(driver, 50);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@Given("^user is already on Website Home Page ii$")
	public void user_is_already_on_Website_Home_Page_ii() throws Throwable {
		driver.get(AppURL);
		Thread.sleep(3000);
		ClearBrowserCache();

		Thread.sleep(3000);

	}

	@Then("^user navigates to sign up page ii$")
	public void user_navigates_to_sign_up_page_ii() throws Throwable {

		WebElement login_signup_btn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='signupclass']")));
		Thread.sleep(1000);
		login_signup_btn.click();
		Thread.sleep(4000);

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

		WebElement new_email = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_email")));
		new_email.clear();
		Thread.sleep(3000);
		new_email.sendKeys(full_email);
		Thread.sleep(3000);

		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_password")));
		password.clear();
		Thread.sleep(3000);
		password.sendKeys("Geeks@123");
		Thread.sleep(3000);

		WebElement confirm_passwoed = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_password2")));
		Thread.sleep(3000);
		confirm_passwoed.sendKeys("Geeks@123");
		Thread.sleep(3000);

		WebElement captcha = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#captchtext")));
		Thread.sleep(3000);
		captcha.sendKeys("Y3Tt6bfwI");
		Thread.sleep(3000);

		WebElement register_btn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pg-register-button-new")));
		Thread.sleep(3000);
		register_btn.click();
		Thread.sleep(5000);

		driver.get("https://www.slidegeeks.com/free-downloads");
		Thread.sleep(6000);

		WebElement Download = driver.findElement(
				By.xpath("/html/body/div[1]/div[3]/div/section[2]/div/div/div[1]/div/div[2]/div[1]/div/div/p/a/span"));

		// WebElement Download = (WebElement)js.executeScript("('a.btn-download')", "");
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", Download);
		Download.click();
		Thread.sleep(3000);

		// Apply Coupon
		driver.get("https://www.slidegeeks.com/subscriptions");
		Thread.sleep(4000);
		WebElement Join_now = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"div[id='Individual'] form[name='hikashop_product_form_205548_hikashop_category_information_menu_117']")));
		Thread.sleep(3000);
		Join_now.click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);
		WebElement Coupon = driver.findElement(By.cssSelector("label[for='discount-checkbox']"));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", Coupon);

		WebElement Add_Coupon = driver.findElement(By.xpath("//input[@id='hikashop_checkout_coupon_input_1_3']"));
		Thread.sleep(3000);
		Add_Coupon.sendKeys("5OFF");
		Thread.sleep(3000);
		Thread.sleep(3000);
		WebElement Apply_Coupon = driver.findElement(By.xpath("//button[normalize-space()='APPLY COUPON']"));
		Thread.sleep(3000);
		Apply_Coupon.click();
		Thread.sleep(3000);
		WebElement Remove_Coupon = driver.findElement(By.xpath("//button[@id='cancel_coupon']")); //
		Thread.sleep(3000);
		Remove_Coupon.click();
		Thread.sleep(3000);
		// Checkout
		WebElement place_order_btn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#hikabtn_checkout_next")));
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", place_order_btn);
		// js.executeScript("arguments[0].click();", place_order_btn);
		Thread.sleep(2000);
		place_order_btn.click();
		Thread.sleep(5000);

		String stripe_page_title = driver.getTitle();
		Thread.sleep(3000);
		System.out.println("Title of the Page is --> " + stripe_page_title);

		// String page_title="https://checkout.stripe.com/";
		String page_title = "SlideTeam Geeks Inc";

		if (page_title.equalsIgnoreCase(stripe_page_title)) {
			System.out.println(" user is on the Stripe page");
			log.info("USER IS ON THE STRIPE PAGE");
		} else {
			System.out.println("user is on the wrong page");
			log.info("USER IS ON THE WRONG PAGE");
		}

		Thread.sleep(3000);
		WebElement Stripe_back = driver.findElement(By.cssSelector(
				"#root > div > div > div.App-Overview > header > div > div > a > div > div > div.Header-backArrowContainer > svg"));
		Thread.sleep(2000);
		Stripe_back.click();

		if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		} else {
			System.out.println("Alert exists");
		}
		Thread.sleep(5000);

		// Delete Account

		WebElement Account = driver.findElement(By.xpath("//a[normalize-space()='Account']"));
		Thread.sleep(3000);
		Account.click();
		Thread.sleep(3000);
		WebElement Delete_Account = driver
				.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div/div[2]/div/ul/li[6]/a"));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", Delete_Account);
		Thread.sleep(3000);
		Delete_Account.click();
		Thread.sleep(3000);
		WebElement Delete_Account_reason = driver.findElement(By.cssSelector("#only-free-download-product"));
		Thread.sleep(3000);
		Delete_Account_reason.click();
		Thread.sleep(3000);
		WebElement Delete_Profile = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div[3]/button[1]"));
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
