import Map.*;

import java.util.Scanner;

public class InputReader {

	private Scanner scan;
	
	private Reader read;
	
	public InputReader(){
		
		scan = new Scanner(System.in);

		
	}
	
	public void getInput(){


		helloUser();
		
		while(scan.hasNextLine()){
		
			String input = scan.nextLine();
		
			if(input.matches("(?i)List all lines")){

                for(Line line : Map.getInstance().getLineList()) {
                    System.out.println(line);
                }
				
			}else if(input.matches("(?i)List all stations")){

			    for(Station station : Map.getInstance().getStations()) {
			        System.out.println(station);
                }
			}
		}
	}
	
	
	public void helloUser(){
		
		System.out.println("Hello!");
		
		System.out.println("Those are some of the commands u can use to get information:");
		
		System.out.println("List all lines" + "\t" + " List all stations" + "\t" + "Find the fastest way");

	}
	

}