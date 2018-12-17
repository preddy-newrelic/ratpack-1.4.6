package com.newrelic.ratpack.exec;

import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import ratpack.exec.Promise;
import ratpack.func.Factory;

//@Weave (type=MatchType.BaseClass,originalName="ratpack.exec.Blocking")
public abstract class Blocking_Intrument<T> {

	  public static <T> Promise<T> get(Factory<T> factory) {
			Promise<T> ret =Weaver.callOriginal();
			return ret;
	  }
	  
	  public static <T> T on(Promise<T> promise) throws Exception {
		  	T ret = Weaver.callOriginal();
			return ret;	
	  }
		  
}
