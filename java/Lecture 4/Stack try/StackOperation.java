class StackUnderflow extends Exception {}
class StackOverflow extends Exception {}
class StackisEmpty extends Exception {}



class Stack
{
	private int top;
	private char array[];
	private int max_size;

	Stack(int size)
	{
		max_size = size;
		array = new char[size];
		top = -1;
	}
	boolean isEmpty()
	{
		
		if(top==-1)
		{
			return true;
		}
		
		return false;
	}
	boolean isFull()
	{
		if(top==max_size-1)
		{
			return true;

		}
		return false;
	}
	void push(char input) throws StackOverflow
	{
		if(isFull())
		{
			throw new StackOverflow();
		}
		array[++top] = input;


	}
	char pop() throws StackUnderflow
	{
		if(isEmpty())
		{
			throw new StackUnderflow();	
		}
		return array[top--];

	}
	char peek() throws StackisEmpty
	{
	
		
		if(isEmpty())
		{
			
			throw new StackisEmpty();
		}
		return array[top];
		
	}

}

class StackOperation
{
	public static void main(String[] args) {
		Stack obj1 = new Stack(5);
		try
		{
			// System.out.println("Stack top: "+obj1.peek());
			obj1.push('a');
			obj1.push('b');
			obj1.push('c');
			obj1.push('d');
			obj1.push('e');
			obj1.push('x');
			System.out.println("Stack top: "+obj1.peek());

			while(true)
			{
				System.out.println(obj1.pop());
			}
			

		}
		catch(StackUnderflow e)
		{
			System.out.println("Stack underflow");
		}
		catch(StackOverflow e)
		{
			System.out.println("Stack Overflow");
		}
		catch(StackisEmpty e)
		{
			System.out.println("Stack is empty");
		}
	}
}