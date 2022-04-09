package $26FlyWeight;

import java.util.Hashtable;

public class WebsiteFactory {
	private Hashtable<String, Website> flyweights = new Hashtable<>();

	public Website getWebsiteCategory(String key) {
		if (!flyweights.containsKey(key)) {
			flyweights.put(key, new ConcreteWebsite(key));
		}
		return flyweights.get(key);
	}
	public  int getWebsiteCount(){
		return flyweights.size();
	}
}
