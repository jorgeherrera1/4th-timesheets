package com.fourthsource.timesheets.security

import com.google.common.base.Preconditions
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.web.filter.GenericFilterBean

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

class AuthenticationTokenFilter extends GenericFilterBean {

    AuthenticationManager authenticationManager

    UserDetailsService userDetailsService

    @Override
    void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        def httpRequest = request as HttpServletRequest
        def authenticationToken = httpRequest.getHeader('Auth-Token')
        def username = AuthenticationUtils.getUsernameFromToken(authenticationToken)

        Preconditions.checkNotNull(username)

        def userDetails = userDetailsService.loadUserByUsername(username)

        if (AuthenticationUtils.isValidToken(authenticationToken, userDetails)) {
            def authentication = new UsernamePasswordAuthenticationToken(userDetails.username, userDetails.password)
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest))
            SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(authentication))
        }

        chain.doFilter(request, response)
    }
}
