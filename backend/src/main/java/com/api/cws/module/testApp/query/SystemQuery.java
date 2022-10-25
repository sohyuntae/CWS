package com.api.cws.module.testApp.query;

import com.api.cws.domain.Qstm_info;
import com.api.cws.domain.stm_info;
import com.api.cws.module.testApp.dto.SystemDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Controller
public class SystemQuery{
    private final JPAQueryFactory queryFactory;

    @Transactional(readOnly = true)
    @QueryMapping
    public List<SystemDto> systemInfo() {
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

    @QueryMapping
    public List<stm_info> systemInfo2() {
        return queryFactory
                .selectFrom(Qstm_info.stm_info)
                .where(Qstm_info.stm_info.guKey.isNotNull())
                .fetch();
    }
}
