package javaBasic;

import com.github.javafaker.Faker;

public class Topic_14_Data_Faker {

	public static void main(String[] args) {
		Faker faker = new Faker();

		System.out.println(faker.address().firstName());
		System.out.println(faker.address().firstName());
		System.out.println(faker.address().firstName());
		System.out.println(faker.address().firstName());
		System.out.println(faker.address().firstName());
		System.out.println(faker.address().firstName());
		System.out.println(faker.name().firstName());
		System.out.println(faker.internet().emailAddress());
		System.out.println(faker.company().name());

	}

}
