package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_07_For_ForEach {
	Scanner scanner = new Scanner(System.in);

	// Example

	public void TC_01() {
		String[] cars = { "Honda, Toyota, BMW" };

		// Dùng for duyệt qua mảng
		for (int i = 0; i < cars.length; i++) {
			System.out.println(cars[i]);
		}

		// Dùng for each duyệt qua mảng
		for (String car : cars) {
			System.out.println(car);

		}
	}

	// Exercise

	public void TC_02() {
		int number = scanner.nextInt();

		for (int i = 0; i <= number; i++) {
			System.out.println(i);

		}

	}

	public void TC_03() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		for (int i = a; i <= b; i++) {
			if (a <= b) {
				System.out.println(i);
			}
		}

	}

	public void TC_04() {
		String[] numbers = { "1, 2, 3, 4, 5, 6, 7, 8, 9, 10" };
		int result = 0;

		for (int i = 0; i < numbers.length; i++) {
			if (i % 2 == 0) {
				System.out.println("Result: " + (result + numbers[i]));
			}
		}
	}

	public void TC_05() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int result = 0;

		for (int i = a; i <= b; i++) {
			result = result + i;
		}
		System.out.println("Result: " + result);

	}

	public void TC_06() {
		int sole = scanner.nextInt();
		int result = 0;

		for (int i = 0; i <= sole; i++) {
			if (i % 2 == 1) {
				result = result + i;
			}
		}
		System.out.println("Result: " + result);
	}

	public void TC_07() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		for (int i = a; i <= b; i++) {
			if (i % 3 == 0) {
				System.out.println(i);
			}
		}
	}

	@Test
	public void TC_08() {
		int n = scanner.nextInt();
		int result = 1;

		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		System.out.println(result);
	}
}
