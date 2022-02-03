package com.sparta.blog.model;


import com.sparta.blog.model.Timestamped;
import com.sparta.blog.dto.ReplyDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Reply extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String reply;

    @Column(nullable = false)
    private long boardId;

    @Column(nullable = false)
    private Long userId;

    public Reply(ReplyDto replyDto, Long userId, String username, Long boardId) {
        this.userId = userId;
        this.reply = replyDto.getReply();
        this.boardId = boardId;
        this.username = username;
    }

    public void updateReply(ReplyDto requestDto) {
        this.reply = requestDto.getReply();
    }

}

