package com.fourthsource.timesheets.controller

import com.fourthsource.timesheets.dto.ResourceDTO
import com.fourthsource.timesheets.dto.TimesheetDTO
import com.fourthsource.timesheets.service.TimesheetService
import org.joda.time.LocalDate
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

import javax.servlet.http.HttpServletRequest

@Controller
class TimesheetController {

    static final Logger logger = LoggerFactory.getLogger(TimesheetController)

    @Autowired
    TimesheetService timesheetService

    @ModelAttribute('resource')
    ResourceDTO loggedInResource(HttpServletRequest httpRequest) {
        httpRequest.getAttribute('resource')
    }

    @RequestMapping(value = '/timesheet/{year}/{month}/{day}', method = RequestMethod.GET)
    @ResponseBody TimesheetDTO timesheetForWeekEnding(@ModelAttribute('resource') ResourceDTO resource,
                                                      @PathVariable Integer year,
                                                      @PathVariable Integer month,
                                                      @PathVariable Integer day) {
        LocalDate weekEnding = new LocalDate(year, month, day)
        TimesheetDTO timesheetDTO = timesheetService.timesheetForWeekEnding(resource, weekEnding)

        return timesheetDTO
    }

}
