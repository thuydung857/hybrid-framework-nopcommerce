package javaBasic;

import org.testng.annotations.Test;

public class Topic_11_String {
	String pageTitle = "Lorem Ipsum is Simply a Piece of Dummy text";

	public void TC_01_Sum_Of_UpperCase_Characters() {
		char pageTitleArr[] = pageTitle.toCharArray();
		int count = 0;
		for (char page : pageTitleArr) {
			if (page >= 'A' && page <= 'Z') {
				count++;

			}

		}
		System.out.println(count);
	}

	
	public void TC_02_Many_Cases() {
		char pageTitleArr[] = pageTitle.toCharArray();
		int count = 0;
		for (char page : pageTitleArr) {
			if (page == 'a') {
				count++;
			}
		}
		// Đếm số lượng kí tự 'a' trong chuỗi
		System.out.println("Số lượng kí tự a trong chuỗi là: " + count);
		// Có chứa từ "Simply" hay ko (= true)
		System.out.println("Có chứa từ Simply hay không: " + pageTitle.contains("Simply"));
		// Có bắt đầu từ text hay ko (= false)
		System.out.println("Có bắt đầu từ text hay không: " + pageTitle.startsWith("text"));
		// Có kết thúc bằng từ Lorem hay ko (= false)
		System.out.println("Có kết thúc từ Lorem hay không: " + pageTitle.endsWith("Lorem"));
		// Lấy vị trí của từ Dummy
		System.out.println("Vị trí của từ Dummy là: " + pageTitle.indexOf("Dummy"));
		// Thay thế từ Ipsum bằng Automation
		String newPageTitle = pageTitle.replace("Ipsum", "Automation");
		System.out.println(newPageTitle);
	}

	@Test
	public void TC_03_Revert() {
		char pageTitleArr[] = pageTitle.toCharArray();

		for (int i = pageTitleArr.length - 1; i >= 0; i--) {
			System.out.print(pageTitleArr[i]);
		}
	}
}