package com.fourthsource.timesheets.model

import org.junit.Before
import org.junit.Test

class ProjectTest {

    Project project

    @Before
    void "create new project"() {
        project = new Project()
    }

    @Test
    void "should return project id"() {
        project.id = 1000

        assert project.id == 1000
    }

    @Test
    void "should return project name"() {
        project.name = '4th-timesheets'

        assert project.name == '4th-timesheets'
    }

    @Test
    void "should return manager of project"() {
        project.manager = 'Jorge Herrera'

        assert project.manager == 'Jorge Herrera'
    }

    @Test
    void "equals should be true if object is same"() {
        def otherProject = project

        assert project == otherProject
    }

    @Test
    void "equals should be false if object is null"() {
        assert project != null
    }

    @Test
    void "equals should be false if projects are different"() {
        project.id = 1000
        project.name = '4th-timesheets'
        project.manager = 'Jorge Herrera'

        def otherProject = new Project(id: 1001, name: '4th-interview', manager: 'Jorge Herrera')

        assert project != otherProject
    }

    @Test
    void "equals should be true if projects are identical"() {
        project.id = 1000
        project.name = '4th-timesheets'
        project.manager = 'Jorge Herrera'

        def otherProject = new Project(id: 1000, name: '4th-timesheets', manager: 'Jorge Herrera')

        assert project == otherProject
    }

    @Test
    void "hash code should be different for different projects"() {
        project.id = 1000
        project.name = '4th-timesheets'
        project.manager = 'Jorge Herrera'

        def otherProject = new Project(id: 1001, name: '4th-interview', manager: 'Jorge Herrera')

        assert project.hashCode() != otherProject.hashCode()
    }

    @Test
    void "hash code should be equal for identical projects"() {
        project.id = 1000
        project.name = '4th-timesheets'
        project.manager = 'Jorge Herrera'

        def otherProject = new Project(id: 1000, name: '4th-timesheets', manager: 'Jorge Herrera')

        assert project.hashCode() == otherProject.hashCode()
    }

}
