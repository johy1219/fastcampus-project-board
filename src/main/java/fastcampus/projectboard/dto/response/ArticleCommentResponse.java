package fastcampus.projectboard.dto.response;

import fastcampus.projectboard.dto.ArticleCommentDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ArticleCommentResponse {
    private final LocalDateTime createdAt;
    private final Long id;
    private final String content;
    private final String email;
    private final String nickname;

    public static ArticleCommentResponse of(LocalDateTime createdAt, Long id, String content, String email, String nickname) {
        return new ArticleCommentResponse(createdAt, id, content, email, nickname);
    }

    public static ArticleCommentResponse from(ArticleCommentDto dto) {
        String nickname = dto.getUserAccountDto().getNickname();
        if (nickname == null || nickname.isBlank()) {
            nickname = dto.getUserAccountDto().getUserId();
        }

        return new ArticleCommentResponse(
                dto.getCreatedAt(),
                dto.getId(),
                dto.getContent(),
                dto.getUserAccountDto().getEmail(),
                nickname
        );
    }
}
