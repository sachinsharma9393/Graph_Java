/**
 * Created by sachin on 12/19/2017.
 */
public class Floyd_Warshall {
    public static void main(String[] args) {
        Sample_Graph h=new Sample_Graph(10);
        h.addEdge(5,3,3);
        h.addEdge(1,2,3);
        h.addEdge(1,3,6);
        h.addEdge(1,5,5);
        h.addEdge(2,4,1);
        h.addEdge(4,3,1);
        h.addEdge(3,6,8);
        h.addEdge(6,7,6);
        h.addEdge(6,8,7);
        h.addEdge(8,9,2);
        h.addEdge(7,10,7);
        h.addEdge(9,10,3);
        h.all_pair_short_path();
    }
}
