package com.fourthsource.timesheets.repository

import com.fourthsource.timesheets.model.Resource
import com.fourthsource.timesheets.test.TransactionalTest
import org.joda.time.LocalDate
import org.junit.Before
import org.junit.Test

class TimesheetRepositoryTest extends TransactionalTest {

    @Before
    void "set up data"() {
        executeSqlScript('data/projects.sql', false)
        executeSqlScript('data/resources.sql', false)
        executeSqlScript('data/tasks.sql', false)
        executeSqlScript('data/timesheets.sql', false)
    }

    @Test
    void "should find timesheet for week ending"() {
        def resource = resourceRepository.findByEmail('fbdev@facebook.com')
        def weekEnding = new LocalDate(2013, 9, 7)

        def timesheet = timesheetRepository.findByWeekEnding(resource, weekEnding)

        assert timesheet != null
    }

    @Test
    void "should not find timesheet for week ending"() {
        def resource = resourceRepository.findByEmail('fbdev@facebook.com')
        def weekEnding = new LocalDate(2023, 9, 7)

        def timesheet = timesheetRepository.findByWeekEnding(resource, weekEnding)

        assert timesheet == null
    }

}
