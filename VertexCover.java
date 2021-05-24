package Algorithm;

import java.util.Scanner;

public class VertexCover {

	static final int maxn = 25; 
	static Scanner scan = new Scanner(System.in);
	
	
	static boolean [][]gr = new boolean[maxn][maxn]; 

	static boolean isCover(int V, int k, int E) 
	{ 
	    int set = (1 << k) - 1; 
	  
	    int limit = (1 << V); 

	    boolean [][]vis = new boolean[maxn][maxn];; 
	  
	    while (set < limit) 
	    { 
	        for(int i = 0; i < maxn; i++) 
	        { 
	            for(int j = 0; j < maxn; j++) 
	            { 
	                vis[i][j] = false; 
	            } 
	        } 

	        int cnt = 0; 
	 
	        for (int j = 1, v = 1 ; j < limit ; j = j << 1, v++) 
	        { 
	            if ((set & j) != 0) 
	            {
	                for (int co = 1 ; co <= V ; co++) 
	                { 
	                    if (gr[v][co] && !vis[v][co]) 
	                    { 
	                        vis[v][co] = true; 
	                        vis[co][v] = true; 
	                        cnt++; 
	                    } 
	                } 
	            } 
	        } 

	        if (cnt == E) 
	            return true; 
	  
	        int co = set & -set; 
	        int ro = set + co; 
	        set = (((ro^set) >> 2) / co) | ro; 
	    } 
	    return false; 
	} 
	  

	static int findMinCover(int n, int m) 
	{ 

	    int left = 1, right = n; 
	    while (right > left) 
	    { 
	        int mid = (left + right) >> 1; 
	        if (isCover(n, mid, m) == false) 
	            left = mid + 1; 
	        else
	            right = mid; 
	    } 
	  

	    return left; 
	} 

	static void insertEdge() 
	{ 

			System.out.println("Enter the value of u: ");
			int u=scan.nextInt();
			
			System.out.println("Enter the value of v: ");
			int v=scan.nextInt(); 
			
			gr[u][v] = true; 
			gr[v][u] = true;
	} 
	   
	public static void main(String[] args) 
	{ 
		System.out.println("CAT3\nNAME: ANKITA SINHA  Reg No.: 20MCI0003\n");
	    int V, E; 
	 
	    for(int i = 0; i < maxn; i++) 
	    { 
	        for(int j = 0; j < maxn; j++) 
	        { 
	            gr[i][j] = false; 
	        } 
	    } 
	    System.out.println("Enter the number of vertices and edges in graph");
				V = scan.nextInt();
				E = scan.nextInt();
				for (int i=0; i<E;i++)
				{
					insertEdge();
					
				}
			System.out.print("Minimum size of a vertex cover = "
			    + findMinCover(V, E) +"\n"); 
			}
	
}
  
