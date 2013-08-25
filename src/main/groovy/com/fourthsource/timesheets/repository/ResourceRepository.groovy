package com.fourthsource.timesheets.repository

import com.fourthsource.timesheets.model.Resource
import org.springframework.data.jpa.repository.JpaRepository

interface ResourceRepository extends JpaRepository<Resource, Integer> {

}
