package d4;


import java.util.ArrayList;
import java.util.Scanner;


public class 게리맨더링{ 
	static int N;
	static int ans = -1;
	static int minGap = Integer.MAX_VALUE;
	static ArrayList<Integer>[] graph; //인접구역 그래프
	static int[] population;
	static int[] groupNums; //선거구 0과 1로 나눔
	static boolean[] visited; 
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		population = new int[N];
		groupNums = new int[N];
		graph = new ArrayList[N];
		
		
		for(int i=0; i<N; i++) {
			population[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			int J = sc.nextInt();
			for(int j=0; j<J; j++) {
				list.add(sc.nextInt()-1);
			}
			
			graph[i] = list;
		}
		
		
		
		//개수가 정해져있지 않은 분할 경우의수 -> 0번지역을 무조건 1선거구에 할당
		groupNums[0] = 1;
		int total=0;
		for(int i=0; i<N; i++) {
			total += population[i];
		}
		dfs(1, 1, total-population[0], population[0]);
		
		if(minGap != Integer.MAX_VALUE) ans = minGap;
		
		System.out.println(ans);
		
	}
	
	//분할 경우의수 dfs
	static void dfs(int i, int cnt, int pop0, int pop1) {
		if(i == N) {
			if(cnt == N) return; //1번선거구 몰빵 경우의수 배제
			visited = new boolean[N];
			if(isConnected()) {
				int gap = Math.abs(pop0 - pop1);
				minGap = gap < minGap ? gap : minGap;
			}
			return;
		}
		
		
		groupNums[i] = 1;
		dfs(i+1, cnt+1, pop0-population[i],  pop1+population[i]);
		
		groupNums[i] = 0;
		dfs(i+1, cnt, pop0, pop1);
		
	}
	
	
	
	//각 선거구가 연결상태인지
	static boolean isConnected() { 
		boolean res = true; 
		
		//0번선거구
		for(int i=0; i<N; i++) {
			if(groupNums[i] == 0) {
				dfs2(i, 0); 
				break;
			}
			
		}
		
		//1번선거구
		dfs2(0, 1);
		
		
		for(boolean b : visited) {
			if (b == false) {
				res = false; 
				break;
			}
		}
		
		return res;
	}
	
	
	//연결검사 그래프 dfs
	//각 선거구의 첫 구역에서 출발해서 모두 visted되면 연결된 것
	static void dfs2(int region, int groupNum) {
		visited[region] = true;
		
		for(int nextRegion : graph[region]) {
			if(groupNums[nextRegion] != groupNum) continue;
			if(visited[nextRegion]) continue;
			dfs2(nextRegion, groupNum);
		} 
	}
	
	
}
