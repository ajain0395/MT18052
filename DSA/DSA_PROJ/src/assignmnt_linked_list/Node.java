package assignmnt_linked_list;

public class Node {
		int data;
		Node next;
		public Node() {
			// TODO Auto-generated constructor stub
			data = 0;
			next = null;
		}
		Node (int val)
		{
			data = val;
		}
		Node getnext()
		{
			return next;
		}
		int getdata()
		{
			return data;
		}
		void setnext(Node obj)
		{
			this.next = obj;
		}
}