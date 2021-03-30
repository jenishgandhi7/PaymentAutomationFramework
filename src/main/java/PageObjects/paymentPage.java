package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.base_config;

public class paymentPage extends base_config {

	public WebDriver driver;

	public paymentPage(WebDriver driver) {
		this.driver = driver;

	}

	
	
	By first_name= By.id("first-name");
	By last_name= By.id("last-name");
	By email= By.id("email");

	By company= By.id("company");
	By description= By.id("description");
	By payment_amount= By.id("payment-amount");
	By payment_schedule_type_select= By.id("payment-schedule-type-select");
	By one_time_payment= By.xpath("//li[@aria-label='One-time payment']");

	By Recurring_payment= By.xpath("//li[@aria-label='Recurring payment']");
	By payment_schedule_frequency_select= By.id("payment-schedule-frequency-select");
	By Monthly= By.xpath("//li[@aria-label='Monthly']");
	By Credit_Debit= By.xpath("//span[normalize-space()='Credit/Debit']");
	By payment_card_name= By.id("payment-card-name");
	By payment_card_exp_month= By.id("payment-card-exp-month");
	By payment_card_exp_year= By.id("payment-card-exp-year");
	By payment_card_number= By.id("payment-card-number");
	By payment_card_ccv= By.id("payment-card-ccv");
	By payment_card_postal_code= By.id("payment-card-postal-code");

	By bank_account= By.xpath("//span[normalize-space()='Bank account']");
	By payment_check_name= By.id("payment-check-name");
	By payment_check_account_type= By.id("payment-check-account-type");
	By Savings= By.xpath("//li[normalize-space()='Savings']");

	By payment_check_business_personal= By.id("payment-check-business-personal");
	By Business= By.xpath("//li[normalize-space()='Business']");
	By payment_check_routing_number= By.id("payment-check-routing-number");
	By payment_check_account_number = By.id("payment-check-account-number");
	By payment_check_account_number_confirmation = By.id("payment-check-account-number-confirmation");
	By terms =By.xpath("//input[@name='terms']");
	By submit = By.id("submit");
	By payment_check_bank_label=	By.id("payment-check-bank-label");
	

	
	
	
	public WebElement getFirstName() {
		return driver.findElement(first_name);
	}

	public WebElement getLastName() {
		return driver.findElement(last_name);
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getCompany() {
		return driver.findElement(company);
	}
	public WebElement getDescription() {
		return driver.findElement(description);
	}
	public WebElement getPaymentAmount() {
		return driver.findElement(payment_amount);
	}

	public WebElement getPaymentScheduleTypeSelect() {
		return driver.findElement(payment_schedule_type_select);
	}

	public WebElement getRecurringPayment() {
		return driver.findElement(Recurring_payment);
	}

	public WebElement getOneTimePayment() {
		return driver.findElement(one_time_payment);
	}
	public WebElement getPaymentScheduleFrequencySelect() {
		return driver.findElement(payment_schedule_frequency_select);
	}

	/*
	 * public List<WebElement> getListOfInterBankRates() { return
	 * driver.findElements(interbank_rates_list); }
	 */
	public WebElement getMonthly() {
		return driver.findElement(Monthly);
	}

	public WebElement getCreditDebit() {
		return driver.findElement(Credit_Debit);
	}

	public WebElement getPaymentCardName() {
		return driver.findElement(payment_card_name);
	}
	
	public WebElement getPaymentCardExpMonth() {
		return driver.findElement(payment_card_exp_month);
	}
	public WebElement getPaymentCardExpYear() {
		return driver.findElement(payment_card_exp_year);
	}
	public WebElement getPaymentCardNumber() {
		return driver.findElement(payment_card_number);
	}
	public WebElement getPaymentCard_CCV() {
		return driver.findElement(payment_card_ccv);
	}
	public WebElement getPaymentCardPostalCode() {
		return driver.findElement(payment_card_postal_code);
	}
	public WebElement getBankAccount() {
		return driver.findElement(bank_account);
	}
	public WebElement getPaymentCheckName() {
		return driver.findElement(payment_check_name);
	}
	public WebElement getPaymentCheckAccountType() {
		return driver.findElement(payment_check_account_type);
	}
	public WebElement getSavings() {
		return driver.findElement(Savings);
	}
	public WebElement getPaymentCheckBusinessPersonal() {
		return driver.findElement(payment_check_business_personal);
	}
	public WebElement getBusiness() {
		return driver.findElement(Business);
	}
	public WebElement getPaymentCheckRoutingNumber() {
		return driver.findElement(payment_check_routing_number);
	}
	
	public WebElement getPaymentCheckAccountNumber() {
		return driver.findElement(payment_check_account_number);
	}
	
	public WebElement getPaymentCheckAccountNumberConfirmation() {
		return driver.findElement(payment_check_account_number_confirmation);
	}
	
	public WebElement getTerms() {
		return driver.findElement(terms);
	}
	public WebElement getSubmit() {
		return driver.findElement(submit);
	}
	
	public WebElement getPaymentCheckBankLabel() {
		return driver.findElement(payment_check_bank_label);
	}
	


}
