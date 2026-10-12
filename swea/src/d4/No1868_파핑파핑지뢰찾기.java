package d4;

import java.util.Arrays;
import java.util.Scanner;

public class No1868_파핑파핑지뢰찾기 {
	static int N;
	static char[][] arr;
	static boolean[][] visited; //숫자 밝혔는지
	static int clickCnt;
	
	//0+인접 덩어리 -> 클릭1번
	//나머지 안밝혀진칸 -> 각각클릭
	//전체 칸 수  - 한번에 밝힌 칸 수 - 지뢰수 = 각각클릭해야하는 횟수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			arr = new char[N][];
			clickCnt = 0;
			visited = new boolean[N][N];
			
			for(int r=0; r<N; r++) {
				String row = sc.next();
				arr[r] = row.toCharArray();
			}
			
			//System.out.println(Arrays.deepToString(arr));
			
			//칸 숫자 채우기
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(arr[r][c] != '*') arr[r][c] = countMine(r, c);
				}
			}
			
			//System.out.println(Arrays.deepToString(arr));
			
			//0 덩어리 밝히기
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(arr[r][c] == '0' && visited[r][c] == false) {
						visited[r][c] = true;
						clickCnt++;
						revealAroundZero(r, c);
					}
				}
			}
			
			//남은 안밝혀진 숫자 밝히기
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(arr[r][c] != '*' && visited[r][c] == false) {
						clickCnt++;
					}
				}
			}
			
			System.out.println("#" + t + " " + clickCnt);
			
		}
		
	}
	
	//0 주위칸을 밝히기
	//주위칸에 0있으면 반복
	static void revealAroundZero(int a, int b) {
		for(int r=a-1; r<=a+1; r++) {
			if(r<0 || r>=N) continue;
			for(int c=b-1; c<=b+1; c++) {
				if(c<0 || c>=N) continue;
				if(r==a && c==b) continue;
				if(! visited[r][c]) {
					visited[r][c] = true;
					if(arr[r][c] == '0') revealAroundZero(r, c);
				}
			}
		}
	}
	
	//주위칸 지뢰수
	//해당 칸 숫자
	static char countMine(int a, int b) {
		int res = 0;
		for(int r=a-1; r<=a+1; r++) {
			if(r<0 || r>=N) continue;
			for(int c=b-1; c<=b+1; c++) {
				if(c<0 || c>=N) continue;
				if(r==a && c==b) continue;
				
				if(arr[r][c] == '*') res++;
			}
		}
		
		return (char)(res + '0'); 
	}
	
	

}












