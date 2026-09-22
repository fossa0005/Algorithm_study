package d3;

import java.util.ArrayDeque;
import java.util.Scanner;

public class No10761_신뢰 {
	static int[] buttonsB, buttonsO; //[2, 4, 0, 0, 0, ....] [1, 2, 0, 0, 0, ...] 
	static ArrayDeque<String> pushOrder; //버튼 누르는 순서 [B, O, O, B]
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			buttonsB = new int[100];
			buttonsO = new int[100];
			pushOrder = new ArrayDeque<String>();
			
			for(int n=0, i=0, j=0; n<N; n++) {
				String robot = sc.next();
				if(robot.equals("B")) {
					buttonsB[i++] = sc.nextInt();
					pushOrder.addLast("B");
				}
				else {
					buttonsO[j++] = sc.nextInt();
					pushOrder.add("O");
				}
				
			}
			
			
			int time = 0;
			int posB = 1; int posO = 1;
			int idxB = 0; int idxO = 0; //목표 버튼 인덱스
			
			while(! pushOrder.isEmpty()) {
				time++;
				boolean flag = true; //버튼 누를 수 있는지(같은 초에 둘 중 하나만 누를수있음)
				
				//B
				if(buttonsB[idxB] != 0) { //목표버튼 존재
					//버튼으로 이동
					if(posB != buttonsB[idxB]) { 
						posB = buttonsB[idxB] < posB ? posB-1 : posB+1;
					}
					
					//버튼 누르기
					else if(flag && posB == buttonsB[idxB] && pushOrder.peek().equals("B")) {
						idxB++;
						flag = false;
						pushOrder.pop();
					}
					//대기
					else;
				}
				
				//O
				if(buttonsO[idxO] != 0) {
					//버튼으로 이동
					if(posO != buttonsO[idxO]) {
						posO = buttonsO[idxO] < posO ? posO-1 : posO+1;
					}
					
					//버튼 누르기
					else if(flag && posO == buttonsO[idxO] && pushOrder.peek().equals("O")) {
						idxO++;
						pushOrder.pop();
					}
					//대기
					else;
				}
			}
			
			System.out.println("#" + t + " " + time);
			
		}
		
		
	
	}
	
	
	

	
}

	

