package d4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class No1824_혁진이의프로그램검증 {
	static String ans = "NO";
	static boolean flag = false;
	static int R,C;
	static int memory;
	static int dir;
	static int cr, cc;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dr = new int[]{-1, 1, 0, 0};
	static int[] dc = new int[]{0, 0, -1, +1};
	
	//?에서 랜덤 방향의 경우의 수를 모두 고려하여 하나라도 @
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		arr = new char[R][C];
		visited = new boolean[R][C];
		System.out.println(R + " " + C);
		
		for(int r=0; r<R; r++) {
			String line = sc.next();
			for(int c=0; c<C; c++) {
				arr[r][c] = line.charAt(c);
			}
		}
		
		System.out.println(Arrays.deepToString(arr));
		
		memory = 0;
		cr = 0; cc = 0;
		dir = 3;
		move();
		
		System.out.println("#" + " " + ans);

	}
	
	//
	static void move() throws Exception {
		flag = true;
		
		while (true) {
			int nr = (cr+dir +R) % R;
			int nc = (cr+dir + C) % C;
			if(visited[nr][nc]) {
				System.out.println("재방문");
				break;
			}
			
			cr = nr;
			cc = nc;
			visited[cr][cc] = true;
			char command = arr[cr][cc];
			System.out.println("현재위치:" + arr[cr][cc]);
			
			switch (command) {
			case '<','>','^','v','_','|' : switchDir(command); break;
			case '-', '+' : calMemory(command); break;
			case '?': 
			case '@' : ans = "YES"; break;
			case '.' : continue;
			default : throw new Exception(); 
			}
		}
		
		System.out.println();
	}
	
	
	static void switchDir(char c) throws Exception {
		int ndir = switch(c) {
		case '<' -> 2;
		case '>' -> 3;
		case '^' -> 0;
		case 'v' -> 1;
		case '_' -> memory == 0 ? 3 : 2;
		case '|' -> memory == 0 ? 1 : 0;
		default  -> throw new Exception();
		};
		
		dir = ndir;
	}
	
	static void calMemory(char c) {
		if(c == '+') memory = (memory+1) % 16;
		if (c == '-') memory = (memory-1 +16) % 16;
	}
	


}


