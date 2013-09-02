package com.fourthsource.timesheets.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
@Table(name = 'timesheets')
class Timesheet {

    @Id
    @Column(name = 'timesheet_id')
    @GeneratedValue
    Integer id

    @Column(name = 'week_ending', nullable = false)
    @Temporal(TemporalType.DATE)
    Calendar weekEnding

    @ManyToOne
    @JoinColumn(name = 'resource_id', nullable = false)
    Resource resource

    @OneToMany(mappedBy = 'timesheet')
    List<BillableTime> billableTimes

}
