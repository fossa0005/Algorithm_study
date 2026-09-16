package A형기출;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 충전소설치하기 {
    static int[][] arr;
    static int[][] houses; //[r,c, x 허용거리]
    static ArrayList<int[]> ranges; //설치가능 후보 좌표들
    static int[][] chargers; //설치한 좌표들
    static int N;
    static int ans, minDistance;
    
    //설치범위 내 조합 1 -> 안되면 2
    // ㄴ모든 집 연결되는지 for(각 집) 두 설치소 중 하나라도 거리 <= x; 이중 최소 거리 더함
    // 
    public static void main(String args[]) throws Exception {
         Scanner sc = new Scanner(System.in);

         int T = sc.nextInt();
         for(int t=1; t<=T; t++) {
             int N = sc.nextInt();
             arr = new int[31][31];
             houses = new int[N][3];
             ranges = new ArrayList<int[]>();
             chargers = new int[2][2];
             ans = -1;
             minDistance = Integer.MAX_VALUE;


             for(int i=0; i<N; i++) {
                int c = sc.nextInt(); // x -> c;
                 c = 15+c;
                 int r = sc.nextInt(); //y -> r;
                 r = 15-r; 

                 int k = sc.nextInt();
                 
                 houses[i][0] = r;
                 houses[i][1] = c;
                 houses[i][2] = k;
                 arr[r][c] = 1;
             }

            getRange();
            
           //설치가능 범위중 한 곳 설치
           oneCharger:
           for(int i=0; i<ranges.size()-1; i++) {
        	   int chargerR = ranges.get(i)[0];
        	   int chargerC = ranges.get(i)[1];
        	   int sum = 0;
        	   
        	   for(int[] house : houses) {
                  int distance = Math.abs(house[0] - chargerR) 
                		  	+ Math.abs(house[1] - chargerC);
                  
                  if(distance > house[2]) continue oneCharger; //한 집이라도 연결안되면 패스
                  sum += distance;
        	   }
        	   
        	   //모든 집이 연결가능할 때만 갱신됨
        	   if(sum < minDistance) {
        		   //System.out.println("충전소: " + chargerR+ " " + chargerC );
        		   minDistance = sum; 
        	   }
        	}
            
            if(minDistance != Integer.MAX_VALUE) ans = minDistance;
            
          //설치가능 범위중 두 곳 설치
            else {
                for(int i=0; i<ranges.size()-2; i++) {
                    chargers[0] = ranges.get(i);
                    
                    twoCharger:
                    for(int j=i+1; j<ranges.size()-1; j++) {
                        chargers[1] = ranges.get(j);

                        int sum = 0;
                        for(int[] house : houses) {
                            if(getDistance(house) == -1) continue twoCharger; //한 집이라도 연결안되면 패스
                            sum += getDistance(house);
                        }
                        
                        //모든 집이 연결 가능할때만 갱신됨
                        if(sum < minDistance) {
                        	//System.out.println("충전소: " + Arrays.toString(chargers[0]) + " " + Arrays.toString(chargers[1]) );
                        	minDistance = sum;
                        }
                   
                    }

                }
                
                //System.out.println("집:" + Arrays.deepToString(houses));
                if(minDistance != Integer.MAX_VALUE) ans = minDistance; //최솟값이 갱신된 적 있으면(가능한 경우 있으면) 그게 답
            	
            }
            
            
            System.out.println("#" + t + " " + ans);

         }



    }

    //설치가능 후보지 구하기
    static void getRange() {
        for(int[] house : houses) {
            int a = house[0];
            int b = house[1]; 
            int x = house[2];
            
            for(int r=a-x; r<=a+x; r++) {
                for(int c=b-x; c<=b+x; c++) {
                    if(r<0 || r>30 || c<0 || c>30) continue;
                    if(arr[r][c] == 1) continue; //집이랑 충전소 겹치면안됨
                    int distance = Math.abs(r-a) + Math.abs(c-b);
                    if(distance <= x) {
                        ranges.add(new int[]{r, c});
                    }
                }
            }
        }
    }

    //집과 충전소의 최소거리 (허용거리 밖이면 -1)
    static int getDistance(int[] house) { 
        int res; 

        int distance1 = Math.abs(house[0] - chargers[0][0]) 
        			+ Math.abs(house[1] - chargers[0][1]);
        int distance2 =  Math.abs(house[0] - chargers[1][0]) 
        			+ Math.abs(house[1] - chargers[1][1]);
        
    res = Math.min(distance1, distance2);
    if(res > house[2]) res = -1;  //최소거리도 범위밖임 = 연결불가
    
    return res;
    }
    
    
}
