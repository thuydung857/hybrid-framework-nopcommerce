package com.nopcommerce.data;

import utilities.DataFaker;

public class AdminData extends DataFaker{


	public class Register {
		public final String EMAIL = "auto" + getRandomNumber() + "@hotmail.com";
		public static final String FIRSTNAME = "Anna";
		public static final String LASTNAME = "Hilton";
		public static final String COMPANY = "CTYP";
		public static final String PASSWORD = "123456";

	}

	public class Login {

	}

	public class Address {

	}

	public class MyAccount {

	}
	
}