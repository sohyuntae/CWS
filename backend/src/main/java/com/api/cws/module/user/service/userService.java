package com.api.cws.module.user.service;

import com.dgs.dgsframework.types.UserInfo;
import com.dgs.dgsframework.types.addUserInfo;

import java.util.List;

public interface userService {
    List<UserInfo> getUserList(String uid);
    UserInfo getUserInfo(String uid);
    String setUserInfo(addUserInfo userInfo);
}
