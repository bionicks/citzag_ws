package com.citzag.utils;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CORSFilter implements Filter {

	public CORSFilter() { }

	public void init(FilterConfig fConfig) throws ServletException { }

	public void destroy() {	}

	public void doFilter(
			
		ServletRequest request, ServletResponse response, 
		FilterChain chain) throws IOException, ServletException {

		((HttpServletResponse)response).addHeader(
			"Access-Control-Allow-Origin", "*"
		);
		((HttpServletResponse)response).addHeader(
				"Access-Control-Expose-Headers", "Air41-Status,Air41-Error,apiKey,langCode"
			);
		
	//	System.out.println("CORS FILTER");
		
		chain.doFilter(request, response);
	}
}