package Algorithm;
import java.util.*;

public class AStarSearch{

    public static void main(String[] args){

            //initialize the graph
            Node n1 = new Node("A",3);
            Node n2 = new Node("B",7);
            Node n3 = new Node("C",8);
            Node n4 = new Node("D",25);
            Node n5 = new Node("E",17);
            Node n6 = new Node("F",19);
            Node n7 = new Node("G",98);
            Node n8 = new Node("H",32);
            Node n9 = new Node("I",24);
            Node n10 = new Node("J",41);
            Node n11 = new Node("K",42);
            Node n12 = new Node("L",16);
            Node n13 = new Node("M",0);
            Node n14 = new Node("N",77);

            //initialize the edges

            n1.adjacencies = new Edge[]{
                    new Edge(n2,5),
                    new Edge(n4,14),
                    new Edge(n8,11)
            };

            n2.adjacencies = new Edge[]{
                    new Edge(n1,15),
                    new Edge(n3,10)
            };
             
            n3.adjacencies = new Edge[]{
                    new Edge(n2,71),
                    new Edge(n4,15)
            };
             
            n4.adjacencies = new Edge[]{
                    new Edge(n1,14),
                    new Edge(n5,9),
                    new Edge(n3,15),
                    new Edge(n6,8),
            };
             
            n5.adjacencies = new Edge[]{
                    new Edge(n4,9),
                    new Edge(n13,21)
            };
             
            n6.adjacencies = new Edge[]{
                    new Edge(n4,8),
                    new Edge(n7,7),
                    new Edge(n12,14)
            };

            n7.adjacencies = new Edge[]{
                    new Edge(n6,7),
                    new Edge(n13,10),
                    new Edge(n12,13)
            };
             
            n8.adjacencies = new Edge[]{
                    new Edge(n1,18),
                    new Edge(n9,11)
            };
             
            n9.adjacencies = new Edge[]{
                    new Edge(n8,11),
                    new Edge(n10,7)
            };

            n10.adjacencies = new Edge[]{
                    new Edge(n9,7),
                    new Edge(n11,5)
            };
         
            n11.adjacencies = new Edge[]{
                    new Edge(n10,5),
                    new Edge(n12,10)
            };

            n12.adjacencies = new Edge[]{
                    new Edge(n11,12),
                    new Edge(n6,46),
                    new Edge(n7,13)
            };

            n13.adjacencies = new Edge[]{
                    new Edge(n7,11),
                    new Edge(n14,9),
                    new Edge(n5,21)
            };

            n14.adjacencies = new Edge[]{
                    new Edge(n13,10)
            };

            AstarSearch(n1,n13);

            List<Node> path = printPath(n13);

                    System.out.println("Path: " + path);
    }

    public static List<Node> printPath(Node target)
    {
            List<Node> path = new ArrayList<Node>();
    
    for(Node node = target; node!=null; node = node.parent)
    {
        path.add(node);
    }

    Collections.reverse(path);

    return path;
    }

    public static void AstarSearch(Node source, Node goal){

            Set<Node> explored = new HashSet<Node>();

            PriorityQueue<Node> queue = new PriorityQueue<Node> (20, new Comparator<Node>()
            { //override compare method
             public int compare(Node i, Node j)
             {
                if(i.f_scores > j.f_scores){
                    return 1;
                }

                else if (i.f_scores < j.f_scores){
                    return -1;
                }

                else{
                    return 0;
                }
             }

           });

            //cost from start
            source.g_scores = 0;

            queue.add(source);

            boolean found = false;

            while((!queue.isEmpty())&&(!found))
            {

                    //the node in having the lowest f_score value
                    Node current = queue.poll();
                    explored.add(current);

                    //goal found
                    if(current.value.equals(goal.value)){
                            found = true;
                    }
                    //check every child of current node
                    for(Edge e : current.adjacencies){
                            Node child = e.target;
                            double cost = e.cost;
                            double temp_g_scores = current.g_scores + cost;
                            double temp_f_scores = temp_g_scores + child.h_scores;
                            
                            if((explored.contains(child)) && (temp_f_scores >= child.f_scores))
                            {
                                    continue;
                            }

                            else if((!queue.contains(child)) || 
                                    (temp_f_scores < child.f_scores)){
                                    child.parent = current;
                                    child.g_scores = temp_g_scores;
                                    child.f_scores = temp_f_scores;
                                    if(queue.contains(child)){
                                            queue.remove(child);
                                    }
                                    queue.add(child);
                            }
                    }
            }
    } 
}

class Node{

    public final String value;
    public double g_scores;
    public final double h_scores;
    public double f_scores = 0;
    public Edge[] adjacencies;
    public Node parent;

    public Node(String val, double hVal){
            value = val;
            h_scores = hVal;
    }
    public String toString(){
            return value;
    }
}

class Edge{
    public final double cost;
    public final Node target;

    public Edge(Node targetNode, double costVal){
            target = targetNode;
            cost = costVal;
    }
}