package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.models.AdditionalTasksInfo;
import com.hexagonal.tasks.domain.ports.input.GetAdditionalTaskInfoUseCase;
import com.hexagonal.tasks.domain.ports.output.ExternalServicePort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final ExternalServicePort externalServicePort;

    @Override
    public AdditionalTasksInfo getAdditionalTasksInfo(Long id) {
        return this.externalServicePort.getAdditionalTasksInfo(id);
    }

}
