package com.fourthsource.timesheets.controller

import com.fourthsource.timesheets.dto.ResourceDTO
import com.fourthsource.timesheets.model.Resource
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(value = "/resource")
class ResourceController {

    static final Logger logger = LoggerFactory.getLogger(ResourceController)

    @Autowired
    UserDetailsService userDetailsService

    @Autowired
    AuthenticationManager authenticationManager

    @RequestMapping(value = '/login', method = RequestMethod.POST)
    @ResponseBody Resource login(@RequestParam('username') String username, @RequestParam('password') String password) {
        logger.info("User $username is logging in...")

        def authenticationToken = new UsernamePasswordAuthenticationToken(username, password)
        def authentication = authenticationManager.authenticate(authenticationToken)

        SecurityContextHolder.getContext().setAuthentication(authentication);


        new ResourceDTO(name: 'Jorge Herrera', email: 'jorge@mail.com', token: 'abc123')
    }

}
