import java.util.*;
import javafx.util.Pair;
/**
 * Created by sachin on 12/14/2017.
 */
class Nodes
{
    char name;
    int cost;//needed for cost based questions
    Vector<Nodes> adjacent= new Vector<>();
    //int more=0;//initially more=0 , when more=1 first traversed,,if no more adjacent then more=2
    Nodes(char name)
    {
        this.name=name;
    }
    Nodes(char name,int cost)
    {
        this.name=name;
        this.cost=cost;
    }
}

public class Sample_Graph {
int size;
    Vector<Nodes> vertices;
    Sample_Graph(int size)
    {
        this.size=size;
        vertices = new Vector<>(size);
        for (int i = 0; i <size ; i++) {
            vertices.add(i,new Nodes((char) (65+i)));
        }
    }
    public void addEdge(int i, int j) {
        vertices.get(i-1).adjacent.add(new Nodes((char) (65+j-1)));
    }
    public void addEdge(int main, int adjacent, int cost) {//edges with weight
        vertices.get(main-1).adjacent.add(new Nodes((char) (65+adjacent-1),cost));

    }

    public void print_Graph() {
        for (int i = 0; i <size ; i++) {
            System.out.print("Vertice is " + vertices.get(i).name+" its adjacent are ");
            for (int j = 0; j < vertices.get(i).adjacent.size() ; j++) {
                System.out.print(vertices.get(i).adjacent.get(j).name);
            }
            System.out.println();
        }
    }

    public void dfs() {//considering no cycles
Stack<Nodes> store=new Stack<>();
        //putting first stat element in the stack
        HashSet<Character>values= new HashSet<>();//used for avoiding duplicacy of character on stack
        HashSet<Character>print=new HashSet<>();
        store.push(vertices.get(0));
        while(!store.empty())
        {
            Nodes dfs=store.pop();
            if (!print.contains(dfs.name))
            print.add(dfs.name);
            else {

                System.out.println("loop_cycle_detected");

            }
            System.out.println(dfs.name);

            Nodes traverse=vertices.get((int)dfs.name -65);
            for (int i = 0; i <traverse.adjacent.size() ; i++) {
                if(!values.contains(traverse.adjacent.get(i).name))//unvisited
                {store.push(traverse.adjacent.get(i));
                values.add(traverse.adjacent.get(i).name);
                }
            }


        }

    }



    public void topologySort_indegree_kahnsmethod() {
        LinkedHashMap<Character,Integer>indegree=new LinkedHashMap<>();
        for (int i = 0; i <size ; i++) {
            indegree.put(vertices.get(i).name,0);
        }
        for (int i = 0; i <vertices.size() ; i++) {
            for (int j = 0; j <vertices.get(i).adjacent.size() ; j++) {
                Character c=vertices.get(i).adjacent.get(j).name;
                if(indegree.containsKey(c))
                {
                    indegree.put(c,indegree.get(c)+1);
                }
            }
        }
       // indegree.values().forEach(System.out::println);
        
        Queue<Character>temp=new ArrayDeque<>();
        for (int i = 0; i <size ; i++) {
            Character n=vertices.get(i).name;
            if(indegree.get(n)==0)
            {
                temp.add(n);
            }
        }
        System.out.println(temp.size());
        while (!temp.isEmpty())
        {
            Character c=temp.poll();
            System.out.println(c);
            Nodes traverse=vertices.get((int)c -65);
            for (int i = 0; i <traverse.adjacent.size() ; i++) {
                Character t=traverse.adjacent.get(i).name;
                int val=indegree.get(t);
                indegree.replace(t,val,val-1);
                if(indegree.get(t)==0)
                    temp.add(t);
            }
        }
    }

    public boolean hasCycle() {
        //dfs with 1 condition of checking whether forward traversal leads to the same node visited
        Stack<Nodes> store=new Stack<>();
        //putting first stat element in the stack
        HashSet<Character>values= new HashSet<>();//used for avoiding duplicacy of character on stack
        HashSet<Character>print=new HashSet<>();
        store.push(vertices.get(0));
        while(!store.empty())
        {
            Nodes dfs=store.pop();
            if (!print.contains(dfs.name))
                print.add(dfs.name);
            else {

                System.out.println("loop_cycle_detected");
                return true;

            }
           // System.out.println(dfs.name);

            Nodes traverse=vertices.get((int)dfs.name -65);
            for (int i = 0; i <traverse.adjacent.size() ; i++) {
                if(!values.contains(traverse.adjacent.get(i).name))//unvisited
                {store.push(traverse.adjacent.get(i));
                    values.add(traverse.adjacent.get(i).name);
                }
            }


        }


        return false;
    }


