package d4;

import java.util.ArrayDeque;
import java.util.Scanner;

//스택방식
public class No1218_괄호짝짓기_stack {
	
	static ArrayDeque<Character> stack;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			String s = sc.next();
			stack = new ArrayDeque<Character>();
			int ans = 1;
			
			check:
			for(int n=0; n<N; n++) {
				char ch = s.charAt(n);
				
				switch(ch) {
				case '(': 
				case '[' : 
				case '{' : 
				case '<' : stack.push(ch); break;
				
				case ')': 
				case ']' : 
				case '}' : 
				case '>' : {
					if(stack.isEmpty()) {
						ans = 0;
						break check;
					}
					if( (stack.peek()=='(' && ch == ')') ||
						(stack.peek()=='{' && ch == '}') ||	
						(stack.peek()=='[' && ch == ']') ||		
						(stack.peek()=='<' && ch == '>') ) {
						stack.pop();
						break;
					}
					
					else {
						ans = 0;
						break check;
					}
				}
				default : throw new Exception();
				}
			}
			
			if(! stack.isEmpty()) ans = 0;
			
			System.out.println("#" + t + " " + ans);
			
			
		}
		
		
		
	}

}
