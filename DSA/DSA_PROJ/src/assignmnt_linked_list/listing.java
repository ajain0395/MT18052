package assignmnt_linked_list;

public class listing {
	
	Node headodd = null;
	Node head = null;
	Node headeven = null;
	void setlist()
	{
		if(headeven != null && headodd != null)
		{
			head =headeven;
			while(headeven.getnext()!=null)
			{
				headeven = headeven.next;
			}
			headeven.setnext(headodd);
		}
		else if(headodd == null)
		{
			head = headeven;
		}
		else
		{
			head = headodd;
		}
		
	}
	void createnodeeve(int val)
	{
		Node p = new Node(val);
		
		if(headeven == null)
		{
			headeven = p;
		}
		else
		{
			Node tmp = headeven;
			while(tmp.getnext() != null)
			{
				tmp = tmp.getnext();
			}
			
			tmp.setnext(p);
		}
		}
	void createnodeodd(int val)
	{
		Node p = new Node(val);
		
		if(headodd == null)
		{
			headodd = p;
		}
		else
		{
			Node tmp = headodd;
			while(tmp.getnext() != null)
			{
				tmp = tmp.getnext();
			}
			
			tmp.setnext(p);
		}
	
	}
}
