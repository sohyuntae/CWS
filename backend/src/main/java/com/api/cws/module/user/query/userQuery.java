package com.api.cws.module.user.query;

import com.api.cws.domain.Qusr_info;
import com.api.cws.domain.usr_info;
import com.dgs.dgsframework.types.UserInfo;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@DgsComponent
@RequiredArgsConstructor
public class userQuery {

    private final JPAQueryFactory queryFactory;

    @DgsQuery
    @Transactional(readOnly = true)
    public List<UserInfo> getUserList(@InputArgument String usrKey) {
        List<usr_info> usrDomainList = queryFactory
                .select(Qusr_info.usr_info)
                .from(Qusr_info.usr_info)
                .where(Qusr_info.usr_info.uiId.eq(usrKey))
                .fetch();

        List<UserInfo> result = new ArrayList<>(usrDomainList.size());

        usrDomainList.forEach(usr -> {
            UserInfo newInfo = new UserInfo();
            newInfo.setUid(usr.getUiId());
            newInfo.setUserName(usr.getUiNm());
            newInfo.setUserEmail(usr.getEmail());
            newInfo.setUserPhone(usr.getUserPhone());
            result.add(newInfo);
        });

        return result;
    }

    @DgsQuery
    @Transactional(readOnly = true)
    public UserInfo getUserInfo(@InputArgument String usrKey) {
        return new UserInfo();
    }
}
