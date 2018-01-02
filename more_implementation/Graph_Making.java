package graphs;

import java.util.Vector;

/**
 * Created by user on 6/24/2016.
 */
class Vertices
{
	int data;
	Boolean edge;
	/*void initialiseVertice_Array(int data,Boolean edge)
	{
		this.data=data;
		this.edge=edge;
	}*/
}
class Graph
{
	Vector<Vector<Vertices>>double_vector;
	Graph(int size)
	{
		double_vector=new Vector<Vector<Vertices>>(size);
		for (int i = 0; i <size ; i++) {
			Vector<Vertices>vertices=new Vector<Vertices>(size);
			for (int j = 0; j < size; j++) {
				//vertices.elementAt(j).initialiseVertice_Array(j,false);
				vertices.elementAt(j).data=j;
				vertices.elementAt(j).edge=false;
			}

			double_vector.add(i,vertices);
			System.out.println(double_vector.elementAt(i).elementAt(i).edge);
		}
		System.out.println(double_vector.size());
		System.out.println(double_vector.elementAt(1).size());



	}



	public void makeEdge(int i,int j) {
		double_vector.elementAt(i).elementAt(j).edge=false;
	}

	/*public void print() {
		for (int i = 0; i <10 ; i++) {
			for (int j = 0; j <10 ; j++) {
				System.out.print(double_vecror.elementAt(i).elementAt(j).edge+"\t\t");
			}
			System.out.println();
		}
	}*/
}
 class Graph_Making1 {
	public static void main(String[] args) {
		Graph a=new Graph(10);
		/*for (int i = 1; i <10; i++) {
			a.makeEdge(i,i+1);
		}*/
			//a.print();

	}
}
