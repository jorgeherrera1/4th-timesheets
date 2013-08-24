package com.fourthsource.timesheets.model

import org.joda.time.LocalDate
import org.junit.Before
import org.junit.Test

class BillableTimeTest {

    BillableTime billableTime

    @Before
    void "create new billable time"() {
        billableTime = new BillableTime()
    }

    @Test
    void "should return billable project"() {
        billableTime.project = new Project(name: '4th-timesheets')

        assert billableTime.project == new Project(name: '4th-timesheets')
    }

    @Test
    void "should return billable task"() {
        billableTime.task = 'develop something'

        assert billableTime.task == 'develop something'
    }

    @Test
    void "should return billable task date"() {
        billableTime.date = new LocalDate(2013, 8, 15)

        assert billableTime.date == new LocalDate(2013, 8, 15)
    }

    @Test
    void "should return billable time (hours)"() {
        billableTime.time = 8

        assert billableTime.time == 8
    }

    @Test
    void "billable time (hours) should default to zero"() {
        assert billableTime.time == 0
    }

    @Test
    void "should return billable overtime (hours)"() {
        billableTime.overtime = 2

        assert billableTime.overtime == 2
    }

    @Test
    void "billable overtime (hours) should default to zero"() {
        assert billableTime.overtime == 0
    }

    @Test
    void "equals should be true if object is same"() {
        def otherBillableTime = billableTime

        assert billableTime == otherBillableTime
    }

    @Test
    void "equals should be false if object is null"() {
        assert billableTime != null
    }

}
