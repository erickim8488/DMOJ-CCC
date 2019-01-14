import java.io.*;

public class Waterpark{
	static int[][] paths;
	static int count;
	
	public static void GetPaths(int curr, int num) {
		if (curr == num) {
			count++;
			return;
		}
		
		for (int i = 0; i < paths.length; i++) {
			if (paths[i][0] == curr)
				GetPaths(paths[i][1], num);
		}
	}
	
	public static void UploadPath(int row) throws IOException {
		DataInputStream stdin = new DataInputStream(System.in);
		if (row == paths.length) {
			int[][] temp = paths;
			paths = new int[row+1][2];
			for (int i = 0; i < temp.length; i++) {
				for (int j = 0; j < temp[0].length; j++) {
					paths[i][j] = temp[i][j];
				}
			}
		}
		String input = stdin.readLine();
		String[] inputarray = input.split(" ");
		for (int i = 0; i < paths[0].length; i++) {
			paths[row][i] = Integer.parseInt(inputarray[i]);
		}
	}
	
	public static void main(String args[]) throws IOException{
		DataInputStream stdin = new DataInputStream(System.in);
		System.out.print("Input number of marked points: ");
		int num = Integer.parseInt(stdin.readLine());
		
		System.out.println("Input available direct routes in form x y. Enter 0 0 to exit.");
		paths = new int[1][2];
		UploadPath(0);
		
		int row = 0;
		while (paths[row][0] != 0 && paths[row][1] != 0) {
			row++;
			UploadPath(row);
		}
		
		for (int i = 0; i < paths.length; i++) {
			if (paths[i][0] == 1)
				GetPaths(paths[i][1], num);
		}
		
		System.out.println(count);
	}
}