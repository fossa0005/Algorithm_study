package d3;

import java.util.ArrayList;
import java.util.Scanner;

public class No10761_신뢰 {
	static int time;
	static int pos;
	static ArrayList<Integer> buttonsB, buttonsO;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int n=0; n<N; n++) {
			String robot = sc.next();
			if(robot.equals("B")) {
				buttonsB.add(sc.nextInt());
			}
			else buttonsO.add(sc.nextInt());
		}
		
		
		
	}

	static void simulate(int[] buttons) {
		for(int button : buttons) {
			time += button - pos + 1;
		}
	}
}
