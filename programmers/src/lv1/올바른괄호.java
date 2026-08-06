package lv1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class 올바른괄호 {

	public static void main(String[] args) {
		System.out.println(solution("()()"));
		System.out.println(solution("(())()"));
		System.out.println(solution(")()("));
		System.out.println(solution("(()("));
		
		System.out.println(solution("(()))))"));
		System.out.println(solution("(((((((((("));
	}
	
	//(( )))
	// 1 1
	// x x
	// (( )))))
	
	
	static boolean solution(String s) {
			int stack = 0;
	        
			
			if (s.charAt(0) == ')'){
	            return false;
	        }
		        
		       
		    for(int i=0; i < s.length(); i++) {
	        	if (s.charAt(i) == '(') {
	        		stack++;
	        		
	        	} else if (s.charAt(i) == ')'){
	        		stack--;
	        	}
		     }
				
				
			return stack == 0; 
	}

}
