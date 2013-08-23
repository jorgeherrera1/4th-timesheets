package com.fourthsource.timesheets.model;

import org.junit.Before
import org.junit.Test

class ResourceTest {

    Resource resource

    @Before
    void "create new resource"() {
        resource = new Resource()
    }

    @Test
    void "should return project id"() {
        resource.id = 1234

        assert resource.id == 1234
    }

    @Test
    void "should return resource name"() {
        resource.name = 'Jorge Herrera'

        assert resource.name == 'Jorge Herrera'
    }

    @Test
    void "should return resource lead"() {
        resource.lead = 'God'

        assert resource.lead == 'God'
    }

    @Test
    void "equals should be true if object is same"() {
        def otherResource = resource

        assert resource == otherResource
    }

    @Test
    void "equals should be false if object is null"() {
        assert resource != null
    }

    @Test
    void "equals should be false if resources are different"() {
        resource.id = 1234
        resource.name = 'Jorge Herrera'
        resource.lead = 'God'

        def otherResource = new Resource(id: 5678, name: 'Bart Simpson', lead: 'Homer Simpson')

        assert resource != otherResource
    }

    @Test
    void "equals should be true if resources are identical"() {
        resource.id = 1234
        resource.name = 'Jorge Herrera'
        resource.lead = 'God'

        def otherResource = new Resource(id: 1234, name: 'Jorge Herrera', lead: 'God')

        assert resource == otherResource
    }

    @Test
    void "hash code should be different for different resources"() {
        resource.id = 1234
        resource.name = 'Jorge Herrera'
        resource.lead = 'God'

        def otherResource = new Resource(id: 5678, name: 'Bart Simpson', lead: 'Homer Simpson')

        assert resource.hashCode() != otherResource.hashCode()
    }

    @Test
    void "hash code should be equal for identical resources"() {
        resource.id = 1234
        resource.name = 'Jorge Herrera'
        resource.lead = 'God'

        def otherResource = new Resource(id: 1234, name: 'Jorge Herrera', lead: 'God')

        assert resource.hashCode() == otherResource.hashCode()
    }

}