    public void dijkshtra_short_path() {

        //initially put start vertex in queue
        ArrayList<Character> d=new ArrayList<Character>();
        LinkedHashMap<Character,Integer>map=new LinkedHashMap<>();
        //initilaize with high value
        map.put('A',0);
        for (int i = 1; i <size ; i++) {
            map.put((char) ( 65+i),Integer.MAX_VALUE);
        }
        d.add(vertices.get(0).name);
        while (!d.isEmpty())
        {
            Character c=d.remove(0);
            Nodes n=vertices.get((int)c-65);
            for (int i = 0; i <n.adjacent.size() ; i++) {
                Character x=n.adjacent.get(i).name;
                d.add(x);
                int weight=n.adjacent.get(i).cost;
                int new_distance=map.get(c)+weight;
                if(new_distance < map.get(x))
                {
                    map.replace(x,new_distance);
                }
            }
        }
        for (Character k:map.keySet()
             ) {
            System.out.println(k+"\t"+map.get(k));
        }
    }


    public void find_MST() {
        //here we need tree so we need to know pointer to parent for traversing other than map
ArrayList<Character>tree=new ArrayList<>();//make tree nodes=verices of graph
        for (int i = 0; i < size; i++) {
            tree.add((char) ('A'+i));
        }
ArrayList<Character>d=new ArrayList<>();

        LinkedHashMap<Character,Pair<Integer,Character>>map=new LinkedHashMap<>();
                //here pair represents distance and parent to node
        //put first node in arralist acting as queue
       d.add(vertices.get(0).name);
        map.put('A',new Pair<>(0,tree.get(0)));
        for (int i = 1; i < size; i++) {
            map.put((char) ('A'+i),new Pair<>(Integer.MAX_VALUE,null));
        }
        while (!d.isEmpty())
        {
         Character c=d.remove(0);
            Nodes n=vertices.get((int)c-65);
            for (int i = 0; i <n.adjacent.size() ; i++) {
                Character x=n.adjacent.get(i).name;
                d.add(x);
                int weight=n.adjacent.get(i).cost;
                int new_distance=map.get(c).getKey() +weight;
                if(new_distance<map.get(x).getKey())
                {
                    map.replace(x,new Pair<>(new_distance,vertices.get((int)c-65).name));
                }
            }
        }
        System.out.println("representing vertices,cost from that single source to a vertex , parent to that node");
        for (Character k:map.keySet()
                ) {
            System.out.println(k+"\t"+map.get(k).getKey()+"\t"+map.get(k).getValue());
        }

        //printing spanning tree edges
        System.out.println("edges of graph in  min spanning tree");
        for (int i = 1; i <size ; i++) {
            System.out.println(map.get(vertices.get(i).name).getValue() + "---" +  vertices.get(i).name);
        }


    }

    public void all_pair_short_path() {
       int all_shortest_path[][]=new int[size][size];
        for (int i = 0; i <size ; i++) {
            //initially put start vertex in queue
            ArrayList<Character> d=new ArrayList<Character>();
            LinkedHashMap<Character,Integer>map=new LinkedHashMap<>();
            //initilaize with high value

            for (int j = 0; j <size ; j++) {
                map.put((char) ( 65+j),Integer.MAX_VALUE);
            }
            map.replace((char) (65+i),Integer.MAX_VALUE,0);
            d.add(vertices.get(i).name);
            while (!d.isEmpty())
            {
                Character c=d.remove(0);
                Nodes n=vertices.get((int)c-65);
                for (int j = 0; j <n.adjacent.size() ; j++) {
                    Character x=n.adjacent.get(j).name;
                    d.add(x);
                    int weight=n.adjacent.get(j).cost;
                    int new_distance=map.get(c)+weight;
                    if(new_distance < map.get(x))
                    {
                        map.replace(x,new_distance);
                    }
                }
            }
            for (Character k:map.keySet()
                    ) {
                System.out.println(k+"\t"+map.get(k));

            }
            for (int j = 0; j <size ; j++) {
                all_shortest_path[i][j]=map.get((char)(j+65));
            }
        }
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j <size ; j++) {
                System.out.print(all_shortest_path[i][j]+"\t\t");
            }
            System.out.println();
        }
    }
}


