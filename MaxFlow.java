package Algorithm;
import java.util.LinkedList;
import java.util.Scanner; 
	  
	class MaxFlow 
	{   
	  static int V= 25;
	    boolean bfs(int rGraph[][], int s,int t, int parent[]) 
	    { 
	    	//System.out.println(rGraph.length);
	        boolean visited[] = new boolean[V]; 
	        for(int i=0; i<rGraph.length; i++) 
	            visited[i]=false; 
	        
	        LinkedList<Integer> queue = new LinkedList<Integer>(); 
	        queue.add(s); 
	        visited[s] = true; 
	        parent[s]=-1; 
	  
	        while (queue.size()!=0) 
	        { 
	            int u = queue.poll(); 
	  
	            for (int v=0; v<rGraph.length; v++) 
	            { 
	                if (visited[v]==false && rGraph[u][v] > 0) 
	                { 
	                    queue.add(v); 
	                    parent[v] = u; 
	                    visited[v] = true; 
	                } 
	            } 
	        } 
	  
	        return (visited[t] == true); 
	    } 

	    int fordFulkerson(int graph[][], int s[], int t[]) 
	    { 
	        int u, v; 
	  
	        int rGraph[][] = new int[graph.length][graph.length]; 
	  
	        for (u = 0; u < rGraph.length; u++) 
	            for (v = 0; v < rGraph.length; v++) 
	                rGraph[u][v] = graph[u][v]; 

	        int parent[] = new int[rGraph.length]; 
  
	        for(int i=0;i<s.length;i++)
	        {
	        	for(int j=0;j<t.length;j++)
	        	{
	        		int max_flow = 0;
	        		while (bfs(rGraph, s[i], t[j], parent)) 
	                { 
				        	int path_flow = Integer.MAX_VALUE; 
				            for (v=t[j]; v!=s[i]; v=parent[v]) 
				            { 
				                u = parent[v]; 
				                path_flow = Math.min(path_flow, rGraph[u][v]); 
				            } 
			
				            for (v=t[j]; v != s[i]; v=parent[v]) 
				            { 
				                u = parent[v]; 
				                rGraph[u][v] -= path_flow; 
				                rGraph[v][u] += path_flow; 
				            } 
			
				            max_flow += path_flow; 
	                }
	        		System.out.println("\n max flow"+s[i] + "to" +t[j] +":\t" + max_flow);
	        	}
	        }
	        return 0;
	    } 
	  
	    public static void main (String[] args) throws java.lang.Exception 
	    { 
	    	try (Scanner scan = new Scanner(System.in)) {
				System.out.println("Enter the size of matrix: ");
				int l= scan.nextInt();
				int graph[][] =new int[l][l];
				System.out.println("Enter the elements of matrix: ");
				for (int i=0; i<l; i++)
				{
					for (int j=0; j<l;j++)
					{
						graph[i][j]=scan.nextInt();
					}
				}
   
				System.out.println("\nEnter the source 1: ");
				int s1= scan.nextInt();
				
				System.out.println("\nEnter the source 2: ");
				int s2= scan.nextInt();
				
				System.out.println("\nEnter the source 3: ");
				int s3= scan.nextInt();
				
				System.out.println("\nEnter the sink 1: ");
				int t1= scan.nextInt();
				
				System.out.println("\nEnter the sink 2: ");
				int t2= scan.nextInt();
				
				int s []= {s1,s2,s3};
				int t []= {t1,t2};
				
				MaxFlow m = new MaxFlow(); 
				 
				m.fordFulkerson(graph, s, t);
			} 
	  
	    } 
	} 