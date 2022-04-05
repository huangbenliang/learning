package $24ChainOfResponsibility;

import lombok.Data;
import lombok.Getter;

@Data
public class Request {
	private String name;
	private RequestEnum requestType;
	private Double number;
	private String requestContent;

	public Request(String name, RequestEnum requestType, Double number) {
		this.name = name;
		this.requestType = requestType;
		this.number = number;
	}

	enum RequestEnum {
		VACATE("请假", "天"), RAISE_SALARY("加薪", "元");

		@Getter
		private final String name;
		@Getter
		private final String unit;

		RequestEnum(String name, String unit) {
			this.name = name;
			this.unit = unit;
		}
	}

	enum RequestState {
		APPROVE("批准"), DECLINE("拒绝");
		@Getter
		private final String name;

		RequestState(String name) {
			this.name = name;
		}
	}
}
