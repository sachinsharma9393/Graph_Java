package graphs;

/**
 * Created by user on 6/25/2016.
 */

 class Graph_Adj
{
	int size;
	Boolean a[][];//if int take 0 for no edge ,1for edge
	Graph_Adj(int size)
	{
		this.size=size;
		a= new Boolean[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j <size ; j++) {
				a[i][j]=false;
			}
		}


	}

	public void makeEdge(int i, int i1) {
		a[i][i1]=true;
		a[i1][i]=true;
	}

	public void print() {
		for (int i = 0; i <size ; i++) {
			for (int j = 0; j <size ; j++) {
				System.out.print(a[i][j]+"\t\t");
			}
			System.out.println();
		}
	}
}
public class Graph_AdjacencyMatrix {
	public static void main(String[] args) {
		Graph_Adj graph_adj=new Graph_Adj(5);
		for (int i = 0; i <4; i++) {
			graph_adj.makeEdge(i,i+1);
		}
		graph_adj.print();
	}
}

