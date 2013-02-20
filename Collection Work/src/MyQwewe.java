/**
 * 
 */

/**
 * @author jack
 *
 */
public class MyQwewe implements Qwewe{

	/**
	 * @param args
	 */
	
	private Object[] qwewe;
	private int front=0;			//next element location in existing Q
	private int back=0;				//next available array location for a new item
	private boolean empty=true;
	
	public MyQwewe(int capacity)
	{
		qwewe=new Object[capacity];
	}
	
	public boolean isFull()
	{
		return front==back&&!empty;
	}
	
	public boolean add(Object obj)
	{
		empty=false;
		if(isFull())
			return false;
		
		qwewe[back]=obj;
		back++;
		back%=qwewe.length;
		
		return true;
		
	}
	
	public boolean isEmpty()
	{
		return front==back&&empty;
	}
	
	public Object remove()
	{
		if(front==qwewe.length-1)
		{
			front=0;
			Object o=qwewe[qwewe.length-1];
			qwewe[qwewe.length-1]=null;
			if(front==back)
				empty=true;
			return o;
		}
		else
		{
			front++;
			Object o= qwewe[front-1];
			qwewe[front-1]=null;
			if(front==back)
				empty=true;
			return o;
		}
	}
	
	public Object peek()
	{
		return qwewe[front];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
