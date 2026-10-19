package A형기출;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class No5658_보물상자비밀번호 {
	static int N, K;
	static int numLen;
	static char[] arr;
	static TreeSet<Integer> set; //자동정렬 set
	static int ans;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = sc.next().toCharArray();
			numLen = N /4;
			set = new TreeSet<Integer>();
			
			for(int start=0; start<N; start++) { //시작점 정하고
				for(int num_start=start, cnt=0; cnt<4; num_start+=numLen, cnt++) { //시작점부터 4그룹으로 그루핑
					StringBuilder sb = new StringBuilder();
					for(int n=0; n<numLen; n++) { //각 변의 숫자
						char c = arr[(num_start+n) % N];
						sb.append(c); //원형큐
					}
					//System.out.println(sb.toString());
					int num = Integer.parseInt(sb.toString(), 16);
					set.add(num);
				}
			}
			
			//System.out.println(set);
			ArrayList<Integer> list = new ArrayList<Integer>(set);
			Collections.sort(list);
			ans = list.get(list.size() - K);
			System.out.println("#" + t + " " + ans);
		}
	}
			
}
		
		
