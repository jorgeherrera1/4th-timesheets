package com.fourthsource.timesheets.model

import org.joda.time.LocalDate

class BillableTime {

    Resource resource
    Project project
    String task
    LocalDate date
    Short time = 0
    Short overtime = 0

}
