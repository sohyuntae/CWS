package com.api.cws.module.testApp.query;

import com.api.cws.domain.stm_info;
import com.api.cws.module.testApp.dto.SystemDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SystemQuery implements GraphQLQueryResolver {
    private final JPAQueryFactory queryFactory;

    @Transactional(readOnly = true)
    public List<SystemDto> getSystem() {
//        List<stm_info> domainList = queryFactory
//                .selectFrom(Qstm_info.stm_info)
//                .where(Qstm_info.stm_info.guKey.isNotNull())
//                .fetch();
//
//        return domainList
//                .stream()
//                .map(domain -> {
//                    SystemDto system = new SystemDto();
//                    system.setSystemKey(domain.getSiKey());
//                    system.setGroupKey(domain.getOgKey());
//                    system.setGroupUserKey(domain.getGuKey());
//                    system.setSystemName(domain.getSiNm());
//                    return system;
//                })
//                .collect(Collectors.toList());
        List<SystemDto> domainList = new ArrayList<>();
        return domainList;
    }
}
