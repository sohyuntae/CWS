package com.api.cws.module.user.query;

import com.api.cws.module.user.service.userService;
import com.dgs.dgsframework.types.UserInfo;
import com.dgs.dgsframework.types.addUserInfo;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DgsComponent
@RequiredArgsConstructor
public class userQuery {

    private final userService userService;

    @DgsQuery
    @Transactional(readOnly = true)
    public List<UserInfo> getUserList(@InputArgument List<Long> uiKey) {
        return userService.getUserList(uiKey);
    }

    @DgsQuery
    @Transactional(readOnly = true)
    public UserInfo getUserInfo(@InputArgument Long uiKey) {
        return userService.getUserInfo(uiKey);
    }

    @DgsMutation
    @Transactional
    public String setUserInfo(addUserInfo userInfo) {
        return userService.setUserInfo(userInfo);
    }
}
