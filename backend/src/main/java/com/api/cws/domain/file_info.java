package com.api.cws.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

// 파일 정보
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "file_info")
public class file_info {

  // 파일 키
  @Id
  @Column(name="FI_KEY")
  private Long fiKey;
  // 프로젝트 키
  @Column(name="PI_KEY")
  private Long piKey;
  // 파일명
  @Column(name="FI_NM")
  private String fiNm;
  // 파일 경로
  @Column(name="FI_PATH")
  private String fiPath;
  // 파일사이즈
  @Column(name="FI_SIZE_KB")
  private Long fiSizeKb;
  // 등록일시
  @Column(name="REG_DT")
  private Timestamp regDt;
  // 등록자 키
  @Column(name="REG_KEY")
  private Long regKey;
}
