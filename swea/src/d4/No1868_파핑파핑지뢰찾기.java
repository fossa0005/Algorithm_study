package d4;

public class No1868_파핑파핑지뢰찾기 {
	static int N;
	static int ans;
	static char[][] arr;
	
	public static void main(String[] args) {

	}
	
	//0 덩어리는 그중 어떤 0을 클릭하든 한번에 밝힐수있음
	
	static int countMine(int a, int b) {
		int res = 0;
		
		for(int r=a-1; a<=a+1; a++) {
			for(int c=b-1; b<=b+1; b++) {
				if(arr[r][c] == '*') {
					res++;
				}
				
				else if(arr[r][c] == '.') {
					
				}
			}
		}
		
		return res;
	}
	
	
	

}












