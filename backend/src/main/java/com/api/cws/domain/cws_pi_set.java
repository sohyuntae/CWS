package com.api.cws.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

// cws 프로젝트 공통 셋팅
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cws_pi_set")
public class cws_pi_set {

  // CWS_공통키(한개만 존재)
  @Id
  @Column(name="CP_KEY")
  private Long cpKey;
  // null
  @Column(name="CP_SET1")
  private String cpSet1;
  // null
  @Column(name="CP_SET2")
  private String cpSet2;
  // null
  @Column(name="CP_SET3")
  private String cpSet3;
}
