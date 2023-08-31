package com.example.studyproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="dietResponse")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DietResponseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dietResponseId;
    private String dietName;
    private String dietRecipe;
    private String dietKcal;

    @OneToOne(fetch = FetchType.LAZY)//fetchtype을 eager로 하면 가능 그러면 getallposts를 dto로 해도 되는지? 직렬화의 문제가 있었음
    @JoinColumn(name="dietChat")
    private DietChatEntity dietChat;
    private Long userId=dietChat.getUserId();
    private Long likes;
}
