package com.api.cws.module.cwsApp.repository;

import com.api.cws.domain.file_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface fileInfoRepository extends JpaRepository<file_info, Long>, JpaSpecificationExecutor<file_info> {
    List<file_info> findAllByPiKey(Long piKey);
}
