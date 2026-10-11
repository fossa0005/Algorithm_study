package A형기출;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class No1767_프로세서연결하기2 {
	static int[][] arr;
	static int N;
	static ArrayList<int[]> cores; //코어들 좌표 //가장자리 제외
	static int maxCnt, minLen; //최대연결개수, 최소길이 
	static int[] dr = new int[]{-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, +1, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			maxCnt = 0; 
			minLen = Integer.MAX_VALUE;
			cores = new ArrayList<int[]>();
			arr = new int[N][N];
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					arr[r][c] = sc.nextInt();
					if(arr[r][c] == 1) {
						if(r>0  && c>0) cores.add(new int[] {r, c});
					}
				}
			}
			
			dfs(0, 0, 0);
			
			System.out.println("#" + t + " " + minLen);
			
		}
		
		

	}
	
	static void dfs(int i, int cnt, int currLen) { //코어인덱스, 연결된 코어수, 전선길이
		//if(currLen >= minLen) return;
		// 길이가 초과해도 코어수 더많으면 갱신되는 경우이므로 백트래킹하믄안됨
		
		if(i == cores.size()) {
			if(cnt > maxCnt) {
				maxCnt = cnt;
				minLen = currLen;
			}
			
			if(cnt == maxCnt && currLen<minLen) {
				//System.out.println("개수: " + cnt + "길이 " + currLen);
				minLen = currLen;
			}
			
			return;
		}
		
		//현재코어 연결
		for(int dir=0; dir<4; dir++) {
			if (canConnet(cores.get(i), dir)) {
				int length = setOrRemoveWire(cores.get(i), dir, 1);
				//System.out.println("코어 " + Arrays.toString(cores.get(i))+ "길이 " + length);
				dfs(i+1, cnt+1, currLen + length);
				setOrRemoveWire(cores.get(i), dir, 0);
			}
		}
		
		//현재코어 연결안함
		dfs(i+1, cnt, currLen);
		
	}
	
	
	static boolean canConnet(int[] core, int dir) {
		int r = core[0]+dr[dir];
		int c = core[1]+dc[dir];
		while(r>=0 && r<N && c>=0 && c<N) {
			 if(arr[r][c] == 1) {
				return false; 
			 }
			 r += dr[dir];
			 c += dc[dir];
		}
		return true;
	}

	//연결&철거, 길이 반환
	static int setOrRemoveWire(int[] core, int dir, int value) {
		int len=0;
		int r = core[0]+dr[dir];
		int c = core[1]+dc[dir];
		while(r>=0 && r<N && c>=0 && c<N) {
			 arr[r][c] = value;
			 len++;
			 r += dr[dir];
			 c += dc[dir];
		}
		return len;
	}
}
