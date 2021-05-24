package Algorithm;
import java.util.*;
public class CaesarCipherD 
{
    public static void main(String args[]) 
    {
    try (Scanner sc = new Scanner(System.in)) {
		System.out.println(" Enter cipher text message : ");
		String c = sc.nextLine();
		System.out.println("Key : ");
		int k = sc.nextInt();
		int shift= Math.abs(k);
		String d = "";
		for(int i=0; i < c.length();i++)  
		{
		    char a = c.charAt(i);
		    if(a >= 'a' && a<= 'z')
		    {
		        a= (char) (a - shift);
		        if(a < 'a') 
		        {
		            a= (char) (a-'a'+'z'+1);
		        }
		        d= d + a;
		    }    
		    else if(a >= 'A' && a <= 'Z')
		    {
		        a = (char) (a - shift);
		        if (a < 'A')
		        {
		            a = (char) (a-'A'+'Z'+1);
		        }
		        d= d + a;            
		    }
		    else 
		    {
		     d = d + a;            
		    } 
		}
		System.out.println(" decrypt message : " + d);
	}
}
}
