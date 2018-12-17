package com.newrelic.fit;

public class TestMain {

	public static void main(String[] args) {
		String cont = "/content/v4/hubs/series/a67a233c-fcfe-4e8e-b000-052603ddd616";
	    int pos = cont.indexOf('/');
	    int n = 0;
	    while (n++ < 4 && pos != -1) {
	        pos = cont.indexOf('/', pos + 1);
	    }
	    if (pos == -1) {
	        System.out.println(cont);
	    } else {
	        System.out.println(cont.substring(0, pos));
	    }
	}

}
