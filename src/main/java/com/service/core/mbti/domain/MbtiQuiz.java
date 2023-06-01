package com.service.core.mbti.domain;

import com.service.core.common.converter.StringArrayConverter;
import com.service.core.common.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "mbti_quiz")
public class MbtiQuiz extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "round_id")
    private Long roundId;

    private Integer seq;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Convert(converter = StringArrayConverter.class)
    private String answer;
}
