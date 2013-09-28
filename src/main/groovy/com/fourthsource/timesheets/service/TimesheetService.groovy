package com.fourthsource.timesheets.service

import com.fourthsource.timesheets.dto.ResourceDTO
import com.fourthsource.timesheets.dto.TimesheetDTO
import org.joda.time.LocalDate

interface TimesheetService {

    TimesheetDTO timesheetForWeekEnding(ResourceDTO resourceDTO, LocalDate weekEnding)

}
