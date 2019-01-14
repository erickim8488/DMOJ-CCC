import java.io.*;

public class TruckingTroubles {//if direction is to be considered, put road direction (1-2) in history, not node
	
	static int maxweight;
	
	public static void GetWeight(int[][] roads, String dest, int maxw, String history, int curr) {
		if (history.indexOf(" " + curr + " ") >= 0) {
			return;
		}
		
		String current = " "+curr+" ";
		int index = dest.indexOf(current);
		if (index >= 0) {
			dest = dest.substring(0,index) + dest.substring(index + current.length() -1);
		}
		
		if (dest.equals(" ")) {
			if (maxw > maxweight)
				maxweight = maxw;
			return;
		}
		
		history +=  curr + " ";
		
		for (int i = 0; i < roads.length; i++) {
			int tmp = maxw;
			if (maxw == 0 || roads[i][2] < maxw)
				tmp = roads[i][2];
			
			if (roads[i][0] == curr)
				GetWeight(roads, dest, tmp, history, roads[i][1]);

			else if (roads[i][1] == curr)
				GetWeight(roads, dest, tmp, history, roads[i][0]);
		}
	}
	
	public static void GetRoads(int[][] roads) throws IOException {
		DataInputStream stdin = new DataInputStream(System.in);
		System.out.println("Enter Road Details:");
		for (int i = 0; i < roads.length; i++) {
			String input = stdin.readLine();
			String[] road = input.split(" ");
			for (int j = 0; j < roads[0].length; j++) {
				roads[i][j] = Integer.parseInt(road[j]);
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
		DataInputStream stdin = new DataInputStream(System.in);
		System.out.print("Enter Number of Cities: ");
		int c = Integer.parseInt(stdin.readLine());
		System.out.print("Enter Number of Roads: ");
		int r = Integer.parseInt(stdin.readLine());
		System.out.print("Enter Number of Destinations: ");
		int d = Integer.parseInt(stdin.readLine());
		
		int[][] roads = new int[r][3];
		GetRoads(roads);
		
		System.out.println("Enter Destination Cities:");
		String destination = stdin.readLine();
		
		GetWeight(roads, destination, 0, " ", 1);
		System.out.println(maxweight);
	}
}