import java.util.Random;
public class Driver 
{
	public static void main(String[] args) 
	{
		int[] ar = new int[100];
		Random r = new Random();
		for(int i = 0; i < ar.length; i++) 
		{
			ar[i] = r.nextInt(1000);
		}
		WorkerBee wb1 = new WorkerBee("WB1", ar);
		//WorkerBee wb2 = new WorkerBee("WB2", ar);
		wb1.start();
		//wb2.start();
		while(Thread.activeCount() > 1) 
		{
			
		}
		mergeSort(ar, 0, ar.length-1);
		//Driver.displayArray(ar);
		
	}
	
	static void mergeSort(int[] ar, int begin, int end) 
	{
		if(begin != end) 
		{
			int begin1 = begin;
			int end1 = begin + (end - begin)/2;
			int begin2 = end1 + 1;
			int end2 = end;
			mergeSort(ar, begin1, end1);
			mergeSort(ar, begin2, end2);
			merge(ar, begin1, end1, begin2, end2);
		}
	}
	
	static void merge(int[] ar, int begin1, int end1, int begin2, int end2) 
	{
		int[] temp = new int[end2 - begin1 + 1];
		int pos1 = begin1;
		int pos2 = begin2;
		for(int i = 0; i < temp.length; i++) 
		{
			if(pos1 <= end1 && pos2 <= end2)
			{
				if(ar[pos1] < ar[pos2]) 
				{
					temp[i] = ar[pos1];
					pos1++;
				}
				else 
				{
					temp[i] = ar[pos2];
					pos2++;
				}		
			}
			else 
			{
				if(pos1 > end1) 
				{
					temp[i] = ar[pos2];
				}
				else 
				{
					temp[i] = ar[pos1];
					pos1++;
				}
			}

		}
		
		int posInTemp = 0;
		for(int i = begin1; i <= end2; i++) 
		{
			ar[i] = temp[posInTemp];
			posInTemp++;
		}
	}
	
	static void displayArray(int[] ar) 
	{
		for(int i = 0; i < ar.length; i++) 
		{
			System.out.println(ar[i]);
		}
	}
}
