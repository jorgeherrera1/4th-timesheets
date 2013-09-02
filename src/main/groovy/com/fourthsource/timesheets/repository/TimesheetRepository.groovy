package com.fourthsource.timesheets.repository

import com.fourthsource.timesheets.model.Timesheet
import org.springframework.data.jpa.repository.JpaRepository

interface TimesheetRepository extends JpaRepository<Timesheet, Integer> {

}
