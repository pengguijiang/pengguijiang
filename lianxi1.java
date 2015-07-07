package abc;

import java.util.Scanner;
		import java.util.Scanner;

		public class lianxi1 {
		public static void main(String[] args){
			Scanner scanner=new Scanner(System.in);
			int day=scanner.nextInt();
			String monthString="";
			switch(day)
			{
			case 1:monthString="monday";break;
			case 2:monthString="tuesday";break;
			case 3:monthString="wednesday";break;
			case 4:monthString="thursday";break;
			case 5:monthString="sunday";break;
			default:day=0;
			}
			System.out.println(monthString);
			
		}
		

	}


