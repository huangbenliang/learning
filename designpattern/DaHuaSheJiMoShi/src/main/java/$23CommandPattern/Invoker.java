package $23CommandPattern;

import lombok.Setter;

public class Invoker {
	@Setter
	private Command command;

	public void executeCommand(){
		command.execute();
	}
}
