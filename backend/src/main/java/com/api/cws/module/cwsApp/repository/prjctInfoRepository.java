package com.api.cws.module.cwsApp.repository;

import com.api.cws.domain.prjct_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface prjctInfoRepository extends JpaRepository<prjct_info, Long>, JpaSpecificationExecutor<prjct_info> {
}
