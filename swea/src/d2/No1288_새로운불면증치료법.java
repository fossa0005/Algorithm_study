package d2;

import java.util.HashSet;
import java.util.Scanner;

public class No1288_새로운불면증치료법 {
	static HashSet<Character> set; 
	static int num;
	static String numString;
	
	//
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		numString = String.valueOf(num);
		
		while(true) {
			for(int i=0; i<numString.length(); i++) {
				set.add(numString.charAt(i));
				
				if(set.size() == 10) break;
			}
			
			if(set.size() == 10) break;
			
			num = num*2;
			numString = String.valueOf(num); 
		}
		
		System.out.println("#" + " " + num);
	
	}
	
	
	
	
}


