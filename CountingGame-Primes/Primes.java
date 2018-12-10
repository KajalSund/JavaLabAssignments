



import java.io.*;
import java.util.*;

/**
 * Primes is a program that will compute prime numbers using the sieve of Eratosthenes.
 * 
 * @author Charles Hoot
  * @version 4.0
 */

    
public class Primes
{

    public static void main(String args[])
    {

        int max;
        
        System.out.println("Please enter the maximum value to test for primality");
        max = getInt("   It should be an integer value greater than or equal to 2.");
        
        // COMPLETE THE MAIN
        ListInterface<Integer>candidates=new AList<>(); //creating candidate list
        for(int i=2;i<=max;i++)
        	candidates.add(i);
        System.out.println("Candidate list:"+candidates); //printing candidate list
        ListInterface<Integer>primes=new AList<>(); //primes list
        ListInterface<Integer>composites=new AList<>(); //primes list
        int prime;
        while(candidates.getLength()!=0)
        {
        	prime=candidates.getEntry(1);//Removing first entry of list initially 2 and add it to the primes list
        	primes.add(prime); candidates.remove(1); //remove from the candidate list
        	getComposites(candidates,composites,prime);//generate composites
        	System.out.println("candidate list:"+candidates);//printing all the three list
        	System.out.println("prime list:"+primes);
        	System.out.println("composites list:"+composites);
        	System.out.println("prime numbers are"+primes);
        }
        
    }
    
    
    /**
     * getComposites - Remove the composite values from possibles list and
     * put them in the composites list.
     *
     * @param  candidates   A list of integers holding the possible values.
     * @param  composites   A list of integers holding the composite values.
     * @param  prime   An Integer that is prime.
     */
    public static void getComposites(ListInterface<Integer> candidates, ListInterface<Integer> composites, Integer prime)
    {
        // COMPLETE THIS METHOD
    	int i;
    	for(i=1;i<=candidates.getLength();i++)//number having prime as a factor is added to composite list
    	{
    		if(candidates.getEntry(i)%prime==0)
    		{
    			composites.add(candidates.getEntry(i));
    			candidates.remove(i);//removed from candidate list as well
    			
    		}
    		
    		
    	}
    }
    
    
    
    
    /**
     * Get an integer value.
     *
     * @return     An integer. 
     */
    private static int getInt(String rangePrompt)
    {
        Scanner input;
        int result = 10;        //Default value is 10
        try
        {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();
            
        }
        catch(NumberFormatException e)
        {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }        
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;
                                    
    }    
    
}
