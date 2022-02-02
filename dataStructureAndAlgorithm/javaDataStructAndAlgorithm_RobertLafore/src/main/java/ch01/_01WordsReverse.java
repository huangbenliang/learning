package ch01;

public class _01WordsReverse {
	public static void main(String[] args) {
		ReverseHandler reverseHandler=new ReverseHandler();
		System.out.println(reverseHandler.reverse("abcdef"));
	}

}
class ReverseHandler{
	Stack stack;
	public ReverseHandler(){
	}
	public String reverse(String str){
		stack=new Stack(str.length());
		for (char c : str.toCharArray()) {
			stack.push(c);
		}
		StringBuilder sb=new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}
}
class Stack{
	 Character[] stack;
	 int size;
	 public Stack(int maxSize){
		 stack=new Character[maxSize];

	 }
	 public boolean isEmpty(){
		 return size==0;
	 }
	 public boolean isFull(){
		 return size==stack.length;
	 }

	public void push(Character c) {
		if (!isFull()) {
			stack[size++]=c;
		}
	}
	public Character pop(){
		if (!isEmpty()) {
			return stack[--size];
		}
		return null;
	}
}
