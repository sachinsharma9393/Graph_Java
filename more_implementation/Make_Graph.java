package graph_latest;

import java.util.*;

/**
 * Created by user on 7/24/2016.
 */
class Vertices
{
	char label;
	boolean visited=false;
	ArrayList<Vertices>edgelist;//edgelist
	Vertices(char label)
	{
		this.label=label;
		edgelist= new ArrayList<>();
	}
}
class Graph
{
	int size;
	Vector<Vertices>node_list;
	Vector<Vertices>bfs_result;
	Vector<Vertices>dfs_result;
	Graph(int size)
	{
		//Make list of vertices
		this.size=size;
		bfs_result=new Vector<>(size);
		dfs_result=new Vector<>(size);
		node_list= new Vector<>(size);
		for (int i = 0; i <size ; i++) {
			node_list.add(new Vertices((char) (65+i)));
		}
	}

	public void makeEdge(char s,char d) {
			int vertex=(int)s-65;
		node_list.elementAt(vertex).edgelist.add(new Vertices(d));
	}

	public void print_Adjacent_Vertice() {
		for (int i = 0; i <size ; i++) {
			System.out.println("ADJACENT TO " +node_list.elementAt(i).label+" are");
			for (int j = 0; j <node_list.elementAt(i).edgelist.size() ; j++) {
				System.out.print(node_list.elementAt(i).edgelist.get(j).label+"\t\t");
			}
			System.out.println();
		}
	}

	public void bfs() {
		//various approaches
		//  1.)queue based approach---put all adjacent in queue then poll each
		//  2.) search based using Hashing
		LinkedList<Vertices>bfs=new LinkedList<>();
		HashSet<Character>check=new HashSet<>(size);
		check.add(node_list.elementAt(0).label);
		bfs_result.add(node_list.elementAt(0));
		bfs.add(node_list.elementAt(0));
	bfs:	while (!bfs.isEmpty())
		{
			Vertices v=node_list.elementAt((int) bfs.removeFirst().label-65);
			for (int i = 0; i < v.edgelist.size(); i++) {//all adjacent vertices to v
				if(bfs_result.size()==size)
				{
					break bfs;
				}
				if(!check.contains(v.edgelist.get(i).label))
				{
					bfs.addLast(v.edgelist.get(i));
					check.add(v.edgelist.get(i).label);
					bfs_result.add(v.edgelist.get(i));
				}
			}
		}
		for (int i = 0; i <bfs_result.size() ; i++) {
			System.out.println(bfs_result.elementAt(i).label);

		}
		//System.out.println(bfs_result.size());
	}


}
public class Make_Graph {
	public static void main(String[] args) {
		Graph g=new Graph(11);
		g.makeEdge('A','B');g.makeEdge('A','C');g.makeEdge('A','D');
		g.makeEdge('B','E');g.makeEdge('C','F');g.makeEdge('D','G');
		g.makeEdge('E','H');g.makeEdge('F','I');g.makeEdge('G','J');
		g.makeEdge('H','K');g.makeEdge('I','K');g.makeEdge('J','K');
		g.print_Adjacent_Vertice();
		System.out.println("-------------SEARCH----------------");
		System.out.println("......BFS.....");
		g.bfs();//performing bfs
		//System.out.println(".....DFS....");
		//g.dfs();
	}
}

/*
* HashSet<Vertices>v=new HashSet<>();
		dfs:for (int i = 0; i <size ; i++) {

			for (int j = 0; j <node_list.elementAt(i).edgelist.size() ; j++) {
				if(v.size()==size)
				{
					break dfs;
				}
				if(!v.contains(node_list.elementAt(i).edgelist.get(j))&&node_list.elementAt(i).edgelist.get(j).visited==false)
				{
					v.add(node_list.elementAt(i).edgelist.get(j));
					node_list.elementAt(i).edgelist.get(j).visited=true;
					node_list.elementAt((int)node_list.elementAt(i).edgelist.get(j).label-65).visited=true;
				}
			}


		}*/