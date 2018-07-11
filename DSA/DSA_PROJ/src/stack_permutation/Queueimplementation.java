package stack_permutation;

public class Queueimplementation<E> implements Queue<E> {
	static int MAX = 1024;
	int front = -1;
	int rear = -1;
	int Que[] = new int[MAX];
	
	public int size() 
	{
		if(rear < front)
		{
			return (MAX-front) + rear;
		}
			return rear-front;
	}

	@Override
	public boolean isEmpty() {
		if(front == -1 && rear == -1)
			return true;
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int front() throws EmptyQueueException {
		if (isEmpty())
		{
			throw new EmptyQueueException("Queue does not contain any element");
		}
		
		return Que[front];
	}

	@Override
	public void enqueue(int element) {
		// TODO Auto-generated method stub
		if(size() == MAX - 1)
		{
			System.out.println("Queue is Full");
		}
		else
		{
			
			if(front == rear && front == -1)
			{
				front = front + 1;
			}
			rear = (rear + 1) % MAX; 
			Que[rear] = element;
		}
	}

	@Override
	public int dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			throw new EmptyQueueException("Queue is Empty");
		}
		int val = Que[front];
		front = (front + 1 ) % MAX;
		if(front == (rear + 1) % MAX)
		{
			front = -1;
			rear = -1;
		}
		return val;
	}

}