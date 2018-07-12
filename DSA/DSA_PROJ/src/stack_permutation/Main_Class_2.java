package stack_permutation;

import java.util.Scanner;

public class Main_Class_2 {

	public static void main(String[] args) throws EmptyQueueException {
		// TODO Auto-generated method stub
		Stackimplementation<Integer> S = new Stackimplementation<>();
		Queueimplementation<Integer> Q1 = new Queueimplementation<>();
		Queueimplementation<Integer> Q2 = new Queueimplementation<>();
		Queueimplementation<Integer> stackperm = new Queueimplementation<>();
		boolean flag = true;
		boolean found = false;
		int tmp = 0;
		//int tmp2 = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter N: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			Q1.enqueue(i + 1);
		}
		for (int i = 0; i < n; i++) {
			stackperm.enqueue(sc.nextInt());
		}
		while (!stackperm.isEmpty()) {
			found = false;
	//		System.out.println("ashish_1 " + stackperm.front());
			while ((!Q1.isEmpty() && !found)||(!S.isEmpty() && !found)) 
			{
				if (!Q1.isEmpty() && Q1.front() == stackperm.front())
				{
					System.out.println("enqueue(Q2, dequeue(Q1))");
					
						tmp = Q1.dequeue();
						stackperm.dequeue();
					Q2.enqueue(tmp);
					found = true;
					break;
				} 
				else if (!S.isEmpty() && stackperm.front() == S.top()) 
				{
				
					System.out.println("enqueue(Q2, pop(S))");
						
						stackperm.dequeue();
					Q2.enqueue(S.pop());
					found = true;
					break;
				} 
				else if(!S.isEmpty() && Q1.isEmpty() && !found)
				{
					System.out.println("Input val ["+stackperm.front() +"] doesnot match with top of stack ["+S.top() +"] and Q1 is Empty");
					flag = false;
					break;
				}
				else
				{
					System.out.println("push(S, dequeue(Q1))");
		//				System.out.println("ashish_2 " + tmp);
					S.push(Q1.dequeue());
				}
			}
			if (!flag)
				break;

		}
		/*
		 * else if(Q1.isEmpty() && i < n - 1 ) { flag = false; break; }
		 */
		if (flag && S.isEmpty())
		{
			System.out.println("Stack Permutation");
		} else {
			System.out.println("Not a Stack Permutation");
		}
		sc.close();
	}
}