package com.api.cws.module.user.service;

import com.dgs.dgsframework.types.UserInfo;
import com.dgs.dgsframework.types.addUserInfo;

import java.util.List;

public interface userService {
    List<UserInfo> getUserList(List<Long> uiKey);
    UserInfo getUserInfo(Long uiKey);
    String setUserInfo(addUserInfo userInfo);
}
