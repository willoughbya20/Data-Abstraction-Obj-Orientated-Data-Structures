/**
 * Class that produces the main method output by reading
 * in an default input file. Along with 2 other methods to
 * process arrival and departure events to form a correct solution.
 * 
 * 
 */
package assg8_willoughbya20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Simulation {
	
	private static Scanner scan = null;
	private static int time;
	private static int i;
	private static double people;
	private static int [] w = new int [20];

	public static void main(String[] args) {
		String filename = "assg8_input.txt";
		Queue<Event> q1 = new LinkedList<Event>();
		EventList list = new EventList();
		File file = new File(filename);

		try 
		{
			scan = new Scanner(file);
		}
		catch(FileNotFoundException e) 
		{
			System.out.println("File error, couldnt open " + filename);
			System.exit(1);
		}
		
		if(scan.hasNextLine())
		{
			StringTokenizer ST1 = new StringTokenizer(scan.nextLine(), "\t");
			if(ST1.hasMoreTokens())
			{
				try
				{
					int obj1 = (Integer.valueOf(ST1.nextToken()));
					int obj2 = (Integer.valueOf(ST1.nextToken()));
					list.insertEvent(new Event('A', obj1, obj2));
				}
				catch (NumberFormatException e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		
		while(list.checkList())		
		{
			if(list.retrieveEvent().checkEvent() == 1)
			{
				processArrival(list.retrieveEvent(), list, q1);
			}
			else
			{
				processDeparture(list.retrieveEvent(), list, q1);
			}

		}
		
		System.out.println("Simulation ends \n \n Final Statistics: \n Total number of people processed: " + people);
		int sum = 0;
		double avg;
		for(int k = 0; k < i; k++)
		{
			sum = sum + w[k];
		}
		avg = sum/people;
		System.out.println("Average of time spent waiting: " + avg);
		
		
	}
	
	/**
	 * Method that will process an Arrival event
	 * @param a the event
	 * @param list of events
	 * @param q queue stack
	 */
	public static void processArrival(Event a, EventList list, Queue<Event> q)
	{
		System.out.println("Processing an arrival event at time: " + a.getArrivalTime());
		people++;
		
		time = a.getArrivalTime();
		q.add(a);
		list.removeEvent();
		
		if(q.peek() == a)
		{
			list.insertEvent(new Event('D', time + a.getTransactionTime()));
			i++;
		}
		
		if(scan.hasNextLine())
		{
			StringTokenizer st1 = new StringTokenizer(scan.nextLine(), "\t");
			if(st1.hasMoreTokens())
			{
				try
				{
					int temp = (Integer.valueOf(st1.nextToken()));
					int temp2 = (Integer.valueOf(st1.nextToken()));
					list.insertEvent(new Event('A', temp,temp2));
				}
				catch(NumberFormatException e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	/**
	 * Method to process a departure event
	 * @param d event
	 * @param list of events
	 * @param q queue stack
	 */
	public static void processDeparture(Event d, EventList list, Queue<Event> q)
	{
		System.out.println("Processing a departure event at time: " + d.getTime());
		
		time = d.getTime();
		q.remove();
		
		list.removeEvent();
		
		if(!q.isEmpty())
		{
			list.insertEvent(new Event('D', time + q.peek().getTransactionTime()));
			w[i] = time - q.peek().getTime();
			
			i++;
			time = time + q.peek().getTransactionTime();	
		}
	}

}
