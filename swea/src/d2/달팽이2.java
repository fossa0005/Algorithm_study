package d2;

import java.util.Scanner;

public class 달팽이2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1  2  3   4
		//12 13 14  5  
		//11 16 15  6
		//10 9  8   7
		
		int test = sc.nextInt();
		for(int t=1; t<=test; t++) {
			
			
			int N = sc.nextInt();
			int start = 0; 
			int end = N-1;
			int[][] arr = new int[N][N];
			
			int num = 1; //출력할 숫자
			
			while(num <= N*N) { 
				
				for(int i=start; i<=end; i++) {		
					arr[start][i] = num;
					num++;
				}
				
				//System.out.println(Arrays.deepToString(arr));
				
				for(int i=start+1; i<=end; i++) { 
					arr[i][end] = num;
					num++;
				}
				
				//System.out.println(Arrays.deepToString(arr));
				
				for(int i = end-1; i>=start; i--) {
					arr[end][i] = num;
					num++;
				}
				
				//System.out.println(Arrays.deepToString(arr));
				
				for(int i=end-1; i>=start+1; i--) {
					arr[i][start] = num;
					num++;
				} 
				
				//System.out.println(Arrays.deepToString(arr));
				//1겹
				
				
				start++;
				end--;
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
