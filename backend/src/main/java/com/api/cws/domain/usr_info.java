package com.api.cws.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usr_info")
public class usr_info {
  @Id
  @Column(name="UI_KEY")
  private Long uiKey;
  @Column(name="UI_ID")
  private String uiId;
  @Column(name="UI_PW")
  private String uiPw;
  @Column(name="UI_NM")
  private String uiNm;
  @Column(name="EMAIL")
  private String email;
  @Column(name="UI_PHONE")
  private String userPhone;
}
