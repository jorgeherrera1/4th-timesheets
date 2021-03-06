package com.fourthsource.timesheets.model

import com.google.common.base.Objects

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = 'projects')
class Project {

    @Id
    @Column(name = 'project_id')
    @GeneratedValue
    Integer id

    @Column(name = 'name', nullable = false, unique = true, length = 64)
    String name

    @Column(name = 'manager_name', length = 32)
    String manager

    @Override
    boolean equals(Object obj) {
        if (obj?.is(this)) {
            return true
        }

        if (!(obj instanceof Project)) {
            return false
        }

        Project that = obj as Project

        Objects.equal(this.id, that.id) &&
                Objects.equal(this.name, that.name) &&
                Objects.equal(this.manager, that.manager)
    }

    @Override
    int hashCode() {
        Objects.hashCode(id, name, manager)
    }

    @Override
    String toString() {
        "Project {id: $id, name: $name, manager: $manager}"
    }
}
