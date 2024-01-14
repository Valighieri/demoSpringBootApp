package com.example.demoSpringBootApp.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public final class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "is_handled")
    private Boolean isHandled = Boolean.FALSE;


}
