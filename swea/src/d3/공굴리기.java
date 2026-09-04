package d3;


import java.util.Scanner;

public class 공굴리기 {
	static int N;
	static int posY, posX;
	static int max_distance = 0;
	static int[] dy = new int[] {-1, +1, 0, 0};
	static int[] dx = new int[] {0, 0, -1, 1};
	static int[][] arr;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			
			N = sc.nextInt();
			arr = new int[N][N];
			max_distance = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int y=0; y<N; y++) {
				for(int x=0; x<N; x++) { //지점 순회
					posY = y;
					posX = x;
					move(posY, posX);
				}
			}
			
			System.out.println("#" + t +  " " + max_distance);
			
		}
		
		
	}
	
	
	
	

	static void move(int a, int b) { //한 지점에서의 공시뮬
		
		int distance = 1;
		System.out.println();
		while (true) {
			int lowwest = 500;
			int lowwest_dy=0, lowwest_dx=0;
			
			for(int i=0; i<4; i++) { //상하좌우중 제일 낮은곳 찾기
				
				if(inArr(posY + dy[i], posX+dx[i])) {
					if(arr[posY + dy[i]][posX+dx[i]] < lowwest) {
						lowwest = arr[posY + dy[i]][posX+dx[i]];
						lowwest_dy = dy[i];
						lowwest_dx = dx[i];
					}
				}
			}
			
			if(lowwest < arr[posY][posX]) { //이동
				posY += lowwest_dy;
				posX += lowwest_dx;
				distance++;
				
			} else { //멈춤
				
				if(distance > max_distance) {
					//System.out.println("시작점:" + arr[a][b]);
					max_distance = distance; 
				}
				
				break;
			}
			
		}
		
	}
	
	static boolean inArr(int y, int x) { //인덱스 범위인지 체크
		return (y>=0 && y<N && x>=0 && x<N);
	}
}



