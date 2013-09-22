package com.fourthsource.timesheets.controller

import com.fourthsource.timesheets.dto.TimesheetDTO
import com.fourthsource.timesheets.service.TimesheetService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class TimesheetController {

    @Autowired
    TimesheetService timesheetService

    static final Logger logger = LoggerFactory.getLogger(TimesheetController)

    @RequestMapping(value = '/timesheet/{year}/{month}/{day}', method = RequestMethod.GET)
    @ResponseBody TimesheetDTO timesheetForWeekEnding(@PathVariable String year,
                                                      @PathVariable String month,
                                                      @PathVariable String day) {
        logger.debug("Timesheet for week ending ${year}/${month}/${day}")

        return new TimesheetDTO(weekEnding: '9/21/2013', totalTime: 15, totalOvertime: 0)
    }

}
