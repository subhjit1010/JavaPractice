package com.subhjit.test;

import java.lang.reflect.Constructor;
import java.util.HashMap;

public class SingletonUsingReflection {
	public static void main(String args[]) {
		EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
		EagerInitializedSingleton instanceTwo = null;
		try {
			Constructor[] cunstructors =EagerInitializedSingleton.class.getConstructors();
			for(Constructor cunstructor :cunstructors ) {
				cunstructor.setAccessible(true);
				instanceTwo= (EagerInitializedSingleton) cunstructor.newInstance();
				//System.out.println("Two"+instanceTwo.hashCode()+"\n");
				/*HashMap<A, A> tes = new HashMap<A, A>();
				tes.put(new B(), new B());*/
				break;
				
				
			}
		}catch(Exception e) {
			e.getMessage();
		}
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
	}

}

class EagerInitializedSingleton{
	private static EagerInitializedSingleton instance=null;
	private EagerInitializedSingleton() {}
	public static EagerInitializedSingleton getInstance() {
		if(instance==null) {
			synchronized(EagerInitializedSingleton.class) {
				if(instance==null) {
					instance = new EagerInitializedSingleton();
				}
			}
		}
		return instance;
	}
}
