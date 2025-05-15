package com.sg00170.delivery.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class RequestResponseLoggingFilter extends OncePerRequestFilter {

    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        ContentCachingRequestWrapper cachingRequest = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper cashingResponse = new ContentCachingResponseWrapper(response);

        long start = System.currentTimeMillis();

        try {
            filterChain.doFilter(cachingRequest, response);
        } finally {
            long duration = System.currentTimeMillis() - start;

            String method = request.getMethod();
            String uri = request.getRequestURI();
            String query = request.getQueryString();
            String fullUri = (query != null) ? uri + "?" + query : uri;

            String requestBody = getBody(cachingRequest.getContentAsByteArray());
            String responseBody = getBody(cashingResponse.getContentAsByteArray());
            int status = response.getStatus();

            log.info("""
                ✅ [{}] {} ({} ms)
                ➡️ Request: {}
                ⬅️ Response [{}]: {}
                """,
                    method, fullUri, duration,
                    requestBody,
                    status, responseBody
            );

            cashingResponse.copyBodyToResponse();
        }
    }

    private String getBody(byte[] content) {
        if (content == null || content.length == 0) return "<empty>";
        return new String(content, StandardCharsets.UTF_8);
    }
}
