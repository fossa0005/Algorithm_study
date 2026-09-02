package d3;

import java.util.Scanner;

public class No9229_한빈이와SpotMart{
    static int limit;
    static int N;
    static int[] snack;
    static int ans;
      
    public static void main(String[] args) {
        //test
        //과자개수, 제한무게
        //과자, 과자, 과자
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
         
        for(int t=1; t<=test; t++) {
            N = sc.nextInt();
            limit = sc.nextInt();
             
            snack = new int[N];
             
            for(int i=0; i<N; i++) {
                snack[i]=sc.nextInt();
            }
             
            ans = -1;
            dfs(0,0,0);
             
            System.out.println("#" + t + " " + ans);
             
        }
 
    }
 
 
 
    public static void dfs(int currentWeight, int i, int n) { //현재무게, 인덱스, 집은과자개수 
         
        if(currentWeight > limit) { //무게제한 넘을시 백트래킹 
            return;
        }
         
        if(n == 2) { //갯수다채움
            if(currentWeight > ans) ans = currentWeight;
            return;
        }
         
        if(i>N-1) { //갯수다못채우고 인덱스 전부순회
            return;
        }
         
        dfs(currentWeight + snack[i], i+1, n+1);
         
        dfs(currentWeight, i+1, n);
         
    }
}