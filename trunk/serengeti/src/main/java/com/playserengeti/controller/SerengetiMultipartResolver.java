package com.playserengeti.controller;

import org.springframework.web.servlet.mvc.multiaction.InternalPathMethodNameResolver;

/**
 * An extension of InternalPathMethodNameResolver to deal with the case when the
 * method name is blank. Defaults to the central method when blank.
 */
public class SerengetiMultipartResolver extends InternalPathMethodNameResolver {

	@Override
	protected String extractHandlerMethodNameFromUrlPath(String uri) {
		String methodName = super.extractHandlerMethodNameFromUrlPath(uri);
		return methodName.isEmpty() ? "central" : methodName;
	}
}
