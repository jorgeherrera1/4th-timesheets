package com.fourthsource.timesheets.repository

import com.fourthsource.timesheets.model.BillableTime
import org.springframework.data.jpa.repository.JpaRepository

interface BillableTimeRepository extends JpaRepository<BillableTime, Integer> {

}
