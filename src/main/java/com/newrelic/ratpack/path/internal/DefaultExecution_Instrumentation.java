package com.newrelic.ratpack.path.internal;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import ratpack.exec.internal.Continuation;
import ratpack.func.Action;

//@Weave(type=MatchType.ExactClass, originalName = "ratpack.exec.internal.DefaultExecution")
public class DefaultExecution_Instrumentation {

	//@Trace(dispatcher=true)
    public void delimit(Action<? super Throwable> onError, Action<? super Continuation> segment) {
        Weaver.callOriginal();
    }

}
