package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class 문자열압축 {
	public static void main(String[] args) {
		System.out.println(listMaker(3, "abcabcdede")); //2abcdede
		System.out.println(listMaker(1, "aaae"));  //3ae
	
		System.out.println(solution("aabbaccc"));
		System.out.println(solution("ababcdcdababcdcd"));
	}
	
	
	public static int solution(String s) {
		int answer = s.length();
		
		for(int n=1; n<=s.length(); n++) {
			int compressed = listMaker(n,s);
			if(compressed < answer) {
				answer = compressed;
			}
		}
		
		return answer;
	}
	
	
	public static int listMaker(int n, String s) { //n: 자르는 문자 개수
		
		char[] arr = s.toCharArray(); //[abcabcbdede]
		List<Group> list = new ArrayList<>();
		
		//abc abc abc e [(abc, 3) (e, 1)]
		//abc abc ded e [(abc, 3) (ded, 1) (e, 1)]
		// abc ddd abc  [(abc, 1) (ddd, 1) (abc, 1)]
		String prior_set = "";
		
		for(int i=0; i<arr.length; i+=n) {
			String set;
			if(i+n <= arr.length-1) { 
				set = String.valueOf(Arrays.copyOfRange(arr, i, i+n));
			} else { //남은 문자가 n개 미만이면
				set = String.valueOf(Arrays.copyOfRange(arr, i, arr.length));
			}
			
			if(prior_set.equals(set)) {
				list.get(list.size()-1).repetition ++;
				continue;
			}
			
			prior_set = set;
			Group group = new Group(set, 1);
			list.add(group);
			
		}
		
		//System.out.println(list);
		
		//압축길이
		int cnt = 0;
		for(Group group : list) {
			if(group.repetition == 1) {
				cnt += group.set.length();
			} else {
				cnt = cnt + group.set.length() + String.valueOf(group.repetition).length();
			}
		}
		
		return cnt;
			
	}
}


class Group {
	String set;
	int repetition;
	
	Group(String set, int repetition) {
		this.set = set;
		this.repetition = repetition;
	}

	@Override
	public String toString() {
		return "Group [set=" + set + ", repetition=" + repetition + "]";
	}
	
}