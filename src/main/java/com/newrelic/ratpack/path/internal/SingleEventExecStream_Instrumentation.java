package com.newrelic.ratpack.path.internal;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

//@Weave(type=MatchType.ExactClass, originalName = "ratpack.exec.internal.DefaultExecution$SingleEventExecStream")
class SingleEventExecStream_Instrumentation {
    
	@Trace(dispatcher=true)
    boolean exec() throws Exception {
        return Weaver.callOriginal();
    }
}
