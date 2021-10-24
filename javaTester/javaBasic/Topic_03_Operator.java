package javaBasic;

import org.testng.annotations.Test;

public class Topic_03_Operator {
	String address = "Ha noi";

	@Test
	public void TC_01() {
		int x = 3;
		x &= 10; /// ?????????????????
		x |= 10;
		System.out.println(x);
	}

	@Test
	public void TC_02() {

		// Tam nguyên: 3 dấu = ? :
		boolean statusFalse = (address == "Ho Chi Minh") ? true : false;
		System.out.println(statusFalse);

		boolean statusTrue = (address == "Ha noi") ? true : false;
		System.out.println(statusTrue);

	}

	// Excerises

	@Test
	public void TC_03() {
		String name = "Dung";
		int age = 20;

		System.out.println("After 15 years, age of " + name + " " + "will be" + " " + (age += 15));
	}

	@Test
	public void TC_04() {
		int a = 3;
		int b = 4;
		a = a + b;
		System.out.println("a tổng =" + a);
		
		b = a - b;
		a = a - b;
		System.out.println("a sau khi swap =" + a);
		System.out.println("b sau khi swap =" + b);
	}
	
	@Test
	public void TC_05() {
		int a = 5;
		int b = 7;
		boolean numberFalse = (a == b) ? true : false;
		boolean numberTrue = (a != b) ? true : false;
		System.out.println(numberFalse);
		System.out.println(numberTrue);
	}
}
