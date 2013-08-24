package com.fourthsource.timesheets.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@Controller
class LoginController {

    static final Logger logger = LoggerFactory.getLogger(LoginController)

    AuthenticationManager authenticationManager

    @RequestMapping(value = '/login', method = RequestMethod.POST)
    void login(@RequestParam('username') String username, @RequestParam('password') String password) {
        logger.info("User $username is logging in...")

        def authenticationToken = new UsernamePasswordAuthenticationToken(username, password)
        def authentication = authenticationManager.authenticate(authenticationToken)
    }

}
