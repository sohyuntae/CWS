package com.api.cws.module.user.query;

import com.api.cws.domain.Qusr_info;
import com.dgs.dgsframework.types.UserInfo;
import com.dgs.dgsframework.types.addUserInfo;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
@RequiredArgsConstructor
public class userQuery {

    private final JPAQueryFactory queryFactory;

    @DgsQuery
    @Transactional(readOnly = true)
    public List<UserInfo> getUserList(@InputArgument String uid) {
        return queryFactory
                .select(
                        Projections.fields(
                                UserInfo.class,
                                Qusr_info.usr_info.uiId.as("uid"),
                                Qusr_info.usr_info.uiPw.as("uPw"),
                                Qusr_info.usr_info.uiNm.as("userName"),
                                Qusr_info.usr_info.email.as("userEmail"),
                                Qusr_info.usr_info.userPhone.as("userPhone")
                        )
                )
                .from(Qusr_info.usr_info)
                .where(Qusr_info.usr_info.uiId.eq(uid))
                .stream()
                .collect(Collectors.toList());
    }

    @DgsQuery
    @Transactional(readOnly = true)
    public UserInfo getUserInfo(@InputArgument String uid) {
        return queryFactory
                .select(
                        Projections.fields(
                                UserInfo.class,
                                Qusr_info.usr_info.uiId.as("uid"),
                                Qusr_info.usr_info.uiPw.as("uPw"),
                                Qusr_info.usr_info.uiNm.as("userName"),
                                Qusr_info.usr_info.email.as("userEmail"),
                                Qusr_info.usr_info.userPhone.as("userPhone")
                        )
                )
                .from(Qusr_info.usr_info)
                .where(Qusr_info.usr_info.uiId.eq(uid))
                .stream()
                .findFirst()
                .orElseGet(UserInfo::new);
    }

    @DgsMutation
    @Transactional
    public String setUserInfo(addUserInfo userInfo) {
        return "성공";
    }
}
