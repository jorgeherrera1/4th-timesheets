package com.fourthsource.timesheets.service

import com.fourthsource.timesheets.dto.ResourceDTO
import com.fourthsource.timesheets.repository.ResourceRepository
import com.google.common.base.Preconditions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TimesheetServiceImpl implements TimesheetService {

    @Autowired
    ResourceRepository resourceRepository

    @Transactional(readOnly = true)
    ResourceDTO findResourceByEmail(String email) {
        Preconditions.checkNotNull(email, 'Email cannot be null')

        def resource = resourceRepository.findByEmail(email)
        def dto = new ResourceDTO(name: resource.name, email: resource.email)

        dto
    }

}
