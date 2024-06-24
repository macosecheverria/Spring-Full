package com.hexagonal.tasks.domain.ports.input;

import com.hexagonal.tasks.domain.models.AdditionalTasksInfo;

public interface GetAdditionalTaskInfoUseCase {
    AdditionalTasksInfo getAdditionalTasksInfo(Long id);
}
