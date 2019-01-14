import java.io.*;

public class FloorPlan {//make room number as "done" number	
	
	static int done;
	static int[][] d;
	
	public static int DirectionCheck(int[][] room, int dir, int row, int col) {
		for (int i = -1; i <= 1; i++) {
			dir = (dir + i) % 4;
			if (row + d[dir][0] >= 0 && row + d[dir][0] < room.length && col + d[dir][1] >= 0 && col + d[dir][1] < room[0].length &&room[row + d[dir][0]][col + d[dir][1]] == 0)
				return dir;
		}
		return -1;
	}
	
	public static void GetRooms(int[][] room, int row, int col, int currnum, int dir) {
		if (room[row][col] == 1) {
			col++;
			if (col == room[0].length) {
				col = 0;
				row++;
			}
			GetRooms(room, row, col, currnum, dir);
			return;
		}
		
		if (currnum == 0 || (row == room.length-1 && col == room[0].length-1)) {
			System.out.println(done + " rooms, " + currnum + " left over");
			return;
		}
		
		room[row][col] = 1;
		if (dir == 0)
			dir = DirectionCheck(room, 3, row, col);
		else
			dir = DirectionCheck(room, dir-1, row, col);
		
		if (dir == -1){
			GetRooms(room, 0, 0, currnum, 0);
			done++;
			return;
		}
		
		GetRooms(room, row+d[dir][0], col+d[dir][1], currnum-1, dir);
	}
	
	public static void main(String args[]) throws IOException {
		DataInputStream stdin = new DataInputStream(System.in);
		int num = Integer.parseInt(stdin.readLine());
		int r = Integer.parseInt(stdin.readLine());
		int c = Integer.parseInt(stdin.readLine());
		
		int[][] room = new int[r][c];
		for (int i = 0; i < r; i ++) {
			String input = stdin.readLine();
			String[] tmp = input.split(" ");
			for (int j = 0; j < c; j++) {
				room[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		d = new int[][]{ {-1,0}, {0,1}, {1,0}, {0,-1} };
		GetRooms(room, 0, 0, num, 0);
	}
}