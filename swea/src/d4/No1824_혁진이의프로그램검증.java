package d4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class No1824_혁진이의프로그램검증 {
	static String ans;
	static int R,C;
	static int dir; 
	static char[][] arr;
	static boolean[][][][] visited; // r,c, 진입시 방향, 진입시 메모리 
	static ArrayDeque<Status> stack;
	static int[] dr = new int[]{-1, 1, 0, 0};
	static int[] dc = new int[]{0, 0, -1, +1};
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			ans = "NO";
			R = sc.nextInt();
			C = sc.nextInt();
			arr = new char[R][C];
			visited = new boolean[R][C][4][16];
			stack = new ArrayDeque<>();

			for(int r=0; r<R; r++) {
				String line = sc.next();
				for(int c=0; c<C; c++) {
					arr[r][c] = line.charAt(c);
				}
			}
			
			//System.out.println(Arrays.deepToString(arr));
			
			
			int memory = 0;
			int cr = 0; int cc = 0;
			int dir = 3;
			
			stack.push(new Status(cr, cc, dir, memory));
			visited[0][0][3][0] = true;
			process();
			
			System.out.println("#" + t + " " + ans);
		}
	
	}
	
	
	static void process() throws Exception {
		
		program:
		while(! stack.isEmpty()) {
			Status now = stack.pop();
			int cr = now.cr;
			int cc = now.cc;
			int dir = now.dir;
			int memory = now.memory;
			visited[cr][cc][dir][memory] = true; //들어와서 방문처리
			
			char command = arr[cr][cc];
			//System.out.println("현재위치: "+ arr[cr][cc] +" " + cr + " " + cc );
			
			switch (command) {
				case '<','>','^','v','_','|' : {
					int ndir = switchDir(command, memory); 
					int nr = (cr+dr[ndir] +R) % R;
					int nc = (cc+dc[ndir] + C) % C;
					if(visited[nr][nc][ndir][memory]) continue;
					stack.push(new Status(nr, nc, ndir, memory));
					
					break;
				}
				case '0','1','2','3','4','5','6', '7', '8', '9', '-', '+' : {
					int nmemory = calMemory(command, memory);
					int nr = (cr+dr[dir] +R) % R;
					int nc = (cc+dc[dir] + C) % C;
					if(visited[nr][nc][dir][nmemory]) continue;
					stack.push(new Status(nr, nc, dir, nmemory));
					
					break;
				}
				case '?': {
					for(int ndir=0; ndir<4; ndir++) {
						int nr = (cr+ dr[ndir] +R) % R;
						int nc = (cc+ dc[ndir] + C) % C;
						if(visited[nr][nc][ndir][memory]) continue;
						stack.push(new Status(nr, nc, ndir, memory));
					}
					
					break;
				}
				case '@' : {
					ans = "YES";
					break program;
				}
				case '.' : {
					int nr = (cr+dr[dir] +R) % R;
					int nc = (cc+dc[dir] + C) % C;
					if(visited[nr][nc][dir][memory]) continue;
					stack.push(new Status(nr, nc, dir, memory));
					break;
				}
				default : throw new Exception();
			}
		}
		
	}
	
	static int switchDir(char c, int memory) throws Exception {
		int ndir = switch(c) {
		case '<' -> 2;
		case '>' -> 3;
		case '^' -> 0;
		case 'v' -> 1;
		case '_' -> memory == 0 ? 3 : 2;
		case '|' -> memory == 0 ? 1 : 0;
		default  -> throw new Exception();
		};
		
		return ndir;
		
	}
	
	static int calMemory(char c, int memory) {
		int res;
		if('0' <= c && c <= '9') res = c - '0';
		else if(c == '+') res = (memory+1) % 16;
		else res = (memory-1 +16) % 16;
		
		return res;
	}

}


class Status {
	int cr, cc;
	int dir;
	int memory;
	
	
	Status(int cr, int cc, int dir, int memory) {
		this.cr = cr;
		this.cc = cc;
		this.dir = dir;
		this.memory = memory; 
	}
	
}


