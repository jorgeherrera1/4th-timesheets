package com.fourthsource.timesheets.repository

import com.fourthsource.timesheets.model.Resource
import com.fourthsource.timesheets.model.Timesheet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TimesheetRepository extends JpaRepository<Timesheet, Integer> {

    @Query('select t from Timesheet t where t.resource = :resource and t.weekEnding = :weekEnding')
    Timesheet findByResourceAndWeekEnding(Resource resource, Calendar weekEnding)

}
