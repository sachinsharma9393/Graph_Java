package trees.TREE_1ST_LIST_LIKE_IMPLEMENTAION;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by user on 7/15/2016.
 */
class Tree
{
	int data;
	Tree left;
	Tree right;
	Tree(int data)
	{
		this.data=data;
		left=null;
		right=null;
	}
	/*public Tree getLeft()
	{
		return this.left;
	}
	public Tree getRight()
	{
	return this.right;	
	}*/
}
class Tree_From_User
{
	int size;
	Vector<Tree>array[];
	int loop;
	Tree_From_User(int size)
	{
		this.size=size;
		loop= (int) Math.ceil(Math.log(size)/Math.log(2)) ;
		System.out.println(loop);
		array=new Vector[loop];
		for (int i = 0; i <loop ; i++) {
			array[i]=new Vector();
		}
		array[0].add(new Tree(1));
		int how_much_to_fill=1;//first element already added
		outer:for (int i = 1; i <loop ; i++) {
			for (int j = 0; j <Math.pow(2,i) ; j++) {
				if(how_much_to_fill==size)
				{
					break outer;
				}
				else
				{
					++how_much_to_fill;
					array[i].add(new Tree(how_much_to_fill));//Node adding
				}
			}


		}
		link();//here link() function can be called so as to link all the left and right pointers
	}
	//this variable is incremented twice in a loop 1 for left and 1 for right...bcoz elements
	//left and right refernce should only be linked till number of nodes....
	public void link() {
		int till_where_to_link=1;
		outer:for (int i = 0; i <loop-1 ; i++) {
			for (int j = 0; j <array[i].size() ; j++) {
				if(till_where_to_link==size)
				{
					break outer;
				}
				else {
					array[i].elementAt(j).left = array[i + 1].elementAt(2 * j);
					++till_where_to_link;
					if(till_where_to_link==size)
					{
						break outer;
					}
					else {
						array[i].elementAt(j).right = array[i + 1].elementAt(2 * j + 1);
						++till_where_to_link;
					}
				}

			}
		}
	}
	void printTree()  //just for checking
	{
		for (int i = 0; i <loop ; i++) {
			System.out.print("TREE NODES AT "+i+" index:\t\t" );
			for (int j = 0; j <array[i].size() ; j++) {
				System.out.print(array[i].elementAt(j).data+"\t\t");
			}
			System.out.println();
		}
	}


	public void printThroughLink() {
		int complete_print_counter=1;
		System.out.println("root is --->>"+array[0].elementAt(0).data);
	outer:	for (int i = 0; i <loop-1 ; i++) {
			for (int j = 0; j <array[i].size() ; j++) {
				//System.out.println(array[i].elementAt(j).data);
				if(complete_print_counter==size)
				{
					break outer;
				}
				else {

					System.out.print(array[i].elementAt(j).left.data+"\t\t");
					if (complete_print_counter==size)
					{

						System.out.print(array[i].elementAt(j).right.data);
						++complete_print_counter;
					}
				}


			}
		}

	}
}
public class Tree_List {
	public static void main(String[] args) throws IOException {

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		System.out.println("ENTER NUMBER OF NODES YOU WANT IN A TREE");
		int size= Integer.parseInt(br.readLine());
		Tree_From_User j=new Tree_From_User(size);
		j.printTree(); //just for retrieving
		//j.link();//linking of left and right pointers
		j.printThroughLink();//printing elements through linking left and right pointers;
	}
}
