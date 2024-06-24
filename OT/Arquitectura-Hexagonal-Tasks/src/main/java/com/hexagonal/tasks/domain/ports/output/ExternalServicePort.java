package com.hexagonal.tasks.domain.ports.output;

import com.hexagonal.tasks.domain.models.AdditionalTasksInfo;


public interface ExternalServicePort {

    AdditionalTasksInfo getAdditionalTasksInfo(Long id);
    
}
