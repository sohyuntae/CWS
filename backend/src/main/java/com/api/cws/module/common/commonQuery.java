package com.api.cws.module.common;

import com.dgs.dgsframework.types.setInfo;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DgsComponent
@RequiredArgsConstructor
public class commonQuery {
    private final JPAQueryFactory queryFactory;

    @DgsQuery
    @Transactional(readOnly = true)
    public setInfo getSettingInfo() {
        return new setInfo();
    }
}
