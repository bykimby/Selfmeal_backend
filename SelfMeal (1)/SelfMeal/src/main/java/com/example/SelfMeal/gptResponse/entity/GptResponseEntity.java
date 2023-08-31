package com.example.SelfMeal.gptResponse.entity;

import com.example.SelfMeal.diet.entity.DietEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="gptResponse")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GptResponseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gptResponseId;
    private String dietName;
    private String dietRecipe;
    private String dietKcal;
    private String dietIngredients;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="diet")
    private DietEntity diet;
    public Long getUserIdFromDiet() {
        return diet.getUserIdFromUser();
    }
    public Long getDietIdFromDiet() {
        return diet.getDietId();
    }
}
