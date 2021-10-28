package javaBasic;

public class Topic_04_Casting {

	public static void main(String[] args) {
		// Ép kiểu Ngầm định = ko mất dữ liệu
		byte bNumber = 126;
		System.out.println(bNumber);

		short sNumber = bNumber;
		System.out.println(sNumber);

		int iNumber = sNumber;
		System.out.println(iNumber);

		long lNumber = iNumber;
		System.out.println(lNumber);

		float fNumber = lNumber;
		System.out.println(fNumber);

		double dNumber = fNumber;
		System.out.println(dNumber);

		// Ép kiểu Tường minh = ép từ lớn xuống nhỏ sẽ bị mất dữ liệu
		double dNumber1 = 5345343245452545345d;

		float fNumber1 = (float) dNumber1;
		System.out.println(fNumber1);

		long lNumber1 = (long) fNumber1;
		System.out.println(lNumber1);

		int iNumber1 = (int) lNumber1;
		System.out.println(iNumber1);

	}

	// Ép kiểu tham chiếu

}
