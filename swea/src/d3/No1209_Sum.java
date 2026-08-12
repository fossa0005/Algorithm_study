package d3;

import java.util.Arrays;
import java.util.Scanner;

public class No1209_Sum {
	static int[][] arr; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			sc.nextInt();
			arr = new int[100][100];
			int[] sums = new int[4];
			
			
			for(int y=0; y<100; y++) {
				for(int x=0; x<100; x++) {
					arr[y][x] = sc.nextInt();
				}
			}
			
			//System.out.println(sum(0,0, +1, 0)); //세로합
			//System.out.println(sum(0,0, 0, +1)); //가로합
			//System.out.println(sum(0, 99, +1, -1)); //대각선/
			//System.out.println(sum(0,0,+1,+1)); //대각선\
			
			sums[0] = sum(0,0, +1, 0);
			sums[1] = sum(0,0, 0, +1);
			sums[2] = sum(0, 99, +1, -1);
			sums[3] = sum(0,0,+1,+1);
			
			Arrays.sort(sums);
			
			System.out.println("#" + t + " " + sums[3]);
			
		}
		
	}
	
	
	public static int sum(int a, int b, int dirY, int dirX) { //(y,x)
		int sum = 0;
		int max_sum = 0;
		int y = a;
		int x = b;
		
		while(x>=0 && x<=99 && y>=0 && y<=99) {
			
			sum += arr[y][x];
			
			x += dirX;
			y += dirY;
			
			if(x <= 99 && y > 99) { //세로합 오른쪽 열로 이동 전 초기화
				if(sum > max_sum) {
					max_sum = sum;
				}
				sum = 0;
				y= 0;
				x += 1;
			} else if(x > 99 && y <= 99) { //가로합 아래 행으로 이동 전 초기화
				if(sum> max_sum) {
					max_sum = sum;
				}
				sum = 0;
				x=0;
				y += 1;
			} else { //대각선
				if(sum> max_sum) {
					max_sum = sum;
				}
			}
			
			
		}
		
		return max_sum;
		
	}	
	

}



