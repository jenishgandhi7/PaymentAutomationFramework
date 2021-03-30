package cucumberStepDefine;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObjects.paymentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.base_config;

public class StepDefine extends base_config {

	paymentPage cp;
	String amounts, Emails;
	WebDriverWait wait;

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver = initalizerDriver();
		wait = new WebDriverWait(driver, 10);

	}

	@When("^Enter User Information  (.+), (.+), (.+), (.+) and (.+)$")
	public void enter_user_information_and(String firstname, String lastname, String email, String company,
			String description) throws Throwable {

		Emails = email;

		cp.getFirstName().sendKeys(firstname);
		cp.getLastName().sendKeys(lastname);
		cp.getEmail().sendKeys(email);
		cp.getCompany().sendKeys(company);
		cp.getDescription().sendKeys(description);
		Thread.sleep(1000);

	}

	@Then("^Verify that Payment on Confirmation page$")
	public void verify_that_payment_on_confirmation_page() throws Throwable {

		cp.getTerms().click();
		cp.getSubmit().click();

		WebElement conf_text;
		conf_text = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@data-testid='confirmation-number']")));
		String conf_number = conf_text.getText();

		System.out.println(conf_number);

		String verify_payment_schedule = driver
				.findElement(By.xpath("//h6[@data-testid='payment-schedule-description']")).getText().replace("-", " ")
				.toUpperCase();
		System.out.println(verify_payment_schedule);

//		Assert.assertEquals(verify_payment_schedule, PaymentScheduleType.toUpperCase());

		String verify_amt = driver.findElement(By.xpath("//h6[@data-testid='payment-amount']")).getText()
				.replace("$", " ").trim();
		System.out.println(verify_amt);
		Assert.assertEquals(verify_amt, amounts);

		String conf_email = driver.findElement(By.xpath("//div[@data-testid='conf-email-copy']/strong")).getText();
		System.out.println(conf_email);
		Assert.assertEquals(conf_email, Emails);

		Thread.sleep(1000);
	}

	@And("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_something_site(String strArg1) throws Throwable {
		driver.get(strArg1);

		cp = new paymentPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement visibleText;
		visibleText = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h5[@data-testid='payment-form-header-title']")));
		visibleText.getText();

	}

	@And("^Enter Payment amount (.+) and Payment Schedule (.+) with (.+)$")
	public void enter_payment_amount_and_payment_schedule_with(String amount, String scheduletype, String schedulefrq)
			throws Throwable {
		amounts = amount;
		
		cp.getPaymentAmount().sendKeys(amount);
		if (scheduletype.equals("Recurring Payment")) {
			cp.getPaymentScheduleTypeSelect().click();
			cp.getRecurringPayment().click();
			if (schedulefrq.trim().equals("Monthly")) {
				cp.getPaymentScheduleFrequencySelect().click();
				cp.getMonthly().click();
			}

		} else {
			cp.getOneTimePayment().click();
		}
		Thread.sleep(1000);

	}

	@And("^Enter Credit Card  Details as (.+), (.+), (.+), (.+), (.+) and (.+)$")
	public void enter_credit_card_details_as_and(String cardholdername, String cardnumber, String expmonth,
			String expyear, String ccv, String zipcode) throws Throwable {

		cp.getPaymentCardName().sendKeys(cardholdername);
		cp.getPaymentCardNumber().sendKeys(cardnumber);
		cp.getPaymentCardExpMonth().sendKeys(expmonth);
		cp.getPaymentCardExpYear().sendKeys(expyear);
		cp.getPaymentCard_CCV().sendKeys(ccv);
		cp.getPaymentCardPostalCode().sendKeys(zipcode);
	}

	@And("^Enter ACH Payment Details as (.+), (.+), (.+), (.+), (.+) and (.+)$")
	public void enter_ach_payment_details_as_and(String cardholdername, String Acc_Type, String Acc_Use,
			String Routing_Number, String Acc_Number, String Confiorm_Acc_Num) throws Throwable {
		cp.getBankAccount().click();
		cp.getPaymentCheckName().sendKeys(cardholdername);
		if (Acc_Type.equals("Saving")) {
			cp.getPaymentCheckAccountType().click();
			cp.getSavings().click();
		}

		if (Acc_Use.equals("Business")) {
			cp.getPaymentCheckBusinessPersonal().click();
			cp.getBusiness().click();
		}

		cp.getPaymentCheckRoutingNumber().sendKeys(Routing_Number);
		String Bankname = cp.getPaymentCheckAccountType().getText();
		// Assert.assertEquals(Bankname, "BANK OF AMERICA, NA");

		cp.getPaymentCheckAccountNumber().sendKeys(Acc_Number);
		cp.getPaymentCheckAccountNumberConfirmation().sendKeys(Confiorm_Acc_Num);

	}

	@And("^close browsers$")
	public void close_browsers() throws Throwable {
		driver.quit();
	}

}
