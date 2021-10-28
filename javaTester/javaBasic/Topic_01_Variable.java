package javaBasic;

public class Topic_01_Variable {

	// Khai báo biến

//	byte 
//	short 
//	int 
//	long 
//	char 
//	float 
//	double 
//	boolean

	static int studentNumber;
	static boolean statusValue;
	static final String browserName = "Chrome";
	static int studentPrice;

	
	public static void main(String[] args) {
		int studentPrice = 5;

		System.out.println(studentPrice);
		System.out.println(studentNumber);
		System.out.println(statusValue);
		System.out.println(Topic_01_Variable.browserName);
		
		Topic_01_Variable topic1 = new Topic_01_Variable();
		
		// Phải new mới lên mới xài đc biến global
		System.out.println(Topic_01_Variable.browserName);
		
	}

}