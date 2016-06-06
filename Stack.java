/* This program was written by Brady Sheehan on 12/20/14
*
*/
package lru_caching;

public class Stack<E>{
	private Object[] stack;
	private int stackPointer; //current index we are looking at in the array
	
	public Stack(){
		stackPointer = 0;
		stack = new Object[10];
		System.out.println("stack created with defuault size of 10");
	}

	public Stack(int size){
		stack = new Object[size];
		stackPointer = 0;
	}

	public void push(E data){
		if(stack.length == stackPointer)
			System.out.println("Stack is full");
		else
			stack[stackPointer++] = data;
	}

	public E pop(){
		if(!isEmpty()){
			@SuppressWarnings("unchecked")
			E data = (E) stack[--stackPointer]; //grab the top element of the stack
			return data;
		}
		System.out.println("stack is empty");
		return null;
	}

	public boolean isEmpty(){ //if stackPointer == 0, stack must be empty becuase if it had one element, it would point to the next empy spot (1)
		return stackPointer==0?true:false; 
	}

	public String toString(){
		for(int i = 0; i < stack.length ; i ++){
			System.out.print(stack[i]);
		}
	}

	public void printReverse(){
		for(int i = stackPointer; i >= 0; i--){
			System.out.print(stack[i]);
		}
	}

	public static void main(String args[]){
		Stack<Integer> intStack = new Stack<Integer>(30);
		for(int i = 0; i < 30; i++){
			intStack.push(29 - i);
		}
		System.out.println(intStack);
		System.out.println("Popped: "+ intStack.pop());
		int poppedValue = intStack.pop();
		System.out.println("poppedValue = " + poppedValue);
	}
}
