package com.api.cws.repository;

import com.api.cws.domain.stm_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface stmInfoRepository extends JpaRepository<stm_info, Long>, JpaSpecificationExecutor<stm_info>, stmInfoRepositoryCustom {
}
