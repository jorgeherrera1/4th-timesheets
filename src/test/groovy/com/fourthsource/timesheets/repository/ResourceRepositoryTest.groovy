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

    @Test
    void "should find resource by email"() {
        resourceRepository.save(new Resource(name: 'Jorge Herrera', email: 'jorge.herrera@4thsource.com'))

        def resource = resourceRepository.findByEmail('jorge.herrera@4thsource.com')

        assert resource.name == 'Jorge Herrera'
    }

}
