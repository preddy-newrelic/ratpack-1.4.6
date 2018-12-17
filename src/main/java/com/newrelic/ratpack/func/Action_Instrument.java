package com.newrelic.ratpack.func;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;

@Weave(type = MatchType.Interface, originalName = "ratpack.func.Action")
public abstract class Action_Instrument<T> {

	@Trace
	public abstract void execute(T t) throws Exception;

}
