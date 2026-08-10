package d3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class 쉬운삼각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//o         o   
		//o			        o
		//o       o
		
		//(0,1) (0,2) (0,3)    (4,1)(5,3)(6,2)
		//x축 상의 두개 이상 점 중에서
		//같은 y축에 점 있어야함
		
		// x:(y,y,y) x:(y) x:(y)
		// y:(x,x) y:(x,x) y:(x,x)
		int trial = sc.nextInt();
		
		for(int t=0; t<trial; t++) {
			int  n = sc.nextInt();
			HashMap<Integer, ArrayList<Integer>> xMap = new HashMap<>();
			HashMap<Integer, ArrayList<Integer>> yMap = new HashMap<>();
			List<Integer> sizes = new ArrayList<>();
			for(int  i=0; i<n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				if(! xMap.containsKey(x)) {
					xMap.put(x, new ArrayList<Integer>());	
				}
				if(! yMap.containsKey(y)) {
					yMap.put(y, new ArrayList<Integer>());	
				}
				
				xMap.get(x).add(y);
				yMap.get(y).add(x);
			}
			
			//System.out.println(xMap);
			//System.out.println(yMap);
			
			for(int x : xMap.keySet()) {
				//x축 상에 점 두개 이상 아니면 넘어가기
				if (xMap.get(x).size() < 2) {
					continue;
				}
				
				for(int i=0; i< xMap.get(x).size(); i++) {
					for(int j=i+1; j<xMap.get(x).size(); j++) {
						int y1 = xMap.get(x).get(i); 
						int y2 =  xMap.get(x).get(j);
						int height = Math.abs( y1 - y2 );
						
						int width1 = 0;
						int width2 = 0;
						int max_width = 0;
						
						
						if( yMap.containsKey(y1)) {
							int gap1 = Math.abs(x - Collections.max(yMap.get(y1))) ; 
							int gap2 = Math.abs(x - Collections.min(yMap.get(y1))) ; 
							width1 = (gap1 > gap2 ? gap1 : gap2);
						}
						
						if (yMap.containsKey(y2)) {
							int gap3 = Math.abs(x - Collections.max(yMap.get(y2))) ; 
							int gap4 = Math.abs(x - Collections.min(yMap.get(y2))) ; 
							width2 = (gap3 > gap4 ? gap3 : gap4);
						}
							
						max_width = (width1 > width2 ? width1 : width2);
						
						
						sizes.add(height*max_width);
						
			
					}
					
				}
					
			}
			
			System.out.println(Collections.max(sizes));	
		
			
		}
	
	}

}
