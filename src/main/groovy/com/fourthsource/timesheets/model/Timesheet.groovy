package com.fourthsource.timesheets.model

import org.joda.time.LocalDate

class Timesheet {

    Resource resource
    LocalDate weekEnding
    List<BillableTime> billableTimes

}
