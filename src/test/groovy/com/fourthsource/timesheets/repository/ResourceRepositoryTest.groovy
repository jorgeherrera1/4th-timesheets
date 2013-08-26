package com.fourthsource.timesheets.repository

import com.fourthsource.timesheets.model.Resource
import com.fourthsource.timesheets.test.TransactionalTest
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

class ResourceRepositoryTest extends TransactionalTest {

    @Autowired
    ResourceRepository resourceRepository

    @Test
    void "should save resource"() {
        def resource = new Resource(name: 'Smithers', lead: 'Mr. Burns')

        resource = resourceRepository.save(resource)

        assert resource.id != null
        assert resource == resourceRepository.findOne(resource.id)
    }

}
