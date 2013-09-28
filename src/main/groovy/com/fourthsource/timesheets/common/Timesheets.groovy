package com.fourthsource.timesheets.common

import com.fourthsource.timesheets.dto.TimesheetDTO
import com.fourthsource.timesheets.model.Resource
import com.fourthsource.timesheets.model.Timesheet
import org.joda.time.LocalDate

final class Timesheets {

    static final Timesheet newForWeekEnding(Resource resource, LocalDate weekEnding) {
        def timesheet = new Timesheet()
        timesheet.resource = resource
        timesheet.weekEnding = weekEnding

        timesheet
    }

    static final TimesheetDTO toDTO(Timesheet timesheet) {
        if (timesheet == null) {
            return null
        }

        TimesheetDTO dto = new TimesheetDTO()
        dto.weekEnding = timesheet.weekEnding.toString('MM/dd/yyyy')
        dto.totalTime = 0
        dto.totalOvertime = 0

        timesheet.billableTimes?.each { time ->
            dto.totalTime += time.time
            dto.totalOvertime += time.overtime
        }

        dto
    }

}
