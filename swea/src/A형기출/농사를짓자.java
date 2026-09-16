package A형기출;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 농사를짓자 {
	static int N, M;
	static int[][] arr;
	static int[] dr = new int[]{0, -1, 0, +1}; //(절대좌표)우상좌하
	static int[] dc = new int[]{+1, 0, -1, 0};
	static int pos; //보는 방향의 델타배열 인덱스
	static int cr, cc; //현재 좌표
	static int seedCnt, harvestCnt, day; //심은 횟수, 수확횟수, 현재 날짜
	static int max;
	//N길이 M일
	//모든 시작가능위치에 대해 수확량 검사하고 최대값 갱신
	
	//씨앗 
	 //수확가능일 = day + 1 + 3 + cnt; fifo배열로	
	
	//오전
	
	//seed()
	//harvest()
	
	
	//오후
	//static pos로 현재 바라보는 dir 저장
	//move(); //이동
	//getNestDir(); 
	//boolean canMove(); //이동 가능 방향 반환, 없으면 -1
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N][N];
			max = 0;
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(arr[r][c] == 1) continue;
					for(int p=0; p<4; p++) {
						cr = r;
						cc = c;
						pos = p;
						seedCnt = 0; harvestCnt =0;
						
						simulate();
						clearArr();
						
						if (harvestCnt > max) {
							//System.out.println("시작위치:" + r + " " + c + "pos" + p);
							//System.out.println("종료위치:" + cr + " " + cc);
							max = harvestCnt;
						}
						
					}
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
	
	
	static void simulate() {
		for(day=1; day<=M; day++) {
			//오전
			if(arr[cr][cc] == 0) { //빈농지
				if(getDir() != -1) seed();
			}
			
			else {
				if(day >= arr[cr][cc]) harvest();
			}
			
			//오후
			move();
		}
	}
	
	static void seed() {
		seedCnt++;
		arr[cr][cc] = day + 1 + 3 + seedCnt;
	}
	
	static void harvest() {
		if(day >= arr[cr][cc]) {
			harvestCnt++;
			arr[cr][cc] = 0;
		}
	}
	
	//이동가능 방향반환 //없으면 -1
	static int getDir() { 
		int res = -1;
		
		for(int n=-1; n<=2; n++) { //보는방향의 우상좌하 갈수있는지 검사
			int dir = pos+n; //델타배열의 인덱스로
			if(dir < 0) dir = 4+dir;
			if(dir > 3) dir = dir-4;
			
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			if (nr < 0 || nr > N-1 || nc < 0 || nc > N-1) continue;
			if(arr[nr][nc] == 1) continue;
			if(arr[nr][nc] == 0 || day >= arr[nr][nc]) {
				res = dir;
				break;
			}
		}
		
		return res;
	}
	
	//이동가능시 움직임
	static void move() {
		int dir = getDir();
		if(dir != -1) {
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			cr = nr;
			cc = nc;
			pos  = dir;
		}
	}
	
	static void clearArr()	{
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(arr[r][c] == 1) continue;
				if(arr[r][c] != 0) arr[r][c]= 0;
			}
		}
	}
}
