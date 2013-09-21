package com.fourthsource.timesheets.test

import com.fourthsource.timesheets.repository.BillableTimeRepository
import com.fourthsource.timesheets.repository.ProjectRepository
import com.fourthsource.timesheets.repository.ResourceRepository
import com.fourthsource.timesheets.repository.TaskRepository
import com.fourthsource.timesheets.repository.TimesheetRepository
import org.junit.BeforeClass
import org.junit.runner.RunWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.support.PropertiesLoaderUtils
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.mock.jndi.SimpleNamingContextBuilder
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.transaction.TransactionConfiguration
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration(locations = ['classpath:persistence-context.xml'])
@TransactionConfiguration
@Transactional
class TransactionalTest extends AbstractTransactionalJUnit4SpringContextTests {

    static final Logger logger = LoggerFactory.getLogger(getClass())

    @Autowired
    ResourceRepository resourceRepository

    @Autowired
    ProjectRepository projectRepository

    @Autowired
    TaskRepository taskRepository

    @Autowired
    TimesheetRepository timesheetRepository

    @Autowired
    BillableTimeRepository billableTimeRepository

    @BeforeClass
    static void "set up jndi test data source"() {
        logger.info('Setting up JNDI data source for testing...')

        def databaseProperties = PropertiesLoaderUtils.loadAllProperties('database.properties')

        def testDataSource = new DriverManagerDataSource()
        testDataSource.driverClassName = databaseProperties.getProperty('database.driverClassName')
        testDataSource.url = databaseProperties.getProperty('database.url')
        testDataSource.username = databaseProperties.getProperty('database.username')
        testDataSource.password = databaseProperties.getProperty('database.password')

        def jndiContextBuilder = new SimpleNamingContextBuilder()
        jndiContextBuilder.bind('java:comp/env/jdbc/jherrera', testDataSource)
        jndiContextBuilder.activate()
    }

}
