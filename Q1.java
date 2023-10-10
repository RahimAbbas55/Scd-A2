import java.util.Scanner;
class EmptyStackException extends RuntimeException 
{
    public EmptyStackException(String message) 
    {
        super(message);
    }
}

class node<T>
{
    public T data;
    public node next;

    public node ( T d )
    {
        data = d;
        next = null;
    }
}
class GenericStack<T>
{
    private node<T> head;
    public GenericStack()
    {
        head = null;
    }
    public void pushInStack ( T item )
    {
        node<T> toAdd = new node<>(item);
        toAdd.next = head;
        head = toAdd;
    }
    public void popFromStack ()
    {
        if (isEmpty())
        {
            throw new EmptyStackException("Stack is empty.");
        }
        T value = head.data;
        head = head.next;
        System.out.println( value + " popped from the Stack.");
    }
    public boolean isEmpty()
    {
        if ( head == null )
        {
            return true;
        }
        return false;
    }
    public T peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException("Stack is empty.");
        }
        return head.data;
    }
}
public class Q1
{
    public static void main( String [] args )
    {
        System.out.println("Welcome to Stack!");
        int sizeOfStack = 0 , value = 0 , choice = 0 , temp = 0;

        GenericStack<Integer> stack = new GenericStack<>();
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Size of the Stack: ");
        sizeOfStack = obj.nextInt();

        for ( int i = 0 ; i < sizeOfStack ; i++)
        {
            System.out.println("Enter " + (i+1) + " value of stack: ");
            value = obj.nextInt();
            stack.pushInStack(value);
        }
        do
        {
            System.out.println("Perform Stack Operations!");
            System.out.println("1)Pop.");
            System.out.println("2)Push.");
            System.out.println("3)Size.");
            System.out.println("4)Check if empty.");
            System.out.println("5)Quit.");
            System.out.println("Enter your choice: ");
            choice = obj.nextInt();

            if (choice == 1 )
            {
                stack.popFromStack();
                temp++;
                System.out.println();
            }
            else if ( choice == 2 )
            {
                System.out.println("Enter value to push in stack: ");
                value = obj.nextInt();
                stack.pushInStack( value );
                System.out.println();
            }
            else if ( choice == 3 )
            {
                System.out.println("Size of Stack is: " + (sizeOfStack - temp));
                System.out.println();
            }
            else if ( choice == 4 )
            {
                boolean isEmpty = stack.isEmpty();
                if ( isEmpty )
                {
                    System.out.println("Stack is Empty");
                }
                else 
                {
                    System.out.println("Stack is not Empty");
                }    
                System.out.println();
            }
            else if ( choice == 5 )
            {
                System.out.println("Exiting");
                break;   
            }
            else
            {
                System.out.println("Invalid option opted.");
                System.out.println();
            }
        }
        while(choice != 5);

    }
}