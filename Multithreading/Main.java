
public class Consumer implements Runnable
{	Buffer b;
	public Consumer(Buffer b) 
	{	this.b = b;
		//creating and starting the consumer thread
		Thread t = new Thread(this,"Consumer");
		t.start();
	}
	public void run()
	{	//consume the value
		while(true)
		{	b.get();
			try
			{	Thread.sleep(1000);	}
			catch(Exception e) {}
		}
	}
}
