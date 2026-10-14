package A형기출;


import java.util.HashMap;

public class No5650_핀볼게임 {
	static int[][] arr;
	static int N;
	static int[] dr = {0, -1, 0, +1}; //우상좌하
	static int[] dc = {+1, 0, -1, 0};
	static HashMap<Integer, Integer[]> wormholes; // -6:[r, c] 6:[r,c]
	static int dir, cr, cc; //델타배열인덱스, 현재r, 현재c
	static int score;
	
	public static void main(String[] args) {
		
		
		
		
	}
	
	static void simulate(int sr, int sc, int sdir) {
		cr = sr;
		cc = sc;
		dir = sdir;
		
		go:
		while(true) {
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			
			//다음이 벽
			if(nr<0 || nr>=N || nc<0 || nc>=N) {
				score++;
				dir = goBack();
			}
			
			else {
				cr = nr;
				cc = nc;
				if (cr==sr && cc==nc) break go;
				int now = arr[cr][cc];
				switch(now) {
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
			}
		}
		
	}
	
	static int meetBlock(int block) {
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
		return ndir;
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
		int pair = num*-1;
		int nr = wormholes.get(pair)[0];
		int nc = wormholes.get(pair)[1];
		cr = nr;
		cc = nc;
	}


}

