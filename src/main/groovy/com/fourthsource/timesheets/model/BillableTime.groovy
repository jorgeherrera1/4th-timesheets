package com.fourthsource.timesheets.model

import com.google.common.base.Objects
import org.hibernate.annotations.Type
import org.joda.time.LocalDate

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table

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
    @Type(type='org.joda.time.contrib.hibernate.PersistentLocalDate')
    LocalDate date

    @Column(name = 'time')
    Short time = 0

    @Column(name = 'overtime')
    Short overtime = 0

    @ManyToOne
    @JoinColumn(name = 'timesheet_id')
    Timesheet timesheet

    @Override
    boolean equals(Object obj) {
        if (obj?.is(this)) {
            return true
        }

        if (!(obj instanceof BillableTime)) {
            return false
        }

        BillableTime that = obj as BillableTime

        Objects.equal(this.id, that.id) &&
                Objects.equal(this.task, that.task) &&
                Objects.equal(this.date, that.date) &&
                Objects.equal(this.time, that.time) &&
                Objects.equal(this.overtime, that.overtime) &&
                Objects.equal(this.timesheet?.id, that.timesheet?.id)
    }

    @Override
    int hashCode() {
        Objects.hashCode(id, task, date, time, overtime, timesheet?.id)
    }

    @Override
    String toString() {
        "BillableTime {id: $id, task: $task.name, date: $date, time: $time, timesheet: $timesheet.weekEnding}"
    }
}
