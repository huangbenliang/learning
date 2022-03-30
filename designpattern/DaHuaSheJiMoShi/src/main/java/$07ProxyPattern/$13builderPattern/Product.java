package $07ProxyPattern.$13builderPattern;

import java.util.ArrayList;
import java.util.List;

public class Product {
	List<String> parts=new ArrayList<>();

	public void add(String part) {
		parts.add(part);
	}
	public void show(){
		System.out.println("产品创建...");
		parts.forEach(System.out::println);
	}
}
