package com.fourthsource.timesheets.repository

import com.fourthsource.timesheets.model.Project
import com.fourthsource.timesheets.test.TransactionalTest
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

class ProjectRepositoryTest extends TransactionalTest {

    @Test
    void "should save project"() {
        def project = new Project(name: '4th-timesheets', manager: 'Jorge Herrera')

        project = projectRepository.save(project)

        assert project.id != null
        assert project == projectRepository.findOne(project.id)
    }

}
