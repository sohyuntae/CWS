package com.api.cws.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "prjct_list")
public class prjct_list {
  @Id
  @Column(name="PL_KEY")
  private Long plKey;
  @Column(name="PRJCT_NM")
  private String prjctNm;
  @Column(name="PRJCT_TYPE_CD")
  private String prjctTypeCd;
  @Column(name="PURPOSE")
  private String purpose;
  @Column(name="REQ_COMPANY_CD")
  private String reqCompanyCd;
  @Column(name="DESCRIPTION")
  private String description;
}
