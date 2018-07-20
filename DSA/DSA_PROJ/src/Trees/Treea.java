package Trees;

import java.util.Scanner;

public class Treea {
	
	Treea left = null;
	Treea right = null;
	String data = null;
	static int posthigh = 0,
			prelow = 0;
	public Treea(String val) {//constructor to initialize object 
		// TODO Auto-generated constructor stub
	this.data = new String(val);
	}
	static void printpostorder(Treea root)//print post order traversal of tree
	{
		if(root == null)
		{
			return;
		}
		
		printpostorder(root.left);
		printpostorder(root.right);
		System.out.print(root.data + " ");
	}

	static void printpreorder(Treea root)//print preorder traversal of tree
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.data + " ");
		printpreorder(root.left);
	
		printpreorder(root.right);
		
	}
	
	static void printinorder(Treea root)//print inorder traversal of tree
	{
		if(root == null)
		{
			return;
		}
		printinorder(root.left);
		System.out.print(root.data + " ");
		printinorder(root.right);
		
	}
	static Treea Preorder(String []in,String []pre, int low, int high)//create tree if preorder and inorder traversal is provided
	{
		if(low > high)
		{
			return null;
		}
		int index = 0;
		Treea root = new Treea(pre[prelow]);
		prelow++;
		for(int i = low; i <= high; i++)//searching for first element from preorder in inorder to split the tree
		{
			if(in[i].equals(root.data))
			{
				index = i;
				break;
			}
		}
		root.left = Preorder(in, pre, low, index - 1);
		root.right = Preorder(in, pre, index + 1, high);
		
		
		return root;
	}

	static Treea Postorder(String []in,String []post, int low, int high)//create tree if postorder and inorder traversal is provided
	{
		if(low > high)
		{
			return null;
		}
		int index = 0;
		Treea root = new Treea(post[posthigh]);
		posthigh--;
		for(int i = low; i <= high; i++)//search last element of postorder in inorder to split tree 
		{
			if(in[i].equals(root.data))
			{
				index = i;
				break;
			}
		}
		root.right = Postorder(in, post, index + 1, high);
		root.left = Postorder(in, post, low, index - 1);
		
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Inorder: ");
		String in = new String(sc.nextLine());//input inorder traversal of tree
		String inorder[] = in.split(" ");// split string 
		String order = null;
		Treea root = null;
		System.out.print("Enter Choice:-\n1. To Insert Preorder\n2. To Insert Postorder\n: ");
		switch(Integer.parseInt(sc.nextLine()))
		{
		case 1://if user wants to enter preorder
		{
			System.out.print("Enter Preorder: ");
			order = new String(sc.nextLine());//input preorder tree
			String pre[] = order.split(" ");
			prelow = 0;
			root = Preorder(inorder, pre, 0, pre.length - 1);//calling method to create tree
			System.out.print("\nPreorder: ");printpreorder(root);
			System.out.println();
			System.out.print("Inorder: ");printinorder(root);
			System.out.println();
			System.out.print("Postorder: ");printpostorder(root);
			System.out.println();		
			break;
		}
		case 2://if user wants to enter postorder
		{
			System.out.print("Enter Postorder: ");
			order = new String(sc.nextLine());//input postorder tree
			String post[] = order.split(" ");
			posthigh = post.length - 1;
			root = Postorder(inorder, post, 0, post.length - 1);//calling method to create tree
			System.out.print("\nPreorder: ");printpreorder(root);
			System.out.println();
			System.out.print("Inorder: ");printinorder(root);
			System.out.println();
			System.out.print("Postorder: ");printpostorder(root);
			System.out.println();
			break;
		}
		default:
		{
			System.out.println("Invalid Choice");
			System.exit(1);
		}
		}
		  int height = height(root); // calculating height of tree
		  System.out.println("\nOutput Tree:");
		  printtree(height, root); // Printing generated tree
		sc.close();
	}
	static void printtree(int currentlevel,Treea root) 
	{
		if(currentlevel < 1)
		{
			return;
		}
		
		printtree(currentlevel - 1, root);
    	currlevelprint( currentlevel,root);//iterating at each level to print nodes of particular level
    	System.out.println();
	}
	 static int height(Treea root)
	    {
	        if (root == null)
	           return 0;
	        else
	        {
	            
	        	int rh = height(root.right);
	            int lh = height(root.left);
	            
	             
	            if (rh < lh)	//comparing depth of left and right side of tree
	                return(lh + 1);
	            else return(rh + 1); 
	        }
	    }
	  
	 static void currlevelprint(int level,Treea root)//print nodes at i level
	    {
	        if (root == null)
	            return;
	        if (level == 1)
	            System.out.print(root.data + " ");
	        else if (level > 1)
	        {
	        	currlevelprint(level-1,root.left);
	        	currlevelprint(level-1,root.right);
	        }
	    }
}
