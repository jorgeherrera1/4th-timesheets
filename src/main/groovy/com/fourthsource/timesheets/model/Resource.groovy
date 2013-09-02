package com.fourthsource.timesheets.model

import com.google.common.base.Objects

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = 'resources')
class Resource {

    @Id
    @Column(name = 'resource_id')
    @GeneratedValue
    Integer id

    @Column(name = 'name', nullable = false, length = 32)
    String name

    @Column(name = 'email', nullable = false, unique = true, length = 64)
    String email

    @Column(name = 'lead_name', length = 32)
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
                Objects.equal(this.email, that.email) &&
                Objects.equal(this.lead, that.lead)
    }

    @Override
    int hashCode() {
        Objects.hashCode(id, name, email, lead)
    }

    @Override
    String toString() {
        "Resource {id: $id, name: $name, email: $email, lead: $lead}"
    }

}
