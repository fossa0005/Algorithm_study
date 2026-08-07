package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagram {
	
	public static void main(String[] args) {
	
		System.out.println( groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}) );
		//System.out.println( groupAnagrams(new String[] {""}) );
		//System.out.println( groupAnagrams(new String[] {"a"}) );
		
		
	}
	
	//이중for문이 시간복잡도를 제곱수로 늘리므로 해쉬맵 사용
	// ate : [eat,tea,ate]
	//배열후 정렬 해 키값이 있으면 그룹에 추가
	
	public static List<List<String>> groupAnagrams(String[] strs) {
			HashMap<String, ArrayList<String>> map = new HashMap<>();
			List<List<String>> answer = new ArrayList<>();
		
			for(int i=0; i<strs.length; i++) {
				String str = strs[i];
				char[] arr = str.toCharArray();
				Arrays.sort( arr );
				String key = String.valueOf(arr); //ate
				
				if(! map.containsKey(key)) {
					map.put(key, new ArrayList<>());
				} 
					
				map.get(key).add(str);
			}	
				
				
			for (String k : map.keySet()) {
				answer.add(map.get(k));
			}
			
			
			System.out.println(map.toString());
	        return answer;
	}
}