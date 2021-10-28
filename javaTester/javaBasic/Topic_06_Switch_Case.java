package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_06_Switch_Case {
	Scanner scanner = new Scanner(System.in);

	public void TC_01() {
		int number = scanner.nextInt();

		switch (number) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		// ko có default cũng đc, default thường dùng để show ra error
		}

	}

	public void TC_02() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		String operator = scanner.next();

		switch (operator) {
		case "+":
			System.out.println("a + b = " + (a + b));
			break;
		case "-":
			System.out.println("a - b = " + (a - b));
			break;
		case "*":
			System.out.println("a X b = " + (a * b));
			break;
		case "/":
			System.out.println("a / b = " + (a / b));
			break;
		default:
			break;
		}

	}

	@Test
	public void TC_03() {
		int month = scanner.nextInt();

		switch (month) {
		case 1:
		case 5:
		case 6:
		case 10:
		case 12:
			System.out.println("Tháng này có 31 ngày");
			break;
		case 4:
		case 3:
		case 7:
		case 9:
		case 11:
			System.out.println("Tháng này có 30 ngày");
			break;
		case 2:
			System.out.println("Tháng này có 28 ngày");
			break;

		}

	}

}