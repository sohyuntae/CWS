package com.api.cws.module.testApp.dto;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemDto {
    @GraphQLQuery(description = "시스템 key")
    private Long systemKey;
    @GraphQLQuery(description = "그룹 key")
    private Long groupKey;
    @GraphQLQuery(description = "그룹 사용자 key")
    private Long groupUserKey;
    @GraphQLQuery(description = "시스템명")
    private String systemName;
}
