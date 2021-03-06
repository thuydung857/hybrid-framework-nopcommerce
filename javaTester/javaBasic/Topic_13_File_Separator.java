package javaBasic;

import java.io.File;
import java.nio.file.FileSystems;

public class Topic_13_File_Separator {

	public static void main(String[] args) {
		String projectLocation = System.getProperty("user.dir");

		String danangFileName = "Da Nang.jpg";
		String hanoiFileName = "Ha Noi.jpg";
		String saigonFileName = "Ho Chi Minh.jpg";
		String danangFileNamePath = projectLocation + getDirectorySlash("uploadFiles") + danangFileName;
		String hanoiFileNamePath = projectLocation + getDirectorySlash("uploadFiles") + hanoiFileName;
		String saigonFileNamePath = projectLocation + getDirectorySlash("uploadFiles") + saigonFileName;

		// Final Path
		System.out.println("DN Path " + danangFileNamePath);
		System.out.println("HN Path " + hanoiFileNamePath);
		System.out.println("SG Path " + saigonFileNamePath);
	}

	//Methor
	public static String getDirectorySlash(String folderName) {
		String separator = System.getProperty("file.separator");
		System.out.println(separator);
		separator = FileSystems.getDefault().getSeparator();
		System.out.println(separator);
		separator = File.separator;
		System.out.println(separator);
		return separator + folderName + separator;
	}
}
