import java.io.*;

public class Quantum {
	static int[][] outcome;
	
	public static int GetMax(int[][] array) {
		int max = array[0][0];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (max < array[i][j])
					max = array[i][j];
			}
		}
		return max;
	}
	
	public static int GetMin(int[][] array) {
		int min = array[0][0];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (min > array[i][j])
					min = array[i][j];
			}
		}
		return min;
	}
	
	public static void GetProduct(int[][] temp, int[][] input) {
		for (int i = 0; i < outcome.length; i++) {
			for (int j = 0; j < outcome[0].length; j++) {
				outcome[i][j] = temp[i/input.length][j/input[0].length] * input[i % input.length][j % input[0].length];
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
		DataInputStream stdin = new DataInputStream(System.in);
		System.out.print("How many matrices? ");
		int num = Integer.parseInt(stdin.readLine());
		int[][] temp = { {1} };
		
		for (int i = 0; i < num; i++) {
			System.out.println("Input number of rows, then columns");
			int[][] input = new int[Integer.parseInt(stdin.readLine())][Integer.parseInt(stdin.readLine())];
			
			for (int j = 0; j < input.length; j++) {
				String row = stdin.readLine();
				String[] arr = row.split(" ");
				for (int k = 0; k < input[0].length; k++) {
					input[j][k] = Integer.parseInt(arr[k]);
				}
			}
			outcome = new int[input.length*temp.length][input[0].length*temp[0].length];
			GetProduct(temp, input);
			temp = new int[outcome.length][outcome[0].length];
			temp = outcome;
		}
		
		System.out.println(GetMax(outcome));
		System.out.println(GetMin(outcome));
		
		int[][] rsum = new int[1][outcome[0].length];
		int[][] csum = new int[1][outcome.length];
		for (int i = 0; i < outcome.length; i++) {
			for (int j = 0; j < outcome[0].length; j++) {
				rsum[0][i] += outcome[i][j];
				csum[0][i] += outcome[j][i];
			}
		}
		
		System.out.println(GetMax(rsum));
		System.out.println(GetMin(rsum));
		System.out.println(GetMax(csum));
		System.out.println(GetMin(csum));
	}
}