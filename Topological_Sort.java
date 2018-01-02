/**
 * Created by sachin on 12/14/2017.
 */
public class Topological_Sort
{
    public static void main(String[] args) {
        Sample_Graph h=new Sample_Graph(10);
        h.addEdge(5,3);//first is lets say parent
        h.addEdge(1,2);
        h.addEdge(1,3);
        h.addEdge(1,5);
        h.addEdge(2,4);
        h.addEdge(4,3);
        h.addEdge(3,6);
        h.addEdge(6,7);
        h.addEdge(6,8);
        h.addEdge(8,9);
        h.addEdge(7,10);
        h.addEdge(9,10);
        System.out.println(h.hasCycle());
        //h.print_Graph();
        h.topologySort_indegree_kahnsmethod();//indegree based kahns method
        h.topology_dfstype();
    }
}
