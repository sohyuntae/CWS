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
    public List<UserInfo> getUserList(@InputArgument String uid) {
        return userService.getUserList(uid);
    }

    @DgsQuery
    @Transactional(readOnly = true)
    public UserInfo getUserInfo(@InputArgument String uid) {
        return userService.getUserInfo(uid);
    }

    @DgsMutation
    @Transactional
    public String setUserInfo(addUserInfo userInfo) {
        return userService.setUserInfo(userInfo);
    }
}
