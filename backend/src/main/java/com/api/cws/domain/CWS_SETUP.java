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
@Table(name = "CWS_SETUP")
// 환경설정 내용 추가 필요.
public class CWS_SETUP {
    @Column(name = "SETUP_KEY")
    @Id
    private Long setupKey;
}

