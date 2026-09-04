package d4;

import java.util.List;
import java.util.Scanner;

public class No8275_햄스터 {
	List<int[]> cages;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N개 우리, 최대 X마리, M개 기록 
		//l번 우리에서 r번 우리까지 햄스터수 s마리
		
		int N = sc.nextInt();
		int X = sc.nextInt();
		int M = sc.nextInt();
		
		Constraint[] constraints = new Constraint[M];
		for(int m=0; m<M; m++) {
			int l = sc.nextInt()-1;
			int r = sc.nextInt()-1;
			int s = sc.nextInt();
			constraints[m] = new Constraint(l,r,s);	
		}
		
		 
		for(int n=0; n<N; n++) {
			
		}
		
	}
}
	
	
		
	
	
		




class Constraint {
	int l, r, s;

	public Constraint(int l, int r, int s) {
		this.l = l;
		this.r = r;
		this.s = s;
	}
	
}
