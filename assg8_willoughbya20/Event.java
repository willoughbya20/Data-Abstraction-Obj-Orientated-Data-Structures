/**
 * Adam Willoughby
 * Class that includes all our get methods, compareTo, toString, and a method to check events
 */
package assg8_willoughbya20;

public class Event implements Comparable<Event>{
	private int time;
	private int transactionTime;
	private int departureTime;
	private int arrivalTime;
	private char event;
	
	/**
	 * Default Constructor
	 */
	public Event()
	{
		time = 0;
		transactionTime = 0;
		event = ' ';
	}
	
	/**
	 * Constructor given
	 * @param event
	 * @param arrivalTime
	 * @param transactionTime
	 * time setting to arrivalTime
	 */
	public Event(char event, int arrivalTime, int transactionTime)
	{
		this.arrivalTime = arrivalTime;
		this.transactionTime = transactionTime;
		this.event = event;
		time = arrivalTime;
	}
	/**
	 * Constructor given
	 * @param event
	 * @param departureTime
	 */
	public Event(char event, int departureTime)
	{
		this.time = departureTime;
		this.departureTime = departureTime;
		this.event = event;
	}
	
	/**
	 * Get method for time
	 * @return the time
	 */
	public int getTime()
	{
		return time;
	}
	/**
	 * Get method for departureTime
	 * @return departure time
	 */
	public int getDepartureTime()
	{
		return departureTime;
	}
	
	/**
	 * get method for arrival time
	 * @return the arrival time
	 */
	public int getArrivalTime()
	{
		return arrivalTime;
	}
	
	/**
	 * Get method for transaction time
	 * @return transaction time
	 */
	public int getTransactionTime()
	{
		return transactionTime;
	}
	/**
	 * gets the event
	 * @return the event
	 */
	public char getEvent()
	{
		return event;
	}
	
	/**
	 * Check event method to see if its Arrival or Departure
	 * @return integer
	 */
	public int checkEvent()
	{
		if (event == 'A')
		{
			return 1;
		}
		else if(event == 'D')
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}
	
	/**
	 * toString method that will return a default printing statement
	 */
	public String toString()
	{
		if (event == 'A')
		{
			return "Processing an arrival event at time: " + time;
		}
		
		else
		{
			return "Processing a departure event at time: " + time;
		}
	}
	
	/**
	 * compareTo method that will compare a certain event time
	 */
	@Override
	public int compareTo(Event a)
	{
		if (this.time > a.time) 
		{
			return 1;
		}
		else if (this.time == a.time) 
		{
			return 0;
		}
		else 
		{
			return -1;
		}
	}
}
