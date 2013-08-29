package com.fourthsource.timesheets.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
@Table(name = 'TIMESHEETS')
class Timesheet {

    @Id
    @Column(name = 'TIMESHEET_ID')
    @GeneratedValue
    Integer id

    @Column(name = 'WEEK_ENDING', nullable = false)
    @Temporal(TemporalType.DATE)
    Calendar weekEnding

    @ManyToOne
    @JoinColumn(name = 'RESOURCE_ID', nullable = false)
    Resource resource


    List<BillableTime> billableTimes

}
