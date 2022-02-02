package ch01;

public class StackX {
	char[] stack;
	int top;
	//int size;
	public StackX(int maxSize) {
		stack=new char[maxSize];
		top=-1;
	}
	public void push(char c) {
		if (top + 1 < stack.length) {
			stack[++top] = c;
		} else {
			throw new IndexOutOfBoundsException("栈已满");
		}
		//size++;
	}
	public char pop(){
		if (isEmpty()) {
			throw new RuntimeException("栈为空！");
		}
		return stack[top--];
		//size
	}
	public char peek(){
		if (isEmpty()) {
			throw new RuntimeException("栈为空！");
		}
		return stack[top];
	}
	public boolean  isEmpty(){
		return top==-1;
	}
	public int size(){
		if (top == -1) {
			return 0;
		} else {
			return top+1;
		}
	}
}
