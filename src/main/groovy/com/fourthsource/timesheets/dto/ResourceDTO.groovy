package com.fourthsource.timesheets.dto

class ResourceDTO {

    String name
    String email
    String token

    @Override
    String toString() {
        "ResourceDTO {name: $name, email: $email, token: $token}"
    }

}
