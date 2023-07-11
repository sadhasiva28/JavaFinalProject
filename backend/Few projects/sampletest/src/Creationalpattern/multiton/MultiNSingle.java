package multiton;

import java.util.HashMap;
import java.util.Map;

//Singleton
class ResourceSingleton {
	private static Resource instance = new Resource();

	private ResourceSingleton() {
	}

	public static Resource getInstance() {
		return instance;
	}
}

//Multiton
class ResourceMultiton {
	private static Map<String, Resource> instances = new HashMap<>();

	private ResourceMultiton() {
	}

	public static synchronized Resource getInstance(String key) {
		if (!instances.containsKey(key)) {
			instances.put(key, new Resource());
		}
		return instances.get(key);
	}
}

class ResourceMultitonn {
	private static Map<String, Resource> minstances = new HashMap<>();
	private static final int MAX_INSTANCES = 3;

	private ResourceMultitonn() {
	}

	public static Resource getInstance(String key) {
		if (!minstances.containsKey(key) && minstances.size() < MAX_INSTANCES) {
			minstances.put(key, new Resource());
		}
		return minstances.get(key);
	}
}

class Resource {
	private String name;

	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Resource(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class MultiNSingle {
	public static void main(String[] args) {
		// Singleton
		Resource r1 = ResourceSingleton.getInstance();
		Resource r2 = ResourceSingleton.getInstance();
		System.out.println(r1 == r2); // true

		System.out.println("-------------");
		// Multiton
		Resource r3 = ResourceMultiton.getInstance("key1");
		Resource r4 = ResourceMultiton.getInstance("key1");
		Resource r5 = ResourceMultiton.getInstance("key2");
		System.out.println(r3 == r4); // true
		System.out.println(r4 == r5); // false
		
		System.out.println("-------------");
		//ResourceMultitonn with fixed no of keys
		Resource res1 = ResourceMultitonn.getInstance("key1");
		Resource res2 = ResourceMultitonn.getInstance("key1");
		Resource res3 = ResourceMultitonn.getInstance("key3");
		Resource res4 = ResourceMultitonn.getInstance("key4");

		System.out.println(res1 == res2); // true
		System.out.println(res2 == res3); // false
		System.out.println(res3 == res4); // false
	}
}