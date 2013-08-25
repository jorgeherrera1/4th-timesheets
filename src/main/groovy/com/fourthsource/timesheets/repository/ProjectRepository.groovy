package com.fourthsource.timesheets.repository

import com.fourthsource.timesheets.model.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository extends JpaRepository<Project, Integer> {

}
