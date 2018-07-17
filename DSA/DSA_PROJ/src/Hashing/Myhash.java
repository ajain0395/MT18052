package Hashing;

//import java.util.Arrays;
import java.util.Scanner;

public class Myhash implements Comparable<Myhash> {

	public static int prime = 251;//assuming max length of each word is 10
	int freq;
	String word;
	Myhash next;
	static int partition(Myhash arr[], int low, int high)
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

	static void sort(Myhash arr[], int low, int high)
    {
        if (low < high)
        {

            int pi = partition(arr, low, high);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
	@Override
	public int compareTo(Myhash arg0) {
		
		return this.freq - arg0.freq;
	}
	public Myhash(Myhash obj) {
		this.freq = obj.freq;
		this.word = obj.word;
		this.next = null;
	}
	public Myhash() {
		this.freq = 0;
		this.next = null;
	}
	void insert(String str)
	{
		if(word == null)
		{
			this.word = new String(str).toLowerCase();
			this.freq = 1;
			this.next = null;
		}
		else if(word.equalsIgnoreCase(str))
		{
			this.freq++;
		}
		else if(this.next != null)
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
	boolean isinlist(String str)
	{
	
//		if()
		return false;
	}
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int m = 11;
		String []s = new String[m];
		s[0] = new String("The");
		s[1] = new String("Thfe");
		s[2] = new String("Thfe");
		s[3] = new String("Thfe");
		s[4] = new String("The");
		s[5] = new String("This");
		s[6] = new String("Th");
		s[7] = new String("Th");
		s[8] = new String("Th");
		s[9] = new String("Th");
		s[10] = new String("Thjr");
		System.out.print("Enter Threshold: ");
		int k = sc.nextInt();
		
		Myhash hash[] = new Myhash[prime];
		Myhash arrayhash[] = new Myhash[m];
		int count = 0; // count of elements with frequency more than k
		for(int i = 0; i < m; i ++) // iterating over list of words
		{
			int index = get_index(s[i]); // fetching index according to word
			if(hash[index] == null)//checking if it is the first element in hash table
			{
				hash[index] = new Myhash();
				hash[index].insert(s[i]);
			}
			else
			{
			//	System.out.println("here");
				hash[index].insert(s[i]);
			}
		}
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
		sc.close();
	}
}
