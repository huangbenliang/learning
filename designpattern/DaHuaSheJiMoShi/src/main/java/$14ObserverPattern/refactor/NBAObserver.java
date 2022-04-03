package $14ObserverPattern.refactor;


import java.text.MessageFormat;

public class NBAObserver {
	private final String name;
	private final Subject sub;

	public NBAObserver(String name, Subject sub) {
		this.name = name;
		this.sub = sub;
	}

	public  void closeLiveStream() {
		System.out.println(MessageFormat.format("{0} {1}关闭NBA直播,继续工作!", sub.getSubjectState(), name));
	}
}
