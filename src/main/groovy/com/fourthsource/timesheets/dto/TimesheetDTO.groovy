package com.fourthsource.timesheets.dto

class TimesheetDTO {

    String weekEnding
    Short totalTime
    Short totalOvertime

    @Override
    String toString() {
        "TimesheetDTO {weekEnding: ${weekEnding}, totalTime: ${totalTime}, totalOvertime: ${totalOvertime}}"
    }
}
