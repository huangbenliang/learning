package $14ObserverPattern;

import lombok.Data;
import lombok.EqualsAndHashCode;
import sun.font.TrueTypeFont;

@Data
@EqualsAndHashCode(callSuper = true)
public class ConcretePublisher extends Publisher {
	private String publisherState;
}
