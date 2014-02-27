package crypt.chat;

import java.util.Scanner;

public class Cli {
	
	public String getStringInput(String whatUWant)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println(whatUWant);
		String answer = scan.nextLine();
		return answer;
	}

}
