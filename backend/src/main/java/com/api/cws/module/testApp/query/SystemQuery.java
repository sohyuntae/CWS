package com.api.cws.module.testApp.query;


import com.api.cws.domain.Qstm_info;
import com.api.cws.domain.stm_info;
import com.api.cws.module.testApp.dto.SystemDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@GraphQLApi
@RequiredArgsConstructor
public class SystemQuery {
    private final JPAQueryFactory queryFactory;

    @GraphQLQuery(description = "시스템 조회")
    public List<SystemDto> getSystem() {
        List<stm_info> domainList = queryFactory
                .selectFrom(Qstm_info.stm_info)
                .where(Qstm_info.stm_info.guKey.isNotNull())
                .fetch();

        return domainList
                .stream()
                .map(domain -> {
                    SystemDto system = new SystemDto();
                    system.setSystemKey(domain.getSiKey());
                    system.setGroupKey(domain.getOgKey());
                    system.setGroupUserKey(domain.getGuKey());
                    system.setSystemName(domain.getSiNm());
                    return system;
                })
                .collect(Collectors.toList());
    }
}
