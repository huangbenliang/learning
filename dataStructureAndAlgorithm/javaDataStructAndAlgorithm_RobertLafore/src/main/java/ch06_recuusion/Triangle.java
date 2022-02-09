package ch06_recuusion;

public class Triangle {
	public static void main(String[] args) {
		int triangle = new Triangle().triangle(5);
		System.out.println("triangle = " + triangle);
	}
	int triangle(int value){
		StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[1];
		System.out.println(stackTraceElement.getClassName()+"-->"+stackTraceElement.getMethodName());
		if (value == 1) {
			return 1;
		} else {
			return triangle(value-1)+value;
		}
	}
}
