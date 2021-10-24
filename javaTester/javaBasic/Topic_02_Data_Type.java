package javaBasic;

import org.testng.annotations.Test;

public class Topic_02_Data_Type {

	@Test
	public void TC_01() {
		int a = 6;
		int b = 2;

		System.out.println("Tổng P1 = " + (a + b));
		System.out.println("Hiệu P2 = " + (a - b));
		System.out.println("Tích P3 = " + (a * b));
		System.out.println("Thương P4 = " + (a / b));

	}

	@Test
	public void TC_02() {
		float width = 7.5f;
		float height = 3.8f;

		System.out.println("Area P = " + (width * height));

	}

	@Test
	public void TC_03() {
		String helloName = "Hello";
		String autoName = "Automation Testing";

		System.out.println(helloName + " " + autoName);

	}
	
	

}
