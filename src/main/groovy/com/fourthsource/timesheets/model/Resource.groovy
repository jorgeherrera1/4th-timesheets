package com.fourthsource.timesheets.model

import com.google.common.base.Objects

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = 'RESOURCES')
class Resource {

    @Id
    @Column(name = 'RESOURCE_ID')
    @GeneratedValue
    Integer id

    @Column(name = 'RESOURCE_NAME', nullable = false, unique = true, length = 32)
    String name

    @Column(name = 'RESOURCE_LEAD', nullable = false, unique = true, length = 32)
    String lead

    @Override
    boolean equals(Object obj) {
        if (obj?.is(this)) {
            return true
        }

        if (!(obj instanceof Resource)) {
            return false
        }

        Resource that = obj as Resource

        Objects.equal(this.id, that.id) &&
                Objects.equal(this.name, that.name) &&
                Objects.equal(this.lead, that.lead)
    }

    @Override
    int hashCode() {
        Objects.hashCode(id, name, lead)
    }

    @Override
    String toString() {
        "Resource {id: $id, name: $name, lead: $lead}"
    }

}
