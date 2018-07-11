package stack_permutation;

@SuppressWarnings("serial")
public class EmptyQueueException extends Exception {
	
	public EmptyQueueException()
	{
		System.out.println("EmptyQueueException");
	}
	public EmptyQueueException(String S)
	{
		System.out.println("EmptyQueueException" + S);
	}
}
