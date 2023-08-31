package com.example.studyproject.entity;

import com.example.studyproject.domain.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="diet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DietEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dietId;
    private float kcalToEat;
    private String availableIngredients;
    private String meal;
    private String inavailableIngredients;
    private String dietDisease;
    @ManyToOne(fetch = FetchType.LAZY)//fetchtype을 eager로 하면 가능 그러면 getallposts를 dto로 해도 되는지? 직렬화의 문제가 있었음
    @JoinColumn(name="userId")
    private UserEntity user;//foriegn key
}
