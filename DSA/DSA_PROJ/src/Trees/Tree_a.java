package Trees;

public class Tree_a {
	
	Tree_a left = null;
	Tree_a right = null;
	int data;
	
	void printinorder()
	{
		if(this.is_left_child())
			left.printinorder();
	//	System.out.println("left child: " + this.is_left_child()+ "right child: " + this.is_right_child());
		System.out.print(data);
		if(this.is_right_child())
		{
			right.printinorder();
		}
	}
	void printpreorder()
	{
		System.out.print(data);
		if(this.is_left_child())
			left.printpreorder();
	//	System.out.println("left child: " + this.is_left_child()+ "right child: " + this.is_right_child());
		
		if(this.is_right_child())
		{
			right.printpreorder();
		}
	
	}
	Tree_a createtree(int arr[], int left, int right, Tree_a root)
	{
		int mid = (left + right) / 2;
		if(left <= right)
		{
			
			root = new Tree_a(arr[mid]);
			root.set_left_child(root.createtree(arr, left, mid - 1, root.left ));
			root.set_right_child(root.createtree(arr, mid + 1, right, root.right ));
		}
		return root;
	}
	Tree_a(int data)
	{
		this.data = data;
	}
	void set_data(int data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
	int get_data()
	{
		return data;
	}
	boolean is_right_child()
	{
		if(right == null)
		{
			return false;
		}
		return true;
	}
	boolean is_left_child()
	{
		if(left == null)
		{
			return false;
		}
		return true;
	}
	void set_left_child(Tree_a obj)
	{
		this.left = obj;
	}
	void set_right_child(Tree_a obj)
	{
		this.right = obj;
	}

}
