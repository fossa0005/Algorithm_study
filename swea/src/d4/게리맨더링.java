package d4;

import java.util.ArrayList;
import java.util.Arrays;

public class 게리맨더링{ 
	static int N;
	static ArrayList<Integer>[] graph; //인접구역 그래프
	static int[] groupNums; //0과 1로 나눔
	static boolean[] visited; //연결됨
	public static void main(String[] args) {
		
	}
	
	static boolean isConnected() { //모든 구역이 연결되었는지
		boolean res = true; 
		
		ArrayList<Integer> temp = new ArrayList<>(groupNums);
		
		dfs2(temp.indexOf(0), 0);
		dfs2(temp.indexOf(1), 1);
		
		for(int i : group) {
			if (visited[i] == false) {
				res = false; 
				break;
			}
		}
		
		return res;
	}
	
	//각 선거구의 첫 구역에서 출발해서 모두 visted되면 연결된 것
	static void dfs2(int region, int groupNum) {
		
		for(int nextRegion : graph[region]) {
			if(groupNums[nextRegion] != groupNum) continue;
			if(visited[nextRegion]) continue;
			visited[region] = true;
			dfs2(nextRegion, groupNum);
		} 
	}
	
	
	/** 못풀겠쥐? */

}
