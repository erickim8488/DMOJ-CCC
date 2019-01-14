import java.io.*;

public class Friends{
	
	public static int InCircle(int[][] friend, int curr, int goal, String history, int depth) {
		if (curr == goal) {
			return depth;
		}
		else if (history.indexOf(" " + curr + " ") != -1){
			return -1;
		}
			
		for (int i = 0; i < friend.length; i++) {
			if (friend[i][0] == curr) {
				history += curr + " ";
				return InCircle(friend, friend[i][1], goal, history, depth+1);
			}	
		}
		
		return -1;
	}
	
	public static void UploadArray(int[][] array, int row) throws IOException {
		DataInputStream stdin = new DataInputStream(System.in);	
		String input = stdin.readLine();
		String[] inputarray = input.split(" ");
		for (int i = 0; i < array[0].length; i++) {
			array[row][i] = Integer.parseInt(inputarray[i]);
		}
	}
	
	public static void main(String args[]) throws IOException{
		DataInputStream stdin = new DataInputStream(System.in);
		System.out.print("Enter number of students: ");
		int num = Integer.parseInt(stdin.readLine());
		
		System.out.println("Enter Friend Assignments:");
		int[][] friend = new int[0][0];
		for (int i = 0; i < num; i++) {
			int[][] temp = friend;
			friend = new int[i+1][2];
			for (int j = 0; j < friend.length-1; j++) {
				for (int k = 0; k < friend[0].length; k++) {
					friend[j][k] = temp[j][k];
				}
			}
			UploadArray(friend, i);
		}
		
		System.out.println("Enter Pairs");
		int row = 0;
		int[][] pair = new int[1][2];
		UploadArray(pair, 0);
		while (pair[row][0] != 0 && pair[row][1] != 0) {
			row++;
			int[][] temp = pair;
			pair = new int[row+1][2];
			for (int i = 0; i < pair.length-1; i++) {
				for (int j = 0; j < pair[0].length; j++) {
					pair[i][j] = temp[i][j];
				}
			}
			UploadArray(pair, row);
		}
		
		for (int i = 0; i < pair.length-1; i++) {
			for (int j = 0; j < friend.length; j++) {
				if (friend[j][0] == pair[i][0]) {
					int depth = InCircle(friend, friend[j][1], pair[i][1], " ", 0);
					if (depth > -1)
						System.out.println("Yes " + depth);
					else
						System.out.println("No");
				}
			}
		}
	}
}