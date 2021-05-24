package Algorithm;
import java.util.*;
public class CaesarCipher 
{
	public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
			System.out.println(" Message for Encrytion : ");
			String text = sc.nextLine();
			System.out.println(" Key: ");
			int shift = sc.nextInt();
			int k= Math.abs(shift);
			String c = "";
			char a;
			for(int i=1; i <= text.length();i++) 
			{
			    a = text.charAt(i-1);     
			    
			    if(a >= 'a' && a <= 'z') 
			    {
			     a = (char) (a + k);
			     
			     if(a > 'z') 
			     {
			        a= (char) (a+'a'-'z'-1);
			     }
			     c = c + a;
			    }
			    else if(a>= 'A' && a <= 'Z')
			    {
			     a = (char) (a+ k);    
			     if(a > 'Z') 
			     {
			         a = (char) (a+'A'-'Z'-1);
			     }
			     c = c + a;
			    }
			    else {
			     c = c + a;   
			    }
   }
   System.out.println(" ciphertext : " + c);
		}
  }
}
