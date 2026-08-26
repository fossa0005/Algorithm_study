package d2;

import java.util.Scanner;

public class No1926_간단한369게임 {
	static String[] sArr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sArr = new String[N];
		
		
		
		for (int i = 1; i <= N; i++) {
			String s = String.valueOf(i); // "1", "2", ... "N"
			 
			//3 또는 6 또는 9가있으면
			//3 6 9의 갯수를 세어 그 갯수만큼 "-"이 출력되어야함 
			
			if(s.contains("3") || s.contains("6") || s.contains("9")) { //3 6 9가 있으면
				int cnt = (s.length() - s.replace("3", "").length()) +
						(s.length() - s.replace("6", "").length()) + 
						(s.length() - s.replace("9", "").length()); //369의 개수
				
				for(int n=0; n<cnt; n++) {
					System.out.print("-"); 
				}
				
				System.out.print(" ");
				continue;
			}
			
			System.out.print(s); //3 6 9가 없으면
			System.out.print(" ");
		}
	
	}

}
