package d4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class No14510_나무높이 {
	static int[] data;
	static int ans;
	static int highest;
	static ArrayList<Integer> remains; //3으로 나눈 나머지
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int N = sc.nextInt();
		highest = 0;
		
		data = new int[N];
		for(int n=0; n<N; n++) {
			data[n] = sc.nextInt();
		}
		
		Arrays.sort(data);
		highest = data[data.length -1];
		
		for(int i=0; i<data.length; i++) {
			data[i] = data[i]-highest;
			ans += data[i]/3 *3;
			if(data[i] % 3 != 0) remains.add(data[i] % 3);
		}
		
		Collections.sort(remains);
		
		while(! remains.isEmpty()) {
			if(remains.get(0) == 1) {
				remains.removeFirst();
			}
			ans++;
			
			if(remains.get(remains.size()-1) == 2) {
				remains.removeLast();
			}
			
			ans++;
		}
		
		System.out.println(ans);
	}
	
	//목표높이와의 차를 3으로 나눈 나머지를 구하면서 day+=몫
	//배열에 나머지 1,2 만 남김
	//정렬 후 앞(1), 뒤(2)에서 제거하면서 day++; 
	
	


}


