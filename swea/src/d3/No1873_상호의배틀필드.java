package d3;


import java.util.Scanner;

public class No1873_상호의배틀필드 {
	static char[][] arr;	
	static char[] commands;	
	static char tank = ' '; //탱크 자세
	static int posY, posX; //탱크 위치
	static int h,w;
	
	//항상 y,x 순으로 쓰는 습관 들이기
	//4사분면 형태임을 항상 유의 (U이면 y좌표 -)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		for(int t =1; t<=test; t++) {
			
			h = sc.nextInt();
			w = sc.nextInt();
			
			arr = new char[h][];
			
			//맵 세팅
			for(int y=0; y<h; y++) {
				arr[y] = sc.next().toCharArray();
				for(int x=0; x<w; x++) {
					if(arr[y][x] == '^' || arr[y][x] == 'v' || arr[y][x] == '<' || arr[y][x] == '>') {
						tank = arr[y][x];
						posY = y;
						posX = x;
					}
				}
			}
			
			
			//커맨드세팅
			int n = sc.nextInt();
			commands = sc.next().toCharArray();
			
		
			
			//실행
			for(char c : commands) {
				switch(c) {
					case 'U' : tank = '^'; move(-1, 0); break;
					case 'D' : tank = 'v'; move(+1, 0); break;
					case 'L' : tank = '<'; move(0, -1); break;
					case 'R' : tank = '>'; move(0, +1); break;
					case 'S' : shoot(); break;
				}
				
				//System.out.println("탱크자세: " + tank);
				//System.out.println("탱크위치: " + posY + " " + posX);
			}
			
			//출력
			System.out.print("#" + t + " ");
			for(int y=0; y<h; y++) {
				for (int x=0; x<w; x++) {
					System.out.print(arr[y][x]);
				}
				
				System.out.println();
			}
			
		}
		
		
		
	}
	
	
	public static void move(int dirY, int dirX) {
		if(posY+dirY < 0 || posY+dirY >= h || posX+dirX < 0 || posX+dirX >= w ) {
			arr[posY][posX] = tank;
			return;
		}
		
		if( arr[posY+dirY][posX+dirX] != '.') {
			arr[posY][posX] = tank;
			return;
		}
		
		arr[posY][posX] = '.';
		posY += dirY;
		posX += dirX;
		arr[posY][posX] = tank;
	}
	
	
	public static void shoot() {
		int dirY = 0;
		int dirX = 0;
		
		
		switch(tank) {
		 case '^' : dirY = -1; break;
		 case 'v' : dirY = +1; break;
		 case '<' : dirX = -1; break;
		 case '>' : dirX = +1; break;
		}
		
		int y = posY + dirY; 
		int x = posX + dirX; //포탄위치
		
		while(x>=0 && x<w && y>=0 && y<h) {
			
			if(arr[y][x] == '*') {
				arr[y][x] = '.';
				return;
			}
			
			if(arr[y][x] == '#') {
				return;
			}	
			
			y += dirY;	
			x += dirX;
		}
	}
	
	

}
