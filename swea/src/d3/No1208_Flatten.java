package d3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class No1208_Flatten {
	static List<Integer> list;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = 10;
		
		for(int t=1; t<=test; t++) {
			list = new ArrayList<Integer>();
			int n = sc.nextInt();
			
			
			
			for(int i=0; i<100; i++) {
				list.add(sc.nextInt());
			}
			//System.out.println(list);
			
			dump(n);
			//System.out.println("후:" + list);
			int res = Collections.max(list) - Collections.min(list);
			
			System.out.println("#" +t + " " + res);
			
		}
		
	}
	
	
	public static void dump(int n) {
		int highest;
		int lowwest;
		int gap = 0;
		
		for(int i=0; i<n; i++) {
			highest = Collections.max(list);
			lowwest  = Collections.min(list);
			gap = highest - lowwest;
			
			if(gap <= 1) {
				break;
			}
			
			list.set(list.indexOf(highest), list.get(list.indexOf(highest)) - 1);
			list.set(list.indexOf(lowwest), list.get(list.indexOf(lowwest)) + 1);
			
		}
		
	}

}
