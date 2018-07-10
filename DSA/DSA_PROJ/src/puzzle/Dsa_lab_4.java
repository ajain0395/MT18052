package puzzle;

import java.util.Scanner;

public class Dsa_lab_4 {

	public static void main(String []args)
	{
		int n, k;
		int val,sum = 0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		int count[] = new int[k];
		for(int i = 0; i < n; i++)
		{
			val = sc.nextInt();
			sum = sum + val;
			count[val%k]++;
		}
		int j = k-1;
		boolean flag = true;
		if (count[0]%2 != 0)
		{
			flag = false;
		}
		for(int i = 1; i < j;i++,j--)
		{
			if(flag == true)
			{
				if(count[i] != count[j])
				{
					flag = false;
				}
			}
			else
			{
				break;
			}
			
		}
		if(k%2 == 0 && count[k/2] % 2 != 0)
		{
			flag = false;
		}
		if(flag == true && sum % k == 0 && sum/k >= n/2)
		{
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}
		sc.close();
		
	}
}