package A형기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1767_프로세서연결하기 {
	
	static int N;
	static int[] dr = new int[]{-1,1,0,0, 0};
	static int[] dc = new int[]{0,0,-1,1, 0};
	static int[][] cores; // [[y,x] [y,x] ....] 각 코어 좌표(가장자리 제외)
	static int[][] arr;
	static int max_connected, min_length;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N][N];
			cores = new int[N*N][];
			
			max_connected = 0;
			min_length = Integer.MAX_VALUE;
			int connected = 0;
			int i = 0;
			for(int r=0; r<N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," "); //한 줄 공백단위로 나눔
				for(int c=0; c<N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
					if(arr[r][c] == 1) {
						if(r==0 || c == 0 || r==N-1 || c == N-1) {
							connected++;
							continue;
						}
						cores[i++] = new int[]{r, c}; //코어 좌표 저장
					}
				}
			}
			
			dfs(0, 0, 0, connected+1);
			dfs(0, 1, 0, connected+1);
			dfs(0, 2, 0, connected+1);
			dfs(0, 3, 0, connected+1);
			dfs(0, 4, 0, connected);
		
			sb.append("#" + t + " " + min_length + "\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	//상하좌우 중 뻗음 
	static void dfs(int i, int dir, int currLength, int connected) {
		
		if(cores[i] == null) { // 마지막 코어까지 경우의수 봤으면 갱신후 백트래킹
			if(connected > max_connected) {
				max_connected = connected;
				min_length = currLength;
			}
			
			if(connected==max_connected && currLength < min_length) {
				min_length = currLength;
			}
			
			return;
		}
		
		
		
		if(! canConnect(i, dir)) { //전선 겹칠시 백트래킹
			return;
		}
		
		
		currLength += connect(i, dir, 1); //연결
		
		
		dfs(i+1, 0, currLength, connected+1);
		dfs(i+1, 1, currLength, connected+1);
		dfs(i+1, 2, currLength, connected+1);
		dfs(i+1, 3, currLength, connected+1);
		dfs(i+1, 4, currLength, connected);
		
		connect(i, dir, 0);
		
	}
	
	public static boolean canConnect(int i, int dir) { //연결가능한지 체크
		boolean res = true;
		if(dir == 4) return res;
		int r = cores[i][0] + dr[dir];
		int c = cores[i][1] + dc[dir];
		
		while(r>=0 && r<N && c>=0 && c<N) {
			if(arr[r][c] == 1) {
				res = false;
				break;
			}
			
			r+=dr[dir];
			c+=dc[dir];
		}
		
		return res;
		
	}
	
	public static int connect(int i, int dir, int val) {
		if(dir == 4) return 0;
		
		int length = 0;
		int r = cores[i][0] + dr[dir];
		int c = cores[i][1] + dc[dir];
		
		while(r>=0 && r<N && c>=0 && c<N) {
			arr[r][c] = val;
			length++;
			
			r+=dr[dir];
			c+=dc[dir];
		}
		
		return length;
		
	}
	
	

}





	
	