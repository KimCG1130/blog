package com.sparta.blog.model;

import com.sparta.blog.dto.ReplyDTO;
import com.sparta.blog.model.Timestamped;
import com.sparta.blog.model.Board;
import com.sparta.blog.model.User;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reply extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String content;

    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;


    public void update(ReplyDTO replyDTO) {
        this.content = replyDTO.getContent();
    }
}
