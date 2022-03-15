package com.LewisCloud.common.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddWorker {
    private int projectId;
    private int workerId;
}
