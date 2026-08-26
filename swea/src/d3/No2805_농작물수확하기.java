package d3;

import java.util.Scanner;

public class No2805_농작물수확하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for(int t=1; t<=test; t++) {
			int n = sc.nextInt(); //n*n
			char[][] charArr = new char[n][];
			int[][] arr = new int[n][n];
			
			for(int i=0; i<n; i++) {
				charArr[i] = sc.next().toCharArray();	
			}
			
			//System.out.println(Arrays.deepToString(charArr));
			
			
			for(int y=0; y<n; y++) {
				for(int x=0; x<n; x++) {
					arr[y][x] = charArr[y][x] - '0';
				}
			}
			
			
			//System.out.println(Arrays.deepToString(arr));
			
			
			int res = 0;
			int start = n/2; 
			int limit = 1; //한 줄당 수확하는 갯수
			for(int y = 0; y<=n/2; y++) {
				for(int x=start, cnt=1;  cnt<=limit;  x++, cnt++) {
					//System.out.print(arr[y][x]);
					res += arr[y][x];
				}
				
				limit+= 2;
				start--;
				
			}
			
			limit=n-2;
			start=1;
			
			for(int y= n-n/2; y<n; y++) {
				for(int x=start, cnt=1;  cnt<=limit;  x++, cnt++) {
					//System.out.print(arr[y][x]);
					res += arr[y][x];
				}
				
				limit-= 2;
				start++;
			}
			
			System.out.println("#" + t + " " + res);
			
			
		}
		sc.close();		
	}
	
}
