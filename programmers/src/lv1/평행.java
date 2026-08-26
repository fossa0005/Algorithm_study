package lv1;

import java.util.HashMap;
import java.util.Map;

public class 평행 {

	public static void main(String[] args) {

	}
	
    public int solution(int[][] dots) {
        int answer = 0;
       
        double slope1;
        double slope2;
        
        slope1 = (double)(dots[0][1]  - dots[1][1])  / (dots[0][0]  - dots[1][0]) ;
        slope2 = (double)(dots[2][1]  - dots[3][1])  / (dots[2][0]  - dots[3][0]) ;
        		
        if(slope1 == slope2) {
        	answer = 1;
        	return answer;
        }
        
        slope1 = (double)(dots[0][1]  - dots[2][1])  / (dots[0][0]  - dots[2][0]) ;
        slope2 = (double)(dots[1][1]  - dots[3][1])  / (dots[1][0]  - dots[3][0]) ;
        		
        if(slope1 == slope2) {
        	answer = 1;
        	return answer;
        }
        
        slope1 = (double)(dots[0][1]  - dots[3][1])  / (dots[0][0]  - dots[3][0]) ;
        slope2 = (double)(dots[1][1]  - dots[2][1])  / (dots[1][0]  - dots[2][0]) ;
        		
        if(slope1 == slope2) {
        	answer = 1;
        	return answer;
        }
        
        return answer;
       
    }

}



