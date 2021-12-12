package utilities;

import java.util.Random;

import com.github.javafaker.Faker;

public class DataFaker {
	private Faker faker;

	public static DataFaker getDataFaker() {
		return new DataFaker();
	}

	public DataFaker() {
		faker = new Faker();
	}

	public String getFirtNameByFaker() {
		return faker.name().firstName();
	}

	public String getLastNameByFaker() {
		return faker.name().lastName();
	}

	public String getCompanyByFaker() {
		return faker.company().name();
	}

	public String getAddressByFaker() {
		return faker.address().fullAddress();
	}

	public String getEmailFaker() {
		return faker.internet().emailAddress();
	}

	public static int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);

	}

}
