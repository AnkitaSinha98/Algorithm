package Algorithm;
import java.util.*;
public class Knapsack 
{
	    static int max(int a, int b) 
	    { 
	        return (a > b) ? a : b; 
	    } 

	    static int knapSack( int W, int wt[], int val[], int n) 
	    { 
	        if (n == 0 || W == 0) 
	            return 0; 
	        
	        if (wt[n - 1] > W) 
	            return knapSack(W, wt, val, n - 1); 
	        else
	            return max( val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), 
	        
	        knapSack(W, wt, val, n - 1)); 
	    } 
	    public static void main(String args[]) 
	    { 
	    	try (Scanner sc = new Scanner(System.in)) {
				System.out.println("Enter the number of items:");
				int n = sc.nextInt();
				int[] val = new int[n];
				int[] wt = new int[n];
				
				System.out.println("\nEnter the items weight and values\n");
				for(int i = 0; i < n; i++)
				{
					wt[i] = sc.nextInt();
					val[i] = sc.nextInt();
				}	
			
				System.out.println("\nEnter the capacity of the knapsack:");
				int W = sc.nextInt();
				System.out.println("\nMaximum value in knapsack:" + knapSack(W, wt, val, n));
			}
		}
}
