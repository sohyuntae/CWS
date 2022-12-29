package com.api.cws.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

// 사용자 정보
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usr_info")
public class usr_info {

  // 사용자키
  @Id
  @Column(name="ui_key")
  private Long uiKey;
  // 사용자ID
  @Column(name="ui_id")
  private String uiId;
  // 사용자 패스워드
  @Column(name="ui_pw")
  private String uiPw;
  // 사용자명
  @Column(name="ui_nm")
  private String uiNm;
  // 이메일
  @Column(name="email")
  private String email;
  // 휴대전화번호
  @Column(name="phon_nmbr")
  private String phonNmbr;
  // 수정일시
  @Column(name="upd_dt")
  private Timestamp updDt;
  // 등록일시
  @Column(name="reg_dt")
  private Timestamp regDt;
}
