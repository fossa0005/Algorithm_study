package d3;

import java.util.Scanner;

public class No1213_String {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =  10;
		
		for(int t=1; t<=T; t++) {
			sc.nextInt();
			String s = sc.next();
			String data = sc.next();
			int lengthSum = data.length() - data.replaceAll(s, "").length();
			
			int ans = lengthSum / s.length();
			System.out.println("#" + t + " " + ans);
		}
		
		
	}

}
