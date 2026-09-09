package d2;


import java.util.Arrays;
import java.util.Scanner;

public class No14510_나무높이 {
	static int[] data;
	static int ans;
	static int highest;
	static int shares, remains; //2로나눈 몫의 합, 나머지의 합
	; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			shares = 0;
			remains = 0;
			ans = 0;
			data = new int[N];
			
			for(int i=0; i<N; i++) {
				data[i] = sc.nextInt();
			}
			
			Arrays.sort(data);
			highest = data[data.length-1];
			
			//가장 높은 나무와의 높이 차로 배열 만듦
			for(int i=0; i<N; i++) {
				data[i] = highest-data[i]; 
			}
			
			//짝수일,홀수일 조건 생각 안할 때 최적 소요일 : 2로나눈 몫의 합 + 나머지의 합  
			for(int n : data) {
				shares += n / 2;
				remains += n%2;
			}
			
			//몫의 합이 나머지의 합보다 +1 초과해 차이나면 이틀에 나눠 줘야 쉬는 날을 최소화할 수 있음
			if(shares - remains > 1) {
				while(shares >= 0) {
					shares--;
					remains+=2;
					
					if(shares - remains <= 1) { 
						break;
					}
				}
			}
			
			ans = shares+remains;
			
			//최적화 후에도 남은 차이에 의한 쉬는날 더하기
			if(shares > remains) ans += shares-remains;
			else if(remains > shares+1) ans += remains-(shares+1);
			
			System.out.println("#" + t + " " + ans);
		}
		
	}
}



