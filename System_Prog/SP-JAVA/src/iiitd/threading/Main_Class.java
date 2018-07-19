package iiitd.threading;

import java.util.Scanner;

//Ashish Jain MT18052
public class Main_Class{
	
//	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		 String data[] = new String[6];
		
		
		System.out.print("Enter Input String: ");
		String input = sc.nextLine();
		
		Scanner trimmer = new Scanner(input);
		trimmer.useDelimiter("\\,\\s*");
		int datacount = 0;
		while(trimmer.hasNext())
		{
			datacount++;
			
			if(datacount > 6)
			{
				System.out.println("Invalid number of arguments");
				System.exit(1);
			}
			data[datacount - 1] = new String(trimmer.next());//reading input using ',' delimiter
		//	System.out.println(data[datacount - 1]);
		}
		if(datacount < 6)
		{
			System.out.println("Invalid number of arguments");
			System.exit(1);//exit if invalid number of arguments
		}
		
//		log.writePersonalInfo(data[0], Integer.parseInt(data[1]), data[2], data[3]);
//		log.writeFamilyInfo(data[0], data[4], data[5], data[3]);
		//log.printCompleteInfo("Hello");
		Log log = new Log();//creating log class object
		ThreadClass1 thread1 = new ThreadClass1(log, data,"Personal Info");
		thread1.start();
		
		ThreadClass2 thread2 = new ThreadClass2(log, data,"Family Info");
	
		thread2.start();
		
		
//		log.printCompleteInfo("Thread1");
		trimmer.close();
		sc.close();
	}
	
	
	
}
