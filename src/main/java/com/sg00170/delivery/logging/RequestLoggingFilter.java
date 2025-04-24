package com.sg00170.delivery.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        ContentCachingRequestWrapper cachingRequest = new ContentCachingRequestWrapper(request);
        filterChain.doFilter(cachingRequest, response);
        logRequest(cachingRequest);
    }

    private void logRequest(ContentCachingRequestWrapper request) {
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        String fullUri = (queryString != null) ? uri + "?" + queryString : uri;

        String requestBody = "";
        byte[] content = request.getContentAsByteArray();
        if (content.length > 0) {
            requestBody = new String(content, StandardCharsets.UTF_8);
        }

        log.info("➡️ {} {}\n Body: {}", method, fullUri, requestBody);
    }
}
