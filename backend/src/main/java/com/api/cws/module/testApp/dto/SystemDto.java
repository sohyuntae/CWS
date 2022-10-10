package com.api.cws.module.testApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemDto {
    private Long systemKey;
    private Long groupKey;
    private Long groupUserKey;
    private String systemName;
}
