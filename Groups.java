import java.io.*;

public class Groups {
	static int identity = -1;
	
	public static boolean Associate(int[][] group) {
		for (int i = 0; i < group.length; i++) {
			for (int j = i; j < group[0].length; j++) {
				if (group[group[i][j]-1][i] != group[group[i][j]-1][i])
					return false;
			}
		}
		return true;
	}
	
	public static boolean Identity(int[][] group) {
		for (int i = 0; i < group.length; i++) {
			int j = 0;
			while (j < group.length && group[i][j] == (j+1) && group[j][i] == (j+1))
				j++;
			if (j == group.length) {
				identity = i+1;
				return true;
			}
		}		
		return false;
	}
	
	public static boolean Inverse(int[][] group) {
		for (int i = 0; i < group.length; i++) {
			int count = 0;
			for (int j = 0; j < group[0].length; j++) {
				if (group[i][j] == identity) {
					count++;
					if (group[j][i] != identity)
						return false;
				}
			}
			if (count == 0)
				return false;
		}
		return true;
	}
	
	public static void main(String args[]) throws IOException {
		DataInputStream stdin = new DataInputStream(System.in);
		int n = Integer.parseInt(stdin.readLine());
		
		if (n <= 0)
			return;
		
		int[][] group = new int[n][n];
		for (int i = 0; i < n; i++) {
			String row = stdin.readLine();
			String arr[] = row.split(" ");
			for (int j = 0; j < n; j++) {
				group[i][j] = Integer.parseInt(arr[j]);
			}
		}
		
		if (!Identity(group) || !Inverse(group) || !Associate(group))
			System.out.println("No");
		else
			System.out.println("Yes");
	}
}