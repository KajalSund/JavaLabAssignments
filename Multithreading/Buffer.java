
public class Buffer 
{	int number;
	//valueSet tell whether the new value of number is set or not
	boolean valueSet = false;	
	public synchronized void put (int num)
	{	//check if consumer haven't consumed the value then wait
		while(valueSet)
		{	try
			{	wait();	}
			catch(Exception e) {}
		}
		//set the new value
		System.out.println("Put : "+num);
		number = num;
		valueSet = true;
		//notify the consumer thread that value is set
		notify();
	}
	public synchronized void get ()
	{	//if value is not set then wait
		while(!valueSet)
		{	try
			{	wait();	}
			catch(Exception e) {}
		}
		//consume the value
		System.out.println("Get : "+number);
		valueSet = false;
		//notify the producer thread that value is consumed
		notify();
	}
}
