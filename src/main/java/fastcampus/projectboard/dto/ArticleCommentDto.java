package fastcampus.projectboard.dto;

import fastcampus.projectboard.domain.Article;
import fastcampus.projectboard.domain.ArticleComment;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ArticleCommentDto implements Serializable {
    private final Long id;
    private final Long articleId;
    private final UserAccountDto userAccountDto;
    private final LocalDateTime createdAt;
    private final String createdBy;
    private final LocalDateTime modifiedAt;
    private final String modifiedBy;
    private final String content;


    public static ArticleCommentDto of(Long id, Long articleId, UserAccountDto userAccountDto, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy,String content) {
        return new ArticleCommentDto(id, articleId, userAccountDto, createdAt, createdBy, modifiedAt, modifiedBy, content);
    }

    public static ArticleCommentDto from(ArticleComment entity) {
        return new ArticleCommentDto(
                entity.getId(),
                entity.getArticle().getId(),
                UserAccountDto.from(entity.getUserAccount()),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy(),
                entity.getContent()
        );
    }

    public ArticleComment toEntity(Article entity) {
        return ArticleComment.of(
                entity,
                userAccountDto.toEntity(),
                content
        );
    }
}
