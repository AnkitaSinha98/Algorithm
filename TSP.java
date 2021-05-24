package Algorithm;
import java.util.*;
public class TSP 
{
	static int tsp(int[][] graph, boolean[] v,  int currPos, int n, int count, int cost, int ans)  
	{ 
		if (count == n && graph[currPos][0] > 0)  
		{ 
			ans = Math.min(ans, cost + graph[currPos][0]); 
			return ans; 
			} 
		for (int i = 0; i < n; i++) 
		{ 
			if (v[i] == false && graph[currPos][i] > 0) 
			{ 
				v[i] = true; 
				ans = tsp(graph, v, i, n, count + 1, cost + graph[currPos][i], ans);  
				v[i] = false; 
				} 
			} 
		return ans; 
		} 
	public static void main(String[] args) 
	{ 
		try (Scanner scan = new Scanner(System.in)) 
		{
			System.out.println("Enter order n:");
			int n = scan.nextInt();
			
			System.out.println("Enter "+n+" order matrix:");
			int[][] graph = new int[n][n];
			for (int i = 0; i < n; i++)
			    for (int j = 0; j < n; j++)
			        graph[i][j] = scan.nextInt();

			
			boolean[] v = new boolean[n]; 
			v[0] = true; 
			int ans = Integer.MAX_VALUE; 
			ans = tsp(graph, v, 0, n, 1, 0, ans); 
			System.out.println("Minimum cost to visit all nodes:" +ans);
		} 
     } 
}
