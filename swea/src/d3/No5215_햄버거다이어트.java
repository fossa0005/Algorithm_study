package d3;

import java.util.Scanner;

public class No5215_햄버거다이어트 {
    static int limit;
    static int[] kal;
    static int[] taste;
    static int N;
    static int max_taste;
     
    public static void main(String[] args) {
             
          
        Scanner sc = new Scanner(System.in);
          
        //dfs로 푸는 문제임
         
        //기존방식:  
        //맛에 대한 칼로리 비가 낮은 순(기울기 낮은 순)으로 칼로리 넘지 않을때까지 추가함
        //반례) 효율은 떨어지지만 맛의 절대값이 큰 재료가 마지막에 오는게 나을수있음  
         
        int test = sc.nextInt();
        for(int t=1; t<=test; t++) {
              
            N = sc.nextInt();
            limit = sc.nextInt();
             
            kal = new int[N];
            taste = new int[N];
             
            for(int i=0; i<N; i++) {
                    taste[i] = sc.nextInt();
                    kal[i] = sc.nextInt();
            }
             
            max_taste = 0;
            dfs(0,0,0);
             
                 
                System.out.println("#" + t + " " + max_taste);
            
        }
 
    }
     
    static void dfs(int i, int currentTaste, int currentKal) {
            //총 칼로리 1000 안넘는 모든 조합 확인, 최댓값 갱신
             
            if (currentKal > limit) {
                return;
            }
             
            if (i==N) {
                if(currentTaste > max_taste) {
                    max_taste = currentTaste;
                }
                    return;
            }
            dfs(i+1, currentTaste + taste[i], currentKal+kal[i]);
             
            dfs(i+1, currentTaste, currentKal);
             
        }
  
}
