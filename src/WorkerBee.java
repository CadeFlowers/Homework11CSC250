import java.util.Random;
public class WorkerBee extends Thread
{
	
	private String name;
	private int[] intArray;
	
	public WorkerBee(String name, int[] intArray) 
	{
		this.name = name;
		this.intArray = intArray;
	}
	
	@Override
	public void run() 
	{
		for(int i = 0; i < 10; i++) 
		{
			//System.out.println(this.name + " : " + i);
		}
		for(int i = 0; i < 10; i++) 
		{
			System.out.println(intArray[i] + " : " + name);
		}
	}
}
