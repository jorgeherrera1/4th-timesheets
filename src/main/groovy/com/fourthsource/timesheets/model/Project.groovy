package com.fourthsource.timesheets.model

import com.google.common.base.Objects

class Project {

    Integer id
    String name
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
