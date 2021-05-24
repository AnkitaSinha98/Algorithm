package Algorithm;
import java.util.Scanner;
	 
  public class Knapsackf  
	{  
	    public static void main(String args[])
	    {  
	        int i,j=0,W,n;  
	        float sum=0,max;  
	        try (Scanner sc = new Scanner(System.in)) 
	        { 
				
				System.out.println("Enter no of items: ");  
				n=sc.nextInt(); 
				int arr[][]=new int[2][n]; 
				
				System.out.println("Enter the weights of each items: ");
				for(i=0;i<n;i++)  
				    arr[0][i]=sc.nextInt();    
 
				System.out.println("Enter the values of each items: ");
				for(i=0;i<n;i++)  
				    arr[1][i]=sc.nextInt(); 
 
				System.out.println("Enter maximum volume of knapsack: ");  
				W=sc.nextInt();  
  
				
				while(W>=0)  
				{  
				    max=0;  
				    for(i=0;i<n;i++)  
				    {  
				        if(((float)arr[1][i])/((float)arr[0][i]) > max)  
				        {  
				            max=((float)arr[1][i])/((float)arr[0][i]);  
				            j=i; 
				            //System.out.println(max);
				            //System.out.println(j);
				        }  
				    }  
				    if(arr[0][j] > W)  
				    {  
				        System.out.println("No. of item number: " +  (j+1) + " added is " +W);  
				        sum+=W*max;  
				        W=-1;  
				    }  
				    else  
				    {  
				        System.out.println("No. of item number: " + (j+1) + " added is " + arr[0][j]);  
				        W-=arr[0][j];  
				        sum+=(float)arr[1][j];  
				        arr[1][j]=0; 
				        //System.out.println(W);
				    }  
				}  
				System.out.println("The total value is " + sum);
			}
	    }  
	}


