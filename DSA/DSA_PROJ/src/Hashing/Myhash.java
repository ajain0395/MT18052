package Hashing;

//import java.io.BufferedReader;
import java.io.File;
//import java.io.FileReader;
//import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class Myhash{

	public static int prime = 251;//assuming max length of each word is 10
	int freq;
	String word;
	Myhash next;
	static int partition(Myhash arr[], int low, int high) // Quick Sort Partitioning
    {
        Myhash pivot = arr[high]; 
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arr[j].freq >= pivot.freq)
            {
                i++;
                Myhash temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
    
        Myhash temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }

	static void sort(Myhash arr[], int low, int high)//Quick Sort
    {
        if (low < high)
        {

            int pi = partition(arr, low, high);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
	public Myhash(Myhash obj) {//Copy constructor
		this.freq = obj.freq;
		this.word = obj.word;
		this.next = null;
	}
	public Myhash() {
		this.freq = 0;
		this.next = null;
	}
	void insert(String str) // inserting word to hash table
	{
		if(word == null)
		{
			this.word = new String(str).toLowerCase();
			this.freq = 1;
			this.next = null;
		}
		else if(word.equalsIgnoreCase(str))//checking if word already exist in hash table
		{
			this.freq++;
		}
		else if(this.next != null)//if there is chaining on a particular index then add new element in chain
		{
			this.next.insert(str);
		}
		else
		{
			this.next = new Myhash();
			this.next.insert(str);
		}
	}
	static int get_index(String str)//method to convert word into an appropriate index for hashing 
	{
		int count = 0;
		for(int i = 0; i < str.length();i++)
		{
			if(Character.toLowerCase(str.charAt(i)) >= 'a' && Character.toLowerCase((str.charAt(i))) <='z')
			count = count + (Character.toLowerCase(str.charAt(i)) - 'a');
		}
		return count % prime;
	}

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter filepath/name: ");
		String filename = new String(sc.next());//input filename
		File file = new File(filename);//
		Scanner filereader = null;
		try 
		{
		filereader = new Scanner(file);//file reader scanner object
		int cou = 0;
		List<String> s = new ArrayList<String>();
		String temp;
		filereader.useDelimiter("\\s\\s*|\\\n\\s*|\\.\\s*|\\,\\s*|\\;\\s*|\\(\\s*|\\)\\s*|\\!\\s*|\\:\\s*|\\?\\s*"); //delimeters to read words from file
		while(filereader.hasNext())//reading while end of file
		{
			temp = filereader.next();
			if(temp.contains("-"))
			{
				temp = temp.replaceAll("-", "");//concatenating words divided via -
			}
			s.add(temp); // adding words to list of string
			cou++;
		}
		
		
		Myhash hash[] = new Myhash[prime];
		Myhash arrayhash[] = new Myhash[cou];
		
		int count = 0; // count of elements with frequency more than k
		for(int i = 0; i < cou; i ++) // iterating over list of words
		{
		
//			System.out.print(s.get(i) + " ");
			int index = get_index(s.get(i)); // fetching index according to word
			if(hash[index] == null)//checking if it is the first element in hash table
			{
				hash[index] = new Myhash();
				hash[index].insert(s.get(i));
			}
			else
			{
			//	System.out.println("here");
				hash[index].insert(s.get(i));
			}
		}
		System.out.print("Enter Threshold: ");
		
		int k = sc.nextInt();
		for(int i = 0; i < prime; i ++) // creating new list from hash with words freq more than k
		{
				Myhash tmp = hash[i];
				while(tmp != null) // iterating over chain if multiple words at same index
				{
		//			System.out.println("i: [" + i + "] word: [" + tmp.word + "] Freq: " + tmp.freq); // debugging comment
					if(tmp.freq > k)
					{
						arrayhash[count] = new Myhash(tmp);
						count++;
					}
					tmp = tmp.next;
				}
		}
		sort(arrayhash, 0, count - 1); // sorting words with frequency more than k
		//Arrays.sort(arrayhash);
		for(int i = 0; i < count; i++)//printing output
		{
			System.out.println(arrayhash[i].word + " : " + arrayhash[i].freq);
		}
		filereader.close();
		}
		catch(Exception e)//file not found exception handling
		{
			System.out.println("File not found");
		}
		sc.close();
		
		
	}
}
