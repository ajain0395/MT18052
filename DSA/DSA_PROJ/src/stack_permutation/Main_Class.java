package stack_permutation;

import java.util.Scanner;

public class Main_Class {

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
					try {
						tmp = Q1.dequeue();
						stackperm.dequeue();
					} catch (Exception e) {
						// System.out.println(e.toString());
						flag = false;
						break;
					}
					Q2.enqueue(tmp);
					found = true;
				} 
				else if (!S.isEmpty() && stackperm.front() == S.top()) {
					System.out.println("enqueue(Q2, pop(S))");
					try
					{
						tmp = S.pop();
						stackperm.dequeue();
					}
					catch (Exception e) 
					{
						System.out.println(e.toString());
						flag = false;
						break;
					}
					Q2.enqueue(tmp);
					found = true;
				} 
				else
				{
					System.out.println("push(S, dequeue(Q1))");
					try 
					{

						tmp = Q1.dequeue();
		//				System.out.println("ashish_2 " + tmp);
					}
					catch (Exception e)
					{
						System.out.println(e.toString());
						flag = false;
						break;
					}
					S.push(tmp);
				}
			}
			if (!flag)
				break;

		}
		/*
		 * else if(Q1.isEmpty() && i < n - 1 ) { flag = false; break; }
		 */
		if (flag)

		{
			System.out.println("Stack Permutation");
		} else {
			System.out.println("Not a Stack Permutation");
		}
		sc.close();
	}
}