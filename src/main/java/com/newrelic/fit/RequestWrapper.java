package com.newrelic.fit;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.newrelic.api.agent.ExtendedRequest;
import com.newrelic.api.agent.HeaderType;

import ratpack.http.Request;

public class RequestWrapper extends ExtendedRequest {

	private Request request = null;

	public RequestWrapper(Request request_Instrument) {
		this.request  = request_Instrument;
	}

	@Override
	public Object getAttribute(String name) {
		return null;
	}

	@Override
	public String getCookieValue(String name) {
		return null;
	}

	@Override
	public Enumeration getParameterNames() {
		final Set<String> paramNamesSet = request.getQueryParams().keySet();
        return new Enumeration() {
            Iterator names = paramNamesSet.iterator();

            @Override
            public boolean hasMoreElements() {
                return names.hasNext();
            }

            @Override
            public Object nextElement() {
                return names.next();
            }
        };
	}

	@Override
	public String[] getParameterValues(String name) {
        Object value = request.getQueryParams().get(name);
        if (value instanceof List) {
            List inList = (List) value;
            int size = inList.size();
            String[] valArray = new String[size];

            for (int i = 0; i < size; i++) {
                valArray[i] = inList.get(i).toString();
            }

            return valArray;
        } else {
            return new String[] { value.toString() };
        }
	}

	@Override
	public String getRemoteUser() {
		return null;
	}

	@Override
	public String getRequestURI() {
		return "/" + request.getPath();
	}

	@Override
	public String getHeader(String name) {
		return request.getHeaders().get(name);
	}

	@Override
	public HeaderType getHeaderType() {
		return HeaderType.HTTP;
	}

	@Override
	public String getMethod() {
		return request.getMethod().getName();
	}

}
