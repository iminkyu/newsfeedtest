package com.pokemon.newsfeed.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "boards")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardSeq;
    @Column(nullable = false, length = 50)
    private String title;
    @Lob // 대용량 데이터 저장 시 사용
    private String content;
    @ManyToOne // 다대일 매핑 : 한명의 유저는 여러개의 게시글을 쓸 수 있다.
    @JoinColumn(name = "userSeq") // foreign key : userSeq, references User : id
    private User user; // DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다. // 참조할 데이터
}
