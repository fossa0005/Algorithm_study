package d3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class 봉사활동 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t = 1; t<=tc; t++) {
			int ans =-1;
			int N =  sc.nextInt();
			int min = sc.nextInt();
			int max = sc.nextInt();
			
			
			
			List<Integer> scores = new ArrayList<>();
			
			
			
			for(int n=0; n<N; n++) {
				scores.add(sc.nextInt());
			}
			
			
			
			//점수: 명수
			Map<Integer, Integer> map = new HashMap<>();
			
			for(int score : scores) {
				map.put(score, map.getOrDefault(score,0)+1 );
			}
			
			
			List<Integer> scoreSet = new ArrayList<Integer>( map.keySet()); 
			Collections.sort(scoreSet);
			
			int[] clss = new int[]{0,0,0};
			for(int left=0; left<=scoreSet.size()-3; left++) {
				clss[0] += map.get(scoreSet.get(left));
					if(clss[0] < min) continue;
					if(clss[0] > max) break;
				
				//슬라이딩 윈도우
				boolean flag = false;
				clss[1] = 0;
				clss[2] = 0;
				for(int right=left+1; right<=scoreSet.size()-2; right++) {
					
					clss[1] += map.get(scoreSet.get(right));
					if(clss[1] < min) continue;
					if(clss[1] > max) break;
					
					clss[2] = N-clss[0]-clss[1];
					if(clss[2] < min) break;
					if(clss[2] > max) continue;
					
					//System.out.println("점수 컷:" + scoreSet.get(start) + "," + scoreSet.get(left));
					//System.out.println("학생수:" + Arrays.toString(clss));
					flag = true;
				}
				
				if(flag == true) {
					Arrays.sort(clss);
					if(clss[2] - clss[0] < Integer.MAX_VALUE) {
						ans = clss[2] - clss[0];
					}
				}
				
			}
			
			System.out.println("#" + t + " " + ans);
			
		}
	
	sc.close();
	}

}
