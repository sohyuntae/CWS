package com.api.cws.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

// CWS 프로젝트 정보
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "prjct_info")
public class prjct_info {

  // 프로젝트 키
  @Id
  @Column(name="PI_KEY")
  private Long piKey;
  // 프로젝트 명
  @Column(name="PI_NM")
  private String piNm;
  // 프로젝트 목적
  @Column(name="PI_PURPOSE")
  private String piPurpose;
  // 프로젝트 견적
  @Column(name="PI_ESTMT")
  private String piEstmt;
  // 프로젝트 내용
  @Column(name="PI_CNTNT")
  private String piCntnt;
  // 요청자 키
  @Column(name="REQ_KEY")
  private Long reqKey;
  // 파일 키
  @Column(name="FI_KEY")
  private Long fiKey;
  // 수정일시
  @Column(name="UPD_DT")
  private Timestamp updDt;
  // 수정자 키
  @Column(name="UPD_KEY")
  private Long updKey;
  // 등록일시
  @Column(name="REG_DT")
  private Timestamp regDt;
  // 등록자 키
  @Column(name="REG_KEY")
  private Long regKey;
}
