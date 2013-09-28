package com.fourthsource.timesheets.service

import com.fourthsource.timesheets.common.Timesheets
import com.fourthsource.timesheets.dto.ResourceDTO
import com.fourthsource.timesheets.dto.TimesheetDTO
import com.fourthsource.timesheets.model.Resource
import com.fourthsource.timesheets.model.Timesheet
import com.fourthsource.timesheets.repository.ResourceRepository
import com.fourthsource.timesheets.repository.TimesheetRepository
import org.joda.time.LocalDate
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TimesheetServiceImpl implements TimesheetService {

    static final Logger logger = LoggerFactory.getLogger(TimesheetServiceImpl)

    @Autowired
    TimesheetRepository timesheetRepository

    @Autowired
    ResourceRepository resourceRepository

    @Transactional(readOnly = true)
    TimesheetDTO timesheetForWeekEnding(ResourceDTO resourceDTO, LocalDate weekEnding) {
        logger.debug("Retrieving timesheet of ${resourceDTO.name} corresponding to week ending ${weekEnding}")

        Resource resource = resourceRepository.findByEmail(resourceDTO.email)
        Timesheet timesheet = timesheetRepository.findByWeekEnding(resource, weekEnding)

        if (timesheet == null) {
            timesheet = Timesheets.newForWeekEnding(resource, weekEnding)
        }

        TimesheetDTO dto = Timesheets.toDTO(timesheet)

        dto
    }

}
