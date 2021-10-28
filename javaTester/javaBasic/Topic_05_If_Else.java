package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_05_If_Else {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);

	public void TC_01() {
		int number = scanner.nextInt();
		if (number % 2 == 0) {
			System.out.println("n la so chan");
		} else {
			System.out.println("n la so le");
		}

	}

	public void TC_02() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		if (a >= b) {
			System.out.println(a + " a lớn hơn hoặc bằng b");

		} else {
			System.out.println(a + " a nhỏ hơn hoặc bằng b");

		}

	}

	public void TC_03() {
		String name1 = scanner.nextLine();
		String name2 = scanner.nextLine();

		if (name1.equals(name2)) {
			System.out.println("2 người là cùng tên " + name1 + " và " + name2);

		} else {
			System.out.println("2 người là khác tên " + name1 + " và " + name2);

		}
	}

	public void TC_04() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();

		if (a > b && a > c) {
			System.out.println("a la so lon nhat: " + a);
		} else if (b > c) {
			System.out.println("b la so hon c: " + b + " > " + c);

		} else {
			System.out.println("c la so nhat: " + c);

		}

	}

	public void TC_05() {
		int a = scanner.nextInt();

		if (10 < a && a < 100) {
			System.out.println("a nam trong [10,100]");

		} else {
			System.out.println("a ko nam trong [10,100]");

		}

	}

	
	public void TC_06() {
		float studentPoint = scanner.nextFloat();

		if (studentPoint <= 10 && studentPoint >= 8.5) {
			System.out.println("Sinh vien co diem A");

		} else if (studentPoint < 8.5 && studentPoint >= 7.5) {
			System.out.println("Sinh vien co diem B");
		} else if (studentPoint < 7.5 && studentPoint >= 5) {
			System.out.println("Sinh vien co diem C");
		} else {
			System.out.println("Sinh vien co diem D");
		}
	}

	@Test
	public void TC_07() {
		int month = scanner.nextInt();

		if (month == 3 || month == 5 || month == 7 || month == 9 || month == 11) {
			System.out.println("thang nay co 31 ngay");

		} else if (month == 2) {
			System.out.println("thang nay co 28 ngay");

		} else {
			System.out.println("thang nay co 30 ngay");
		}

	}
}