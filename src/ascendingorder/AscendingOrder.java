package ascendingorder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class AscendingOrder {

	public static void main(String[] args) throws FileNotFoundException {
		if(args.length != 1) {
			System.out.println("USAGE: java, location, filename");
			System.exit(1);
		}
		File file = new File(args[0]);
		if(!file.exists()) {
			System.out.println("The file doesn't exist");
			System.exit(2);
		}
		
		File outputFile = new File("tempt.txt");
		if(outputFile.exists()) {
			System.out.println("File already exists");
			System.exit(3);
		}
		try (
				Scanner input = new Scanner(new BufferedInputStream(new FileInputStream(file)));
				PrintWriter output = new PrintWriter(new BufferedOutputStream(new FileOutputStream(outputFile)));
			){
				Stack<String> stack = new Stack<>();
				String result = "";
				while(input.hasNext()) {
					String s1 = input.next();
					stack.push(s1);
				}
				String[] stringArr = new String[stack.size()];
				for(int i = 0; i < stack.size(); i++) {
					stringArr[i] = stack.pop();
				}
				Arrays.sort(stringArr);
				for(int j = 0; j < stringArr.length; j++) {
					result = stringArr[j] + " ";
					output.write(result);
			}
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
}

class StringComparator implements Comparator<String>{
	@Override
	public int compare(String a, String b) {
		return a.compareToIgnoreCase(b);
	}
}
