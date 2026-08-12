package d3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class No5215_햄버거다이어트_fail {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//맛에 대한 칼로리 비가 낮은 순(기울기 낮은 순)으로 추가하되,
		//추가했을 때 제한 칼로리를 넘으면 다음 순 검토하기
		//맛이 매우 크면 칼로리비가 낮아서 앞순위 올 수 있음
		
		int test = sc.nextInt();
		for(int t=1; t<=test; t++) {
			
			List<Integer> tasteList = new ArrayList<>(); 
			HashMap<Integer, Integer> kalMap = new HashMap<>(); //맛 : 칼로리
			
			int N = sc.nextInt();
			int limit = sc.nextInt();
			
			for(int n=0; n<N; n++) {
				int taste = sc.nextInt();
				int kal = sc.nextInt();
				
				tasteList.add(taste);
				kalMap.put(taste, kalMap.getOrDefault(taste, 0)+ kal);
			}
			
			//System.out.println(tasteList);
			//System.out.println(kalMap);
			
			Collections.sort(tasteList, new Comparator<Integer>() {
				
				@Override
				public int compare(Integer t1, Integer t2) {
					double ratio1 = kalMap.get(t1)/(double)t1;
					double ratio2 = kalMap.get(t2)/(double)t2;
					return Double.compare(ratio1, ratio2);
				}

			});
			
			//System.out.println(tasteList);
			
			int totKal = 0;
			int score = 0;
			for(int taste : tasteList) {
				int kal = kalMap.get(taste);
				if(totKal + kal <= limit) {
					score += taste;
					totKal += taste; 
				} else {
					continue;
				}
			}
			
			System.out.println("#" + t + " " + score);
			
		}
		
	}


}







