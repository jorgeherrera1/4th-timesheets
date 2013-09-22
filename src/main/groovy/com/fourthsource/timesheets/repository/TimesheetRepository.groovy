package com.fourthsource.timesheets.repository

import com.fourthsource.timesheets.model.Resource
import com.fourthsource.timesheets.model.Timesheet
import org.joda.time.LocalDate
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface TimesheetRepository extends JpaRepository<Timesheet, Integer> {

    @Query('select t from Timesheet t where t.resource = :resource and t.weekEnding = :weekEnding')
    Timesheet findByWeekEnding(@Param('resource') Resource resource, @Param('weekEnding') LocalDate weekEnding)

}
