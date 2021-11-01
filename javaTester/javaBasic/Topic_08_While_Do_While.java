package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_08_While_Do_While {
	static Scanner scanner = new Scanner(System.in);

	// Example

	public void TC_01_For() {
		int number = scanner.nextInt();

		for (int i = number; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.println(i);

			}
		}
	}

	public void TC_02_While() {
		int number = scanner.nextInt();

		while (number < 100) {
			if (number % 2 == 0) {
				System.out.println(number);
				number++;
			}
		}
	}

	public void TC_03_Do_While() {
		int number = scanner.nextInt();

		do {
			if (number % 2 == 0) {
				System.out.println(number);
				number++;
			}

		} while (number < 100);
	}

	// Exercise

	public void TC_04_While() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		while (a < b) {
			if (a % 3 == 0 && a % 5 == 0) {
				System.out.println(a);
			}
			a++;

		}
	}

	public void TC_05_While() {
		int a = scanner.nextInt();
		int i = 0;

		while (a > 0) {
			if (a % 2 != 0) {
				i += a;
			}
			a--;

		}
		System.out.println(i);
	}

	public void TC_06_While() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		while (a < b) {
			if (a % 3 == 0) {
				System.out.println(a);
			}
			a++;

		}
	}

	public void TC_07_While() {
		int n = scanner.nextInt();
		int i = 1;

		while (n > 0) {
			i *= n;
			i--;
		}
		System.out.println(i);
	}

	@Test
	public void TC_08_While() {
		int number[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int i = 1;

		while (i > 0) {
			if (number[i] % 2 == 0) {
			}
		}
		System.out.println("Day la so chan : " + number[i]);
	}
}