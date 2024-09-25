package com.example.Nadeuri.comment;

import com.example.Nadeuri.board.BoardEntity;
import com.example.Nadeuri.member.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentDTO {

    private Long id;
    private Long boardId;
    private Long memberId;
    private String content;
    private String createdAt;
    private String updatedAt;

    @Builder
    public CommentDTO(Long id, Long boardId, Long memberId, String content, String createdAt, String updatedAt) {
        this.id = id;
        this.boardId = boardId;
        this.memberId = memberId;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // entity -> dto 변환
    public static CommentDTO fromEntity(CommentEntity commentEntity) {
        return CommentDTO.builder()
                .id(commentEntity.getId())
                .boardId(commentEntity.getBoard().getId())
                .memberId(commentEntity.getMember().getMemberNo())
                .content(commentEntity.getContent())
                .createdAt(commentEntity.getCreatedAt().toString())
                .updatedAt(commentEntity.getUpdatedAt() != null ? commentEntity.getUpdatedAt().toString() : null)
                .build();
    }

    // dto -> entity 변환
    public static CommentEntity toEntity(CommentDTO commentDTO, BoardEntity board, MemberEntity member) {
        return CommentEntity.builder()
                .id(commentDTO.getId())
                .board(board)
                .member(member)
                .content(commentDTO.getContent())
                .build();
    }
}