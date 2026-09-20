package d2;

import java.util.HashSet;
import java.util.Scanner;

public class No1288_새로운불면증치료법 {
	static HashSet<Character> set; 
	static int num;
	static int input;
	static String numString;
	
	//
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			input = sc.nextInt();
			num = input;
			numString = String.valueOf(num);
			set = new HashSet<Character>();
			int n=1;
			while(true) {
				for(int i=0; i<numString.length(); i++) {
					set.add(numString.charAt(i));
					if(set.size() == 10) break;
				}
				
				if(set.size() == 10) break;
				
				num = input*n++;
				numString = String.valueOf(num); 
			}
			
			System.out.println("#" + t + " " + num);
		}
		
	
	}
	
	
	
	
}


