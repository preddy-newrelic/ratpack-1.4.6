package com.newrelic.ratpack.exec;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.ratpack.func.Action_Instrument;

//@Weave (type=MatchType.Interface,originalName="ratpack.exec.ExecStarter")
public abstract class ExecStarter_Instrument {
	
	//@Trace(dispatcher=true)
	public void start(Action_Instrument<? super Execution_Instrument> initialExecutionSegment) {
		//System.out.println("ratpack ExecStarter_Instrument - 1" + initialExecutionSegment.getClass().getName());
		Weaver.callOriginal();
	}
	
	//@Trace(dispatcher=true)
	public void start(Operation_Instrument operation) {
		//System.out.println("ratpack ExecStarter_Instrument - 2");
		Weaver.callOriginal();
	}
}
