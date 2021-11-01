package javaBasic;

import org.testng.annotations.Test;

public class Topic_10_Array {
	int[] numbers = { 2, 70, 47, 35, 89, 20, 15, 44, 16, -3, -10, -7, -55, -37, 12 };

	public void TC_01_Find_Max_Number() {
		int x = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (x <= numbers[i]) {
				x = numbers[i];
			}
		}
		System.out.println(x);
	}

	public void TC_01_Sum_Fist_And_Last_Numbers() {
		System.out.println("Tong so dau va cuoi = " + (numbers[0] + numbers[numbers.length - 1]));

	}

	public void TC_03_Show_Even_Numbers() {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 == 0) {
				System.out.println("So chan la = " + numbers[i]);

			}
		}
	}

	public void TC_04_Show_Parity_Numbers() {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 != 0 && numbers[i] > 0) {
				System.out.println("So le la = " + numbers[i]);

			}
		}
	}

	
	public void TC_05_Show_GreaterThan0_Numbers() {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] >= 0 && numbers[i] <= 10) {
				System.out.println("So lon hon 0 va nho hon 10 = " + numbers[i]);

			}

		}
	}
	
	@Test
	public void TC_06_Show_Sum_And_Average_In_Array() {
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
			sum = sum + numbers[i];
			
		}
		System.out.println("Tong cac so trong mang = " + sum);
		System.out.println("Trung binh cong cac so trong mang = " + sum/ numbers.length);
		
	
	}
}
