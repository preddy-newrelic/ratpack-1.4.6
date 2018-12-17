package com.newrelic.ratpack.path.internal;

import java.util.HashMap;
import java.util.Map;

import com.newrelic.api.agent.ExtendedRequest;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.Transaction;
import com.newrelic.api.agent.TransactionNamePriority;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.fit.RequestWrapper;
import com.newrelic.fit.ResponseWrapper;

import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.path.PathBinder;

@Weave(type = MatchType.ExactClass, originalName = "ratpack.path.internal.PathHandler")
public abstract class PathHandler_Instrument {
	@NewField 
	public static final String URL_PATH_SEP_CHAR = "/"; 
	
	@NewField
	private static Map<String, String> substitutionMap = null;
	
	public PathHandler_Instrument(PathBinder binder, Handler handler) {
		substitutionMap = new HashMap<String, String>();
		substitutionMap.put("hubs", "hub_id");
		substitutionMap.put("season", "season_number");
		substitutionMap.put("seasons", "season_number");
		substitutionMap.put("collections", "collection_id");
		substitutionMap.put("series", "entity_id");
		substitutionMap.put("genre", "entity_id");
	}

	@Trace(dispatcher = true)
	public void handle(Context ctx) {
		String nrPath = ctx.getRequest().getPath();
		try {
			StringBuffer newPath = new StringBuffer();
			String[] pathBits = nrPath.split(URL_PATH_SEP_CHAR);
			String prevKey = "";
			for (int i = 0; i < pathBits.length; i++) {
				String pathBit = pathBits[i];
				if (substitutionMap.containsKey(prevKey)) {
					if (!substitutionMap.containsKey(pathBit)) {
						pathBit = substitutionMap.getOrDefault(prevKey, pathBit);
					}
				}
				newPath.append("-").append(pathBit);
				prevKey = pathBits[i];
			}
			nrPath = newPath.substring(1, newPath.length());
		} catch (Throwable t) {
		}
		// Wrap the Request object
		ExtendedRequest request = new RequestWrapper(ctx.getRequest());
		Transaction txn = NewRelic.getAgent().getTransaction();
		txn.setTransactionName(TransactionNamePriority.FRAMEWORK_HIGH, true, "ratpack",
				nrPath);
		NewRelic.addCustomParameter("urlPath", nrPath);
		//System.out.println("Setting txn name = "+ nrPath);

		Weaver.callOriginal();
		
		ResponseWrapper response = new ResponseWrapper(ctx.getResponse());
		NewRelic.setRequestAndResponse(request, response);
	}
}
