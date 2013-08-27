package com.fourthsource.timesheets.service

import com.fourthsource.timesheets.dto.ResourceDTO

interface TimesheetService {

    ResourceDTO findResourceByEmail(String email)

}
