package stack_permutation;

import java.util.EmptyStackException;

public class Stackimplementation<E> implements Stack<E> {
	static int MAX = 1024;
	int stk[];
	public Stackimplementation() {
		stk = new int[1024];
	}
	int top = -1;
	@Override
	public int size() {
		return top + 1;
	}

	@Override
	public boolean isEmpty() {
		if(top == -1)
			return true;
		return false;
	}

	@Override
	public int top() throws EmptyStackException {
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		// TODO Auto-generated method stub
		return stk[top];
	}

	@Override
	public void push(int element) {
		// TODO Auto-generated method stub
		if(size() == MAX-1)
		{
			System.out.println("Stack Full");
			return ;
		}
		else
		{
			top = top + 1;
			stk[top] = element;
		}
	}

	@Override
	public int pop() throws EmptyStackException {
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		return stk[top--];
	}

}
