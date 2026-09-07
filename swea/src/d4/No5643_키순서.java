package d4;

import java.util.ArrayList;
import java.util.Scanner;


public class No5643_키순서 {
	static ArrayList<Integer>[] graphBigger; //인덱스:학생  값:그 학생보다 작은 학생 리스트
	static ArrayList<Integer>[] graphSmaller; //인덱스:학생  값:그 학생보다 큰 학생 리스트
	 
	static int N, M;
	static int cntBigger, cntSmaller;
	static boolean[] visited; //dfs 노드 중복카운트 방지 위한 방문여부 배열
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); 
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			graphBigger = new ArrayList[N];
			graphSmaller = new ArrayList[N];
			
			for(int i=0; i<N; i++) {
				graphBigger[i] = new ArrayList<Integer>(); 
				graphSmaller[i] = new ArrayList<Integer>();
			}
			
			
			for(int m=0; m<M; m++) {
				int smaller = sc.nextInt()-1; 
				int bigger = sc.nextInt()-1;
				
				graphSmaller[bigger].add(smaller);
				graphBigger[smaller].add(bigger);
				
			}
			
			ans = 0;
			for(int i=0; i<N; i++) {
				visited = new boolean[N];
				cntBigger = -1;
				countBigger(i);
				
				visited = new boolean[N];
				cntSmaller = -1;
				countSmaller(i);
				if(cntBigger + cntSmaller == N-1) {
					ans++;
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
		
		
	}
	
	//dfs
	static void countBigger(int i) {
		
		if(visited[i] == true) {
			return;
		}
		
		visited[i] = true;
		cntBigger++;
		
		for(int student : graphBigger[i]) {
			countBigger(student);
		}
	}
	
	static void countSmaller(int i) {
		
		if(visited[i] == true) {
			return;
		}
		
		visited[i] = true;
		cntSmaller++;
		
		for(int student : graphSmaller[i]) {
			countSmaller(student);
		}
	}
	
	

}
