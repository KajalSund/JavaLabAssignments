
public class Producer implements Runnable
{	Buffer b;
	public Producer(Buffer b) 
	{	this.b = b;
		//creating and starting the producer thread
		Thread t = new Thread(this,"Producer");
		t.start();
	}
	public void run()
	{	int i=0;
		//set the value
		while(true)
		{	b.put(i++);
			try
			{	Thread.sleep(1000);	}
			catch(Exception e) {}
		}
	}
}
