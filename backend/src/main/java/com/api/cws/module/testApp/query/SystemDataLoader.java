package com.api.cws.module.testApp.query;

import com.api.cws.domain.Qstm_info;
import com.api.cws.domain.stm_info;
import com.api.cws.module.testApp.dto.SystemDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.dataloader.BatchLoader;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SystemDataLoader implements BatchLoader<Long, SystemDto> {
    public static final String NAME = "systemLoader";
    private final JPAQueryFactory queryFactory;

    @Override
    public CompletionStage<List<SystemDto>> load(List<Long> keys) {
        Map<Long, stm_info> findDomain = queryFactory
                .selectFrom(Qstm_info.stm_info)
                .where(Qstm_info.stm_info.siKey.in(keys))
                .stream()
                .collect(Collectors.toMap(stm_info::getSiKey, Function.identity()));

        return CompletableFuture.completedFuture(keys
                .stream()
                .map(key -> {
                    stm_info domain = findDomain.get(key);
                    if (domain == null) return null;
                    SystemDto system = new SystemDto();
                    system.setSystemKey(domain.getSiKey());
                    system.setGroupKey(domain.getOgKey());
                    system.setGroupUserKey(domain.getGuKey());
                    system.setSystemName(domain.getSiNm());
                    return system;
                })
                .collect(Collectors.toList())
        );
    }
}
