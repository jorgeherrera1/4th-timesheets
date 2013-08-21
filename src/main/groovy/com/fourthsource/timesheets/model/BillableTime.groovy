package com.fourthsource.timesheets.model

import org.joda.time.LocalDate

class BillableTime {

    Resource resource
    Project project
    LocalDate date
    Short hours
    Short overtime

}
