package d3;

import java.util.Arrays;
import java.util.Scanner;

public class No2805_농작물수확하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		char[][] charArr = new char[n][];
		int[][] arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			charArr[i] = sc.next().toCharArray();	
		}
		
		System.out.println(Arrays.deepToString(charArr));
		
		
		for(int y=0; y<n; y++) {
			for(int x=0; x<n; x++) {
				arr[y][x] = charArr[y][x] - '0';
			}
		}
		
		System.out.println("ddd");
		System.out.println(Arrays.deepToString(arr));
		
		
		int res = 0;
		int start = n/2; 
		int cnt = 1; //한 줄당 읽는 갯수
		for(int y = 0; y<n/2; y++) {
			for(int x=start, i=1;  i<=cnt;  i++, x++) {
				res += arr[y][x];
			}
			
			System.out.println(res);
			cnt+= 2;
			start--;
			
		}
		
		
	}
	
}
