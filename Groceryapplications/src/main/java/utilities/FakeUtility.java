package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.github.javafaker.Faker;

public class FakeUtility {
	static Faker faker = new Faker();

	public String generatename() {
		return faker.name().fullName();
	}

	public String generateAddress() {
		return faker.address().fullAddress();
	}

	public static  String generatePhoneNumber() {
		return faker.phoneNumber().toString();
	}

	public String generateEmailAddress() {
		return faker.internet().emailAddress();
	}
	public String generateTime() {
		 Date randomTime = faker.date().past(1, java.util.concurrent.TimeUnit.DAYS);// Generates a date with time
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss"); // Format to time only
        String fakeTime = timeFormat.format(randomTime);
		return fakeTime;
	}

	public String generateRandomBIrthday() {
		return faker.date().birthday().toString();
	}

	public String generateCreditCardNumber() {
		return faker.finance().creditCard().toString();
	}

	public String generateCompanyName() {
		return faker.company().name();
	}
//	public String generateRandomNumber()
//	{
//		return faker.number().randomNumber().toString();
//	}
}
