package com.fourthsource.timesheets.security

import com.google.common.base.Joiner
import org.joda.time.DateTime
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.StandardPasswordEncoder

class AuthenticationUtils {

    static final StandardPasswordEncoder passwordEncoder = new StandardPasswordEncoder('secret')

    static String newTokenForUser(UserDetails userDetails) {
        def expires = new DateTime().plusHours(1).millis
        def hash = newHashForUser(userDetails, expires)
        def tokenParts = [userDetails.username, expires, hash].toArray()
        def token = Joiner.on(':').join(tokenParts)

        token
    }

    static String newHashForUser(UserDetails userDetails, long expires) {
        def hashParts = [userDetails.username, userDetails.password, expires].toArray()
        def hashStr = Joiner.on(':').join(hashParts)
        def hash = passwordEncoder.encode(hashStr)

        hash
    }

    static String getUsernameFromToken(String token) {
        def username = token.split(':')[0]

        username
    }

    static boolean isValidToken(String token, UserDetails userDetails) {
        def parts = token.split(':')
        def expires = Long.parseLong(parts[1])
        def hash = parts[2]

        if (expires < System.currentTimeMillis()) {
            return false;
        }

        return hash == newHashForUser(userDetails, expires)
    }

}
