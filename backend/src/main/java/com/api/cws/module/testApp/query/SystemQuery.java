package com.api.cws.module.testApp.query;


import com.api.cws.domain.Qstm_info;
import com.api.cws.domain.Qusr_info;
import com.api.cws.domain.stm_info;
import com.api.cws.domain.usr_info;
import com.api.cws.module.testApp.dto.SystemDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLEnvironment;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.execution.ResolutionEnvironment;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@GraphQLApi
@Component
@RequiredArgsConstructor
public class SystemQuery {
    private final JPAQueryFactory queryFactory;

    @GraphQLQuery(name = "system")
    @Transactional(readOnly = true)
    public List<SystemDto> getSystem() {
        List<stm_info> domainList = queryFactory
                .selectFrom(Qstm_info.stm_info)
                .fetch();

        List<usr_info> userInfoList = queryFactory
                .selectFrom(Qusr_info.usr_info)
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
