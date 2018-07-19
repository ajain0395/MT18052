//Ashish Jain MT18052
package iiitd.threading;

public class ThreadClass1 extends Thread {

	Log log = null;
	String []data = null;
	
	public ThreadClass1(Log log, String []data, String name) {
		// TODO Auto-generated constructor stub
//		log.writePersonalInfo(data[0], Integer.parseInt(data[1]), data[2], data[3]);
		this.data = data;
		this.log = log;
		this.setName(name);
		//Thread.currentThread().setName(name);
	}
	public void run()
	{
		log.writePersonalInfo(data[0], Integer.parseInt(data[1]), data[2], data[3]);
	
		synchronized(log)
		{
			
		log.printCompleteInfo(Thread.currentThread().getName());
		}
	}

}
