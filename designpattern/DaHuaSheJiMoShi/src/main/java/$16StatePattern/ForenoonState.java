package $16StatePattern;

import java.text.MessageFormat;

public class ForenoonState extends State {

	@Override
	public void writeProgram(Work work) {
		if (work.getHour() < 12) {
			System.out.println(MessageFormat.format("当前时间{0}点,上午工作,精神百倍!", work.getHour()));
		} else {
			work.setCurrent(new NoonState());
			work.writeProgram();
		}
	}
}
