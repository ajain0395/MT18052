/*
 * Ashish Jain
 * MT18052
 */


package dsaexam;
import java.util.ArrayList;
import java.util.Scanner;
public class Tree_Main {

		
		Tree_Main left = null;
		Tree_Main right = null;
		int data;
		/*
		 * Tree ADT members
		 */
		
		
		static ArrayList<Integer> list = new ArrayList<>();//for storing inorder traversal of tree
		static int last_min;//saving last element traversed in tree
		static boolean flag = true; 
		static int posthigh = 0;//post order string higher index
		public Tree_Main(int val)//constructor to initialize node value
		{ 
			this.data = val;
		}
			
		static void printinorder(Tree_Main root)//print and store inorder traversal of tree
		{
			if(root == null)
			{
				return;
			}
			printinorder(root.left);
			list.add(root.data);
			System.out.print(root.data + " ");
			printinorder(root.right);
			
		}
			static Tree_Main Postorder(String[] inorder,String[] post, int low, int high)//construction of tree
		{
			if(low > high)
			{
				return null;
			}
			int index = 0;
			Tree_Main root = new Tree_Main(Integer.parseInt(post[posthigh]));
			posthigh--;
			for(int i = low; i <= high; i++) //searching for root in inorder to divide the tree
			{
				if(Integer.parseInt(inorder[i]) == (root.data))
				{
					index = i;
					break;
				}
			}
			root.right = Postorder(inorder, post, index + 1, high);
			root.left = Postorder(inorder, post, low, index - 1);
			
			return root;
		}

		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			
			Tree_Main root = null;
			String order = null;
			
			System.out.print("Enter Postorder: ");
			order = new String(sc.nextLine());//input postorder traversal of tree
			String post[] = order.split(" ");//split and save in array
			posthigh = post.length - 1;
			System.out.print("Enter Inorder: ");//input inorder traversal of tree
			String in = new String(sc.nextLine());
			String inorder[] = in.split(" ");

				root = Postorder(inorder, post, 0, post.length - 1);
				
				System.out.print("Inorder: ");
				
				printinorder(root);//print inorder traversal of tree
				System.out.println();
				
				System.out.print("Preorder: ");
				printpreorder(root);//print preorder traversal of tree
				
				System.out.println();
				validate_tree(root);//validate tree function
				if(flag)
				{
					System.out.println("Valid Binary Tree");
				}
			sc.close();
		}
		private static void printpreorder(Tree_Main root) { // print preorder tree traversal
			if(root == null)
			{
				return;
			}
			System.out.print(root.data + " ");
			printpreorder(root.left);
			printpreorder(root.right);
			
		
		}
		public static void validate_tree(Tree_Main root)//checking if inorder traversal is sorted or not 
		{
			last_min = -1;
		for(int i = 0; i < list.size(); i++)
		{
			if(last_min > list.get(i))
			{
				System.out.println("Not a binary search tree");
			System.out.println("Violate at " + list.get(i));
			flag = false;
				return;
			}
			last_min = list.get(i);
		}
		}
}
