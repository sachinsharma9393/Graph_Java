package graphs;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by user on 6/25/2016.
 */

class Graph_for_Adjacent_List {
	ArrayList<Integer>[] vertices;
	HashSet<Integer>[]hashSets;   //hash sets are implemented for fast checking and
	//constant time finding whether their is edge between 2 vertices
	int size;

	Graph_for_Adjacent_List(int size) {
		this.size = size;
		vertices = new ArrayList[size];
		hashSets=new HashSet[size];
		for (int i = 0; i < size; i++) {
			vertices[i] = new ArrayList<>();
			hashSets[i]=new HashSet<>();
		}
	}

	public void makeEdge(int i, int i1) {
		vertices[i].add(i1);
		hashSets[i].add(i1);

	}

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print("adjacent to " + i + "is ");
			for (int j = 0; j < vertices[i].size(); j++) {
				System.out.print(vertices[i].get(j)+"\t");
			}
			System.out.println();
		}
}
	public Boolean isEdge(int i,int j)
	{

		//hashset for constant time checking of edge btw vertices
		return hashSets[i].contains(j);
	}
}
	public class Graph_Adjacency_List {
		public static void main(String[] args) {
			Graph_for_Adjacent_List g = new Graph_for_Adjacent_List(5);
			for (int i = 0; i < 4; i++) {
				g.makeEdge(i, i + 1);
			}//g.makeEdge(2,5);
			g.makeEdge(0,4);
			g.makeEdge(2,4);
			g.print();
			System.out.println(g.isEdge(4, 1));
			System.out.println(g.isEdge(2, 4));

		}
	}

/*
class Graph_for_Adjacent_List
{
	int size;
	Vector<ArrayList<Integer>>vector;
	Graph_for_Adjacent_List(int size )
	{
		this.size=size;
		vector= new Vector<ArrayList<Integer>>(size);

	}

	public void makeEdge(int i, int i1) {
		if(vector.elementAt(i).size()==0){
			ArrayList<Integer> adjacent= new ArrayList<Integer>(size);//setting max list ,,if it comes less than Trim
			// to size function can be applied
			adjacent.add(i1);vector.add(i,adjacent);
		}
		else vector.elementAt(i).add(i1);
	}

	public void print() {
		for (int i = 0; i <size ; i++) {
			for (int j = 0; j <vector.elementAt(i).size() ; j++) {
				System.out.println("adjacent to " + i + "is " + vector.elementAt(i).listIterator());
			}
		}
	}
}*/
