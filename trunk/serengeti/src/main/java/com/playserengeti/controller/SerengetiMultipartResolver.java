package com.playserengeti.controller;

import org.springframework.web.servlet.mvc.multiaction.InternalPathMethodNameResolver;

public class SerengetiMultipartResolver extends InternalPathMethodNameResolver {

    @Override
    protected String extractHandlerMethodNameFromUrlPath(String uri) {
        String methodName = super.extractHandlerMethodNameFromUrlPath(uri);
        return methodName.isEmpty() ? "central" : methodName;
    }
}
