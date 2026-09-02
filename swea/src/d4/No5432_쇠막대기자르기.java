package d4;

import java.util.Scanner;

public class No5432_쇠막대기자르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] data;
		
		
		
		int test = sc.nextInt();
		
		for(int t=1; t<=test; t++) {
			int res =0; //조각 개수
			int num = 0, currentNum = 0; //전체 막대기 개수, 현재 지나가는 막대개수
			
			data = sc.next().toCharArray();
			
			
			for(int i=0; i<data.length; i++) {
				//레이저가 지나가는 막대의 개수만큼 조각 추가됨
				if(i<data.length-1 && data[i] == '(' && data[i+1] == ')') {
					res += currentNum;
					i++;
					continue;
				}
				
				if(data[i] == '(') {
					num++;
					currentNum++;
				}
				
				if(data[i] == ')') {
					currentNum--;
				}
				
			}
			
			res += num;
		
			System.out.println("#" + t + " " + res);
		
		}
		
		
		}
			
}
		

