package d4;

import java.util.Arrays;
import java.util.Scanner;

public class No3124_최소스패닝트리 {
	static int[] parent;
	static Edge[] edges;
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			edges  = new Edge[E]; 
			for(int i=0; i<E; i++) {
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				int weight = sc.nextInt();
				
				edges[i] = new Edge(u,v,weight);
			}
			
			Arrays.sort(edges, (e1, e2) -> e1.weight - e2.weight);
			
			
			
			parent = new int[V];
			for(int v=0; v<V; v++) {
				parent[v] = v;
			}
			
			
			int cnt = 0;
			long weightSum = 0;
			for(Edge edge : edges) {
				if(union(edge)) {
					cnt++;
					weightSum += edge.weight;
				}
				
				if(cnt == V-1) break;
			}
			
			System.out.println("#" + t + " " + weightSum);
			
		}
		
		
	}
	
	//사이클 가능성 검사 후 간선 채택
	static boolean union(Edge edge) {
		int rootU = find(edge.u);
		int rootV = find(edge.v);
		
		//루트노드 서로 다르면(사이클 안되면) 노드 u와 v연결
		if(rootU != rootV) {
			parent[rootV] = rootU; //정점 u와 v가 같은 집합임
			return true;
		}
		
		return false;
	}
	
	//루트노드 반환
	static int find(int i) {
		if(parent[i] == i) return i;
		
		int root = find(parent[i]);
		parent[i] = root; //경로압축
		return root;
	}
	

}

class Edge {
	int u, v, weight;
	
	public Edge(int u, int v, int weight) {
		this.u = u;
		this.v = v;
		this.weight = weight;
	}

}
