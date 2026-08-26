package d3;

import java.util.Arrays; 
import java.util.Scanner;

public class No1860_진기의고오급붕어빵 {
	static int n,m,k;
	static int boong;
	static int sold;
	static int[] guests;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//n명, m초마다 k개
		//초 초 초 
		
		int testCase = sc.nextInt();
		
		for(int t=1; t<=testCase; t++) {
			
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			guests = new int[n];
			
			for(int i=0; i<n; i++) {
				guests[i] = sc.nextInt(); 
			}
			
			Arrays.sort(guests);
			
			boong = 0;
			sold = 0;
			String res = "Possible";
			
			for(int sec : guests) {
				boong = (sec / m) * k;
				
				if(boong - sold == 0) {
					res = "Impossible";
					break;
				}
				
				sold++;
			}
			
			
			System.out.println("#" + t + " " + res);
		}
		
		sc.close();
	}
	
}
