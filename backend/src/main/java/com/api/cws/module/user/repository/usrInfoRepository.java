package com.api.cws.module.user.repository;

import com.api.cws.domain.usr_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface usrInfoRepository extends JpaRepository<usr_info, Long>, JpaSpecificationExecutor<usr_info> {
}
