package $14ObserverPattern;

import lombok.Data;

import java.text.MessageFormat;

@Data
public class StockObserver {
	private String name;
	private Secretary secretary;

	public StockObserver(String name, Secretary secretary) {
		this.name = name;
		this.secretary = secretary;
	}

	public void update() {
		System.out.println(MessageFormat.format("{0}{1} 关闭股票信息,继续工作!", secretary.getAction(), name));
	}
}
