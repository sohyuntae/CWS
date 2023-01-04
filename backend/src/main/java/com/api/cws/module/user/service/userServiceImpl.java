package com.api.cws.module.user.service;

import com.api.cws.domain.Qusr_info;
import com.api.cws.domain.usr_info;
import com.api.cws.module.user.repository.usrInfoRepository;
import com.dgs.dgsframework.types.UserInfo;
import com.dgs.dgsframework.types.addUserInfo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class userServiceImpl implements userService {
    private final JPAQueryFactory queryFactory;
    private final usrInfoRepository usrInfoRepository;

    @Override
    public List<UserInfo> getUserList(List<Long> uiKey) {
        return queryFactory
                .select(
                        Projections.fields(
                                UserInfo.class,
                                Qusr_info.usr_info.uiId.as("uid"),
                                Qusr_info.usr_info.uiPw.as("uPw"),
                                Qusr_info.usr_info.uiNm.as("userName"),
                                Qusr_info.usr_info.email.as("userEmail"),
                                Qusr_info.usr_info.phonNmbr.as("userPhone")
                        )
                )
                .from(Qusr_info.usr_info)
                .where(Qusr_info.usr_info.uiKey.in(uiKey))
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public UserInfo getUserInfo(Long uiKey) {
        return queryFactory
                .select(
                        Projections.fields(
                                UserInfo.class,
                                Qusr_info.usr_info.uiId.as("uid"),
                                Qusr_info.usr_info.uiPw.as("uPw"),
                                Qusr_info.usr_info.uiNm.as("userName"),
                                Qusr_info.usr_info.email.as("userEmail"),
                                Qusr_info.usr_info.phonNmbr.as("userPhone")
                        )
                )
                .from(Qusr_info.usr_info)
                .where(Qusr_info.usr_info.uiKey.eq(uiKey))
                .stream()
                .findFirst()
                .orElseGet(UserInfo::new);
    }

    @Override
    public String setUserInfo(addUserInfo userInfo) {
        usr_info usrInfo = new usr_info();
        usrInfo.setUiKey(userInfo.getUiKey());
        usrInfo.setUiId(userInfo.getUid());
        usrInfo.setUiPw(userInfo.getUPw());
        usrInfo.setUiNm(usrInfo.getUiNm());
        usrInfo.setEmail(userInfo.getUserEmail());
        usrInfo.setPhonNmbr(userInfo.getUserPhone());
        usrInfoRepository.save(usrInfo);
        return "성공";
    }
}
