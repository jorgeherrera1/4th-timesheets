package com.fourthsource.timesheets.model

import com.google.common.base.Objects

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = 'tasks')
class Task {

    @Id
    @Column(name = 'task_id')
    @GeneratedValue
    Integer id

    @Column(name = 'name', nullable = false, unique = true, length = 64)
    String name

    @ManyToOne
    @JoinColumn(name = 'project_id')
    Project project

    @Override
    boolean equals(Object obj) {
        if (obj?.is(this)) {
            return true
        }

        if (!(obj instanceof Task)) {
            return false
        }

        Task that = obj as Task

        Objects.equal(this.id, that.id) &&
                Objects.equal(this.name, that.name) &&
                Objects.equal(this.project?.id, that.project?.id)
    }

    @Override
    int hashCode() {
        Objects.hashCode(id, name, project?.id)
    }

    @Override
    String toString() {
        "Task {id: $id, name: $name, project: $project.name}"
    }

}
