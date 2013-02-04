import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;


public class Problems2 {

	/**
	 * @param args
	 */
	
	//Problem 7
	
	//Output is: BCA
	
	
	//Problem 8
	
	//Output is: Three-Two
	//			 Three-Two-One
	//			 Three-Two-One
	
	
	//Problem 9
	
	//Contents are:  4 7 3 -6 -2 -1 (top)
	
	
	//Problem 10
	
	/*
	Point cursor;
	Stack<Double> stk = new Stack<Double>();
	...
	//Save cursor position
	stk.push(cursor.getX());
	stk.push(cursor.getY());
	
	show(new LoginWindow());
	...
	//Restore cursor position:
	double y=stk.pop();				//switch those for bug fix
	double x=stk.pop();
	cursor.move(x,y);
	
	
	//simplify code by taking out the variables x and y and popping directly into the move method
	*/
	
	//Problem 13
	
	//Output is: 0 2 1 3 2 4
	
	
	
	//Problem 14
	public class Student
	{
		private String name;
		private double GPA;
		
		public Queue<Student> cutAtGPA(Queue<Student> students, double minGPA)
		{
			Queue<Student> honors = new LinkedList<Student>();
			
			while(!students.isEmpty())
			{
				if(students.peek().GPA>=minGPA)
					honors.add(students.remove());
				else
					students.remove();
			}
			
			
			return honors;
		}
	}
	
	
	//Problem 15
	
	public void replace(Queue<String> morseCode)
	{	
		for(int i=0;i<morseCode.size();i++)
		{
			if(morseCode.peek()=="..--..")
			{
				morseCode.remove();
				morseCode.add(".-.-.-");
			}
			else
			{
				morseCode.add(morseCode.remove());
			}
		}
	}
	
	//Problem 16
	
	public static <E> Queue<E> copy(Queue<E> q)
	{
		Queue<E> copy=new LinkedList<E>();
		
		if(q.isEmpty())
			return copy;
		
		
		for(int i=0;i<q.size();i++)
		{
			copy.add(q.peek());
			q.add(q.remove());
		}
		
		
		return copy;
	}
	
	
	//Sheet Problem 1
	
	//Title: Merge
	
	
	//Sheet Problem 2
	
	//Output is: 3 1 2 2 1 3
	
	
	//Sheet Problem 3
	
	//Contents are: C
	
	
	//Sheet Problem 4
	
	//Output is: A
	
	
	//Sheet Problem 5
	
	//Output is: 7 5 4 2
	
	
	//Sheet Problem 6
	
	//Impossible output is: C b/c there are two queues outputed in order of highest to lowest, and that means there can only be one transition
	//in the output that goes from lower to higher and that's the transition between queues, but that happens twice in C, making it impossible.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Stack<String> stk = new Stack<String>();
		
		stk.push("E");
		stk.push("D");
		stk.push("C");
		stk.push("B");
		stk.push("A");
		
		Queue[] qs={new LinkedList<String>(), new LinkedList<String>()};
		while(!stk.isEmpty())
			qs[(int)(2*Math.random())].add(stk.pop());
		for(int i=0;i<2;i++)
			while(!qs[i].isEmpty())
				stk.push((String)qs[i].remove());
		while(!stk.isEmpty())
			System.out.print(stk.pop());
		
	}
}
