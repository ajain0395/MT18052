package Trees;

import java.util.Scanner;

public class Treea {
	
	Treea left = null;
	Treea right = null;
	String data = null;
	static int posthigh = 0,
			prelow = 0;
	public Treea(String val) {
		// TODO Auto-generated constructor stub
	this.data = new String(val);
	}
	static void printpostorder(Treea root)
	{
		if(root == null)
		{
			return;
		}
		
		printpostorder(root.left);
		printpostorder(root.right);
		System.out.print(root.data + " ");
	}

	static void printpreorder(Treea root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.data + " ");
		printpreorder(root.left);
	
		printpreorder(root.right);
		
	}
	
	static void printinorder(Treea root)
	{
		if(root == null)
		{
			return;
		}
		printinorder(root.left);
		System.out.print(root.data + " ");
		printinorder(root.right);
		
	}
	static Treea Preorder(String []in,String []pre, int low, int high)
	{
		if(low > high)
		{
			return null;
		}
		int index = 0;
		Treea root = new Treea(pre[prelow]);
		prelow++;
		for(int i = low; i <= high; i++)
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

	static Treea Postorder(String []in,String []post, int low, int high)
	{
		if(low > high)
		{
			return null;
		}
		int index = 0;
		Treea root = new Treea(post[posthigh]);
		posthigh--;
		for(int i = low; i <= high; i++)
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
		String in = new String(sc.nextLine());
		String inorder[] = in.split(" ");
		String order = null;
		Treea root = null;
		System.out.print("Enter Choice:-\n1. To Insert Preorder\n2. To Insert Postorder\n: ");
		switch(Integer.parseInt(sc.nextLine()))
		{
		case 1:
		{
			System.out.print("Enter Preorder: ");
			order = new String(sc.nextLine());
			String pre[] = order.split(" ");
			prelow = 0;
			root = Preorder(inorder, pre, 0, pre.length - 1);
			System.out.print("Preorder: ");printpreorder(root);
			System.out.println();
			System.out.print("Inorder: ");printinorder(root);
			System.out.println();
			System.out.print("Postorder: ");printpostorder(root);
			System.out.println();		
			break;
		}
		case 2:
		{
			System.out.print("Enter Postorder: ");
			order = new String(sc.nextLine());
			String post[] = order.split(" ");
			posthigh = post.length - 1;
			root = Postorder(inorder, post, 0, post.length - 1);
			System.out.print("Preorder: ");printpreorder(root);
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
		}
		}
		
		  int h = height(root);
	        int i;
	        for (i=1; i<=h; i++)
	        {
	        	printGivenLevel(root, i);
	        	System.out.println();
	        }
		
		sc.close();
	}
	 static int height(Treea root)
	    {
	        if (root == null)
	           return 0;
	        else
	        {
	            /* compute  height of each subtree */
	            int lheight = height(root.left);
	            int rheight = height(root.right);
	             
	            /* use the larger one */
	            if (lheight > rheight)
	                return(lheight+1);
	            else return(rheight+1); 
	        }
	    }
	  void printLevelOrder()
	    {
	      
	    }
	 static void printGivenLevel (Treea root ,int level)
	    {
	        if (root == null)
	            return;
	        if (level == 1)
	            System.out.print(root.data + " ");
	        else if (level > 1)
	        {
	            printGivenLevel(root.left, level-1);
	            printGivenLevel(root.right, level-1);
	        }
	    }
}
