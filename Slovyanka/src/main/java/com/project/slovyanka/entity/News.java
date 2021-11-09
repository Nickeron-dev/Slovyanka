package com.project.slovyanka.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "title_ukr", nullable = false, columnDefinition = "varchar(50)")
    private String titleUkr;

    @Column(name = "title_eng", nullable = true, columnDefinition = "varchar(50)")
    private String titleEng;

    @Column(name = "introduction_ukr", nullable = false, columnDefinition = "varchar(200)")
    private String introductionUkr;

    @Column(name = "introduction_eng", nullable = true, columnDefinition = "varchar(200)")
    private String introductionEng;

    @Column(name = "text_ukr", nullable = false, columnDefinition = "varchar(440)")
    private String textUkr;

    @Column(name = "text_eng", nullable = true, columnDefinition = "varchar(440)")
    private String textEng;


}
