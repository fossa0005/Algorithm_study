package d2;

import java.util.Scanner;

public class 달팽이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1  2  3   4
		//12 13 14  5  //12 : 4+3+3+3
		//11 16 15  6
		//10 9  8   7
		
		int test = sc.nextInt();
		for(int t=1; t<=test; t++) {
			
			
			int N = sc.nextInt();
			int start = 0;
			int[][] arr = new int[N][N];
			
			int num = 1; //출력할 숫자
			
			for(int n=N; n>=1; n--) { //총 N겹
				
				for(int i=start; i<n; i++) {
					arr[start][i] = num;
					num++;
				}
				
				//System.out.println(Arrays.deepToString(arr));
				
				for(int i=start+1; i<n; i++) { 
					arr[i][n-1] = num;
					num++;
				}
				
				//System.out.println(Arrays.deepToString(arr));
				
				for(int i=n-2; i>=start; i--) {
					arr[n-1][i] = num;
					num++;
				}
				
				//System.out.println(Arrays.deepToString(arr));
				
				for(int i=n-2; i>=start+1; i--) {
					arr[i][start] = num;
					num++;
				} 
				
				//System.out.println(Arrays.deepToString(arr));
				//1겹
				
				
				start++;
			}
			
			//System.out.println(Arrays.deepToString(arr));
			
			System.out.println("#"+ t);
			for(int y=0; y<N; y++) {
				for(int x=0; x<N; x++) {
					System.out.print(arr[y][x]);
				if(x!=N-1) {
					System.out.print(" ");
				}
				
				}
				
				System.out.println();
				
			}	
			
		}
		
		
		
		
		
		
	}	
}
