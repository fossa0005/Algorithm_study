package d4;

import java.util.Scanner;

public class No1218_괄호짝짓기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] data;
		
		int test = 10;
		for(int t=1; t<=test; t++) {
			int res = 0;
			int num1=0, num2=0, num3=0, num4=0; //(, [, {, <
			
			sc.nextInt();
			data = sc.next().toCharArray();
			
			for(char c : data) {
				switch (c) {
				case '(' : num1++; break;
				case '[' : num2++; break;
				case '{' : num3++; break;
				case '<' : num4++; break;
				
				case ')' : num1--; break;
				case ']' : num2--; break;
				case '}' : num3--; break;
				case '>' : num4--; break;
				
				}
			}
			
			if(num1==0 && num2==0 && num3==0 && num4==0) {
				res = 1;
			}
		
			System.out.println("#" + t + " " + res);
		
		}
		
		
		
		
		
		
	}

}
