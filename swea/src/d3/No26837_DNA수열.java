package d3;
import java.util.Scanner;

public class No26837_DNA수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//짝수개 슬라이싱해야됨
		//뽑은 문자중에 반전관계끼린 갯수 같아야함
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			int N = sc.nextInt();
			String dna = sc.next();
			int ans = 0;
			
			////start 시작점두고 윈도우로 2개씩 추가하면서 확인
			for(int start=0; start<=N-2; start++) {
				int AT = 0; 
				int CG = 0;
				//길이 n
				
				//윈도우로 2개씩추가
				for(int left=start; left<=N-2; left+=2) {
							
						switch (dna.charAt(left)) {
							case 'A' : AT++; break;
							case 'T' : AT--; break;
							case 'C' : CG++; break;
							case 'G' : CG--; break;
						}
						
						switch (dna.charAt(left+1)) {
						case 'A' : AT++; break;
						case 'T' : AT--; break;
						case 'C' : CG++; break;
						case 'G' : CG--; break;
						}
						
						
						if(AT==0 && CG==0) {
							//System.out.println(dna.substring(start, left+2));
							ans++;
						}
				
				}
				
				
			}
			System.out.println("#" + t + " " + ans);		
		}
		
		
			
		}
		
}

