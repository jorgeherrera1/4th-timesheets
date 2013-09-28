package com.fourthsource.timesheets.security

import com.fourthsource.timesheets.dto.ResourceDTO
import org.springframework.web.filter.GenericFilterBean

import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

class AuthenticationTokenFilter extends GenericFilterBean {

    @Override
    void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        def httpRequest = request as HttpServletRequest

        def resource = new ResourceDTO()
        resource.name = 'Jorge Herrera'
        resource.email = 'jorge.herrera@4thsource.com'

        httpRequest.setAttribute('resource', resource)

        chain.doFilter(request, response)
    }
}
