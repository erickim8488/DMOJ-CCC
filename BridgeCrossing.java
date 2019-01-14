import java.io.*;

public class BridgeCrossing {
	
	static int time;
	static String[] groups;
	
	public static void GetTime(int[] speed, String[] name, int maxpeople, int index, int currtime, String group) {
		if (index >= speed.length) {
			if (time == 0 || time > currtime) {
				groups = group.split("-");
				time = currtime;
			}
			return;
		}
		
		int addtime = 0;
		String addname = "";
		for (int i = index; i < index+maxpeople && i < speed.length; i++) {
			addname += name[i] + " ";
			if (addtime < speed[i])
				addtime = speed[i];

			GetTime(speed, name, maxpeople, i+1, currtime+addtime, group+addname+"\n");	
		}
	} 
	
	public static void main(String args[]) throws IOException {
		DataInputStream stdin = new DataInputStream(System.in);
		System.out.print("Enter max number of people in a group: ");
		int maxpeople = Integer.parseInt(stdin.readLine());
		System.out.print("Enter the length of the queue line: ");
		int numwait = Integer.parseInt(stdin.readLine());
		
		System.out.println("Enter name, then the person's time to cross the bridge:");
		String[] name = new String[numwait];
		int[] speed = new int[numwait];
		for (int i = 0; i < numwait; i++) {
			name[i] = stdin.readLine();
			speed[i] = Integer.parseInt(stdin.readLine());
		}

		GetTime(speed, name, maxpeople, 0, 0, "");
		System.out.println(time);
		for (int i = 0; i < groups.length; i++) {
			System.out.println(groups[i]);
		}
	}
}