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
@Table(name = "file_info")
public class file_info {
  @Id
  @Column(name="FI_KEY")
  private Long fiKey;
  @Column(name="PL_KEY")
  private String plKey;
  @Column(name="FILE_NAME")
  private String fileName;
  @Column(name="FILE_PATH")
  private String filePath;
  @Column(name="REG_DT")
  private String regDt;
  @Column(name="REG_UID")
  private String regUid;
}
