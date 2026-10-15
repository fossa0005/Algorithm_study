package A형기출;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class No5650_핀볼게임 {
	static int[][] arr;
	static int N;
	static int[] dr = {0, -1, 0, +1}; //우상좌하
	static int[] dc = {+1, 0, -1, 0};
	static HashMap<Integer, Integer[]> wormholes; // -6:[r, c] 6:[r,c]
	static int dir, cr, cc;
	static int score;
	static int max_score;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N][N];
		wormholes = new HashMap<>();
		max_score = 0;
		

		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				arr[r][c] = sc.nextInt();
				if(arr[r][c]>=6 && arr[r][c] <= 10) { //웜홀 저장
					int key = arr[r][c];
					if(wormholes.containsKey(key)) wormholes.put(key*-1, new Integer[] {r, c});
					else wormholes.put(key, new Integer[]{r, c});
				}
			}
		}
		System.out.println(wormholes);
		score=0;
		simulate(0, 4, 0);
		System.out.println(score);
		
		/*
		System.out.println(wormholes);
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				for(int d=0; d<4; d++) {
					if(arr[r][c] == 0) {
						score = 0;
						simulate(r, c, d);
						System.out.println("점수: " + score);
						if(score > max_score) max_score = score;
					}
				}
			}
		}
		
		System.out.println(max_score);
		*/
	}
	
	static void simulate(int sr, int sc, int sdir) {
		cr = sr;
		cc = sc;
		dir = sdir;
		
		go:
		while(true) {
			System.out.println("현재위치:" + cr + " " + cc + " " + arr[cr][cc]);
			int now = arr[cr][cc];
			switch(now) {
				case 0 : {
					break;
				}
				case 1 :
				case 2 :
				case 3 :
				case 4 : 
				case 5 : {
					score++;
					meetBlock(now);
					break;
				}
				case 6 :
				case 7 :
				case 8 :
				case 9 :
				case 10 : {
					meetWormhole(now);
					break;
				}
				case -1 : break go;
			}
			
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N) { //다음이 벽
				score++;
				dir = goBack();
			} 
			
			else if (nr==sr && nc==sc) { //다음이 시작점
				break go;
			}
			
			else { 
				cr = nr;
				cc = nc;
			}
		}
		
	}
	
	static void meetBlock(int block) {
		int ndir = -1;
		switch(block) {
			case 1: {
				if(dir==3) ndir=0;
				else if(dir==2) ndir=1;
				else ndir=goBack();	
				break;
			} 
			case 2: {
				if(dir==1) ndir=0;
				else if(dir==2) ndir=3;
				else ndir=goBack();	
				break;
			}
			case 3: {
				if(dir==1) ndir=2;
				else if(dir==0) ndir=3;
				else ndir=goBack();	
				break;
			}
			case 4: {
				if(dir==3) ndir=2;
				else if(dir==0) ndir=1;
				else ndir=goBack();	
				break;
			}
			case 5: {
				ndir=goBack();
			}
		}
		dir = ndir;
	}
	
	static int meetWall() {
		return goBack();
	}
	
	static int goBack() {
		if(dir==0) return 2;
		else if(dir==2) return 0;
		else if(dir==1) return 3;
		else return 1;
	}
	
	static void meetWormhole(int num) {
		Integer[] pair = wormholes.get(num*-1);
		int nr = pair[0];
		int nc = pair[1];
		cr = nr;
		cc = nc;
	}


}

