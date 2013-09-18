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
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity
@Table(name = 'timesheets',
        uniqueConstraints = @UniqueConstraint(columnNames = ['week_ending', 'resource_id']))
class Timesheet {

    @Id
    @Column(name = 'timesheet_id')
    @GeneratedValue
    Integer id

    @Column(name = 'week_ending', nullable = false)
    @Type(type='org.joda.time.contrib.hibernate.PersistentLocalDate')
    LocalDate weekEnding

    @ManyToOne
    @JoinColumn(name = 'resource_id', nullable = false)
    Resource resource

    @OneToMany(mappedBy = 'timesheet')
    List<BillableTime> billableTimes

    @Override
    boolean equals(Object obj) {
        if (obj?.is(this)) {
            return true
        }

        if (!(obj instanceof Timesheet)) {
            return false
        }

        Timesheet that = obj as Timesheet

        Objects.equal(this.id, that.id) &&
                Objects.equal(this.weekEnding, that.weekEnding) &&
                Objects.equal(this.resource?.id, that.resource?.id) &&
                Objects.equal(this.billableTimes, that.billableTimes)
    }

    @Override
    int hashCode() {
        Objects.hashCode(id, weekEnding, resource?.id, billableTimes)
    }

    @Override
    String toString() {
        "Timesheet {id: $id, weekEnding: $weekEnding, resource: $resource.name}"
    }
}
