package com.fourthsource.timesheets.repository

import com.fourthsource.timesheets.model.Resource
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ResourceRepository extends JpaRepository<Resource, Integer> {

    @Query('select r from Resource r where r.email = ?1')
    Resource findByEmail(String email)

}
