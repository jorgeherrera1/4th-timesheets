package com.fourthsource.timesheets.repository

import com.fourthsource.timesheets.model.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository extends JpaRepository<Task, Integer> {

}
