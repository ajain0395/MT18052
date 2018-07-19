//Ashish Jain MT18052
package iiitd.threading;

public class ThreadClass2 extends Thread {

	Log log = null;
	String []data = null;
	
	public ThreadClass2(Log log, String []data, String name) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.log = log;
		this.setName(name);
		//Thread.currentThread().setName(name);
	}
	public void run()
	{
		log.writeFamilyInfo(data[0], data[4], data[5], data[3]);
		synchronized(log)
		{
		log.printCompleteInfo(Thread.currentThread().getName());
		}
	}
	

}
