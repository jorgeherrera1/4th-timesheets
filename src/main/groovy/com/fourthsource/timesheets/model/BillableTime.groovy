package com.fourthsource.timesheets.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
@Table(name = 'billable_time')
class BillableTime {

    @Id
    @Column(name = 'billable_time_id')
    @GeneratedValue
    Integer id

    @OneToOne
    @JoinColumn(name = 'task_id', nullable = false)
    Task task

    @Column(name = 'date', nullable = false)
    @Temporal(TemporalType.DATE)
    Calendar date

    @Column(name = 'time')
    Short time = 0

    @Column(name = 'overtime')
    Short overtime = 0

    @ManyToOne
    @JoinColumn(name = 'timesheet_id')
    Timesheet timesheet

}
