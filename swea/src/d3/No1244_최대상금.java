package d3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class No1244_최대상금 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//제일 큰수 중 두 개를(같은 수 여러개면 제일 뒤 두개) 
		//더 작은수 중 제일 앞에 있는 두 개와 교환
		
		//두 수가 다름:
		//제일 큰 수를 더 작은 수 중 앞에 있는 수와 교환
		//두번째로 큰 수를 더 작은 수 중 두번째로 수와 교환
		
		//두 수가 같음:
		//앞에 있는 수를 더 작은 수 중 큰 수와 교환
		//뒤에 있는 수를 더 작은 수 중 작은 수와 교환 
		
		//최선(내림차순)인데, 스왑이 홀수번 남음:
		//제일 가운데 두 수를 서로 교환
		
		String input = sc.next();
		int n = sc.nextInt();
		List<Integer> list  = new ArrayList<>();
		List<Integer> sortedList  = new ArrayList<>(); 
		
		for(char c : input.toCharArray()) {
			int num = c - '0';
			list.add(num);
			sortedList.add(num);
		}
		
		Collections.sort(sortedList);
		
		System.out.println(list);
		System.out.println(sortedList);
		
		//3 2 7 8 6
		
		
		sc.close();
	
	}

}
