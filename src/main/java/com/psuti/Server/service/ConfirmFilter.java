package com.psuti.Server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ConfirmFilter extends OncePerRequestFilter {
    private final VerificationService verificationService;
    private final UserCrudService userCrudService;
    @Autowired
    public ConfirmFilter(VerificationService verificationService, UserCrudService userCrudService) {
        this.verificationService = verificationService;
        this.userCrudService = userCrudService;
    }
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getRequestURI().equals("/auth/reg/mail/confirm");
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean shouldRemove = verificationService.shouldRemove(username);
        if (shouldRemove) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "TOKEN EXPIRED");
        }
        filterChain.doFilter(request, response);
        if (shouldRemove) {
            userCrudService.removeByUsername(username);
        }
    }
}

