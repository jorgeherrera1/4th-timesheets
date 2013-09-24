package com.fourthsource.timesheets.service

import com.fourthsource.timesheets.repository.TimesheetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TimesheetServiceImpl implements TimesheetService {

    @Autowired
    TimesheetRepository timesheetRepository

}
