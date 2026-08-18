package d3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class No1225_암호생성기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = 10;
		for(int t=1; t<=test; t++) {
			
			sc.nextInt();
			Deque<Integer> stack = new ArrayDeque<>();
			for(int i=0; i<8; i++) {
				stack.addLast(sc.nextInt());
				
			}
			
			//System.out.println(stack);
			outer:
			while(true) {
				for(int n=1; n<=5; n++) {
					int a = stack.pop() - n;
					
					if(a <= 0) {
						stack.addLast(0);
						break outer;
					}
					
					stack.addLast(a);
				}
			}
			
			//System.out.println(stack);
			List<Integer> list = new ArrayList<>(stack);
			
			System.out.print("#" + t + " ");
			for(int i=0; i<stack.size(); i++) {
				System.out.print(list.get(i));
				
				if(i != stack.size()-1) {
					System.out.print(" ");
				} else {
					System.out.println();
				}
				
			}
			
			
		}
		}

}
