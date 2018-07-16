package Trees;

import java.util.Scanner;

public class Tree_main {


static boolean flag = false;
static boolean flag2 = false;
static int funval = -1;

static int min_value(Tree_a root)
{
    int min_val = root.data;
    while (root.left != null)
    {
        min_val = root.left.data;
        root = root.left;
    }
    return min_val;
}

static Tree_a del_node(Tree_a root, int val)
{
  
    if (root == null) 
    	return root;

  
    if (val > root.data)
        root.right = del_node(root.right, val);
    else if (val < root.data)
        root.left = del_node(root.left, val);

    else
    {
        // node with only one child or no child
        if (root.left == null)
            return root.right;
        else if (root.right == null)
            return root.left;

        root.data = min_value(root.right);

        root.right = del_node(root.right, root.data);
    }

    return root;
}
static int inordersucc(Tree_a root, int val)
{
	if(root == null)
	{
		return -1;
	}
	else if(root.data == val && root.is_right_child())
	{
		return min_value(root.right);
	}
	else if(val < root.data && root.is_left_child() )
	{
		return inordersucc(root.left, val);
	}
	else if(val > root.data && root.is_right_child())
	{
		return inordersucc(root.right, val);
	}
	return -1;
	
}

static void printinordersucc(Tree_a root,int val)
{
	if(root.is_left_child())
		 printinordersucc(root.left,val);

//	System.out.print(root.data);
	if(flag == true && flag2 == true)
	{
		funval = root.data;
		flag2 = false;
		return;
		//return funval;
	}
	if(root.data == val)
	{
		flag = true;
		flag2 = true;
	}
	if(root.is_right_child())
	{
		printinordersucc(root.right, val);
	}
//	return funval;
}
	static boolean search(Tree_a root, int val)
	{
		if(root == null)
		{
			return false;
		}
		else if(root.data == val)
		{
			return true;
		}
		else if(val < root.data )
		{
			return search(root.left, val);
		}
		else if(val > root.data)
		{
			return search(root.right, val);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n");
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			arr[i] = sc.nextInt();
		}
			Tree_a root = new Tree_a(arr[n/2]);
			root.set_left_child(root.createtree(arr,0 , ((n)/2) - 1, root.left));
			root.set_right_child(root.createtree(arr, ((n/2)) + 1, n - 1, root.right));
		//	System.out.print("inorder: " );
			//root.printinorder();
	//		System.out.println();
		//	root.printpreorder();
			System.out.println("Enter Query Count: ");
			int q = sc.nextInt();
			while(q > 0)
			{
				funval = -1;
				flag = false;
				flag2 = false;
			System.out.print("\nEnter (Choice, val): \n1. Search\n2. Inorder Successor\n3.Delete\n: ");
			
			int ch = sc.nextInt();
			int val = sc.nextInt();
			switch(ch)
			{
			case 1:
				if(search(root,val))
			{
				System.out.println("Element Exist");
			}
			else
			{
				System.out.println("Element does not Exist");
			}
				break;
			case 2:
				printinordersucc(root, val);
				int ret_val = inordersucc(root, val);
				if(funval == -1)
				{
			//		System.out.println();
					System.out.println("Inorder Successor does not Exist");
				}
				else
				{
			//		System.out.println();
					System.out.println("Inorder Successor: " + funval);
				}
				if(ret_val == -1)
				{
						//		System.out.println();
								System.out.println("2 Inorder Successor does not Exist");
					}
							else
							{
						//		System.out.println();
								System.out.println("2 Inorder Successor: " + ret_val);
							}
				
				break;
			case 3:
				root = del_node(root,val);
				break;
				default:
					System.out.println("Invalid Choice");
			}
			q--;
			root.printinorder();
			}
				sc.close();

	}

}
