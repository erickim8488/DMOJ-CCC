import java.io.*;

public class AnimalFarm{
	
	public static void main(String args[]) throws IOException {
		DataInputStream stdin = new DataInputStream(System.in);
		System.out.println("Input number of pens:");
		int num = Integer.parseInt(stdin.readLine());
		int[][] fence = new int[num][9];
		int[][] cost = new int[num][8];
		
		for (int i = 0; i < num; i++) {
			System.out.println("Input number of edges:");
			int edge = Integer.parseInt(stdin.readLine());
			fence[i][0] = edge;
			
			System.out.println("Enter corner numbers:");
			for (int j = 0; j < edge; j++) {
				fence[i][j] = Integer.parseInt(stdin.readLine());
			}
			
			System.out.println("Enter the cost of the edges:");
			for (int j = 0; j < edge; j++) {
				cost[i][j] = Integer.parseInt(stdin.readLine());
			}
		}
		
		
	}
}
