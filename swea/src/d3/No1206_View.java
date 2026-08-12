package d3;

import java.util.Scanner;

public class No1206_View {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = 10;
		
		for(int t=1; t<=test; t++) {
			int res = 0;
			int N = sc.nextInt();
			
			int[] height = new int[N]; //처음, 끝 빈땅 포함
			for(int i=0; i<N; i++) {
				height[i] = sc.nextInt();
			}
			
			//System.out.println(Arrays.toString(height));
			
			//좌우 두개 건물높이보다 높은 층 수
			
			for(int i=2; i<=N-3; i++) {
				int left = Math.max(height[i-1], height[i-2]);
				int right = Math.max(height[i+1], height[i+2]);
				int highest = Math.max(left, right);
				
				if(height[i] > highest) {
					res +=  height[i]-highest;
				}
			}
			
			System.out.printf("#%d %d\n", t, res);	
		
		}
		

	}

}
