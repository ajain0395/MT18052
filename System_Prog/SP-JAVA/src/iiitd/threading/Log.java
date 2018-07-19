//Ashish Jain MT18052
package iiitd.threading;

public class Log{
	
	PersonalInfo pi = new PersonalInfo();
	FamilyInfo fi = new FamilyInfo();
	
	
	public void writePersonalInfo(String name,int age, String gender, String city)
	{
		pi.setName(name);
		pi.setGender(gender);
		pi.setCity(city);
		pi.setAge(age);
	}
	void writeFamilyInfo(String name, String fatherName, String motherName,
			String city)
	{
		fi.setCity(city);
		fi.setFatherName(fatherName);
		fi.setMotherName(motherName);
		fi.setName(name);
	}
	void printCompleteInfo(String threadName)
	{
		System.out.println("================================================");
		System.out.println("Calling thread : " + threadName);
		System.out.println("======================Info======================");
		System.out.println("Personal Info");
		System.out.println("Name: " + pi.getName());
		System.out.println("Age: " + pi.getAge());
		System.out.println("Gender: " + pi.getGender());
		System.out.println("City: " + pi.getCity());
		System.out.println("================================================");
		System.out.println("Family Info");
		System.out.println("Name: " + fi.getName());
		System.out.println("Father Name: " + fi.getFatherName());
		System.out.println("Mother Name: " + fi.getMotherName());
		System.out.println("City: " + fi.getCity());
		System.out.println("================================================");
	}


}
