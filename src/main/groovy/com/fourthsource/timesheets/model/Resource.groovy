package com.fourthsource.timesheets.model

import com.google.common.base.Objects

class Resource {

    Integer id
    String name
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
