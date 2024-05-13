/**
 * Adam Willoughby
 * Class that will create an event list, check if its empty, as well as
 * be able to insert, remove, and retrieve items.
 */
package assg8_willoughbya20;

import java.util.*;

public class EventList {
	
	/**
	 * Default constructor
	 * Creates a new linked list
	 */
	LinkedList<Event> q;
	public EventList()
	{
		q = new LinkedList<Event>();
	}
	
	/**
	 * Method that will check the list and see if its empty
	 * @return false if its empty
	 * @return true if its not
	 */
	public boolean checkList()
	{
		if(q.size() < 1)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Method that will be able to insert items into the list
	 * @param obj certain event to be added
	 */
	public void insertEvent(Event obj)
	{
		if (q.size() > 0)
		{
			if (q.peek().getTime() > obj.getTime()) 
			{
				Event temp = q.poll();
				q.add(obj);
				q.add(temp);
			}
			else if (q.peek().getTime() == obj.getTime())
			{
				Event temp = q.poll();
				q.add(obj);
				q.add(temp);
			}
			else
			{
				q.add(obj);
			}
		}
		else
		{
			q.add(obj);
		}
	}
	
	/**
	 * Method that removes an event
	 */
	public void removeEvent()
	{
		q.remove();
	}
	
	/**
	 * Method that will retrieve an event from the list
	 * @return item from list
	 */
	public Event retrieveEvent()
	{
		return q.peek();
	}
}
