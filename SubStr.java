import java.io.*;

public class SubStr{
	
	public static void main(String args[]) throws IOException
	{
		DataInputStream stdin = new DataInputStream(System.in);
		int cases = Integer.parseInt(stdin.readLine());
		String input;
		String history = " ";
		int combo = 0;
		
		for (int a = 0; a < cases; a++)
		{
			input = stdin.readLine();
			for (int b = 0; b < input.length(); b++)
			{
				for (int c = b; c <= input.length(); c++)
				{
					if (history.indexOf(" " + input.substring(b,c) + " ") == -1) //indexOf is for in c++, gives -1 when none are the same;
					{
						combo++;
						history += input.substring(b,c) + " ";
						System.out.println(input.substring(b,c));
					}
				}
			}
			System.out.println("You can make " + combo + " combinations.");
			System.out.println(history);
			history = " ";
			combo = 0;
		}
	}
}