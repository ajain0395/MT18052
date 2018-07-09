package assignmnt_linked_list;

import java.util.Scanner;

public class odd_even {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter count of Elements: ");
		int n = sc.nextInt();
		listing obj = new listing();
		for(int i = 0; i < n; i++)
		{
			int val = sc.nextInt();
			if(val % 2 == 0)
			{
				obj.createnodeeve(val);
			}
			else
			{
				obj.createnodeodd(val);
			}
		}
		obj.setlist();
		Node tmp = obj.head;
		
		while(tmp != null)
		{
			System.out.println(tmp.data+ " ");
			tmp = tmp.next;
		}
		
		sc.close();
	}
}