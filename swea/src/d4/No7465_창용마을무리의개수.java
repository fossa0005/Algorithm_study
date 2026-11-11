package d4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No7465_창용마을무리의개수 {
	static List<Integer>[] graph;
	static boolean[] visited;
	static int N, M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		graph = new ArrayList[N];
		visited = new boolean[N];
		for(int n=0; n<N; n++) {
			graph[n] = new ArrayList<>();
		}
		
		//무방향그래프
		for(int m=0; m<M; m++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			graph[n1].add(n2);
			graph[n2].add(n1);
		}
		
		for(int i=0; i<graph.length; i++) {
			if(visited[i]) continue;
			
		}
		
		
	}
	
	//같은 집합 방문처리
	public void check(int i) {
			for(int adjacent : graph[i]) {
				if(visited[adjacent]) continue;
				visited[adjacent] = true;
				check(adjacent);
			}
	}
} 
	

