package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class No3952_줄세우기 {
	static int[] indegree; //인덱스: 학생번호  값:진입차수
	static ArrayList<Integer>[] graph; //인덱스:학생번호 값:뒤에오는학생들
	static ArrayList<Integer> line; //결과 줄
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st= new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); 
			M = Integer.parseInt(st.nextToken()); 
			
			indegree = new int[N];
			line = new ArrayList<Integer>();
			graph = new ArrayList[N];
			
			//indegree, graph 완성
			for (int m =0; m<M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int front = Integer.parseInt(st.nextToken()) -1 ;
				int back = Integer.parseInt(st.nextToken()) -1 ;
				
				indegree[back] = indegree[back] +1 ;
				
				if(graph[front] == null) {
					graph[front] = new ArrayList<>(Arrays.asList(back));
				} else {
					graph[front].add(back);
				}
				 
			}
			
			
			//line 완성
			while(line.size() != N) { //줄을 모두 세울 때까지
				
				for(int i=0; i<indegree.length; i++) { 
					if(indegree[i] == 0) { //학생 i가 indegree가 0이면
						line.add(i); //줄에 세운 후
						indegree[i] = indegree[i] -1;
						
						if(graph[i] == null) continue; //뒤에오는 학생 없으면 넘어가기
						
						for(int student : graph[i]) { //graph에서 뒤에오는 학생 묶음을 찾아
							indegree[student] =  indegree[student]-1; //indegree 1씩 줄임
						}
					}
				}
			}
			
			sb.append("#" + t);
			for (int i=0; i<N; i++) {
				int num = line.get(i) + 1; //실제 학생번호는 1번부터 시작하므로 1씩더한다.
				sb.append(" " + num);
			}
			sb.append("\n");
			
		}
		
		System.out.println(sb);
		
		
	
		
	}

}
