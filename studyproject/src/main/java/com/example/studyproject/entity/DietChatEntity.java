package com.example.studyproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="dietChat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DietChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dietChatId;
    private String dietNameQuery;
    private String dietRecipeQuery;
    private String dietKcalQuery;

    @ManyToOne(fetch = FetchType.LAZY)//fetchtype을 eager로 하면 가능 그러면 getallposts를 dto로 해도 되는지? 직렬화의 문제가 있었음
    @JoinColumn(name="diet")
    private DietEntity diet;

}
