package com.fourthsource.timesheets.test

import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.transaction.TransactionConfiguration
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration(locations = ['classpath:persistence-context.xml', 'classpath:persistence-test-context.xml'])
@TransactionConfiguration
@Transactional
class TransactionalTest extends AbstractTransactionalJUnit4SpringContextTests {



}
