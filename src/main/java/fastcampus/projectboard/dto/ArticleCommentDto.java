package fastcampus.projectboard.dto;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ArticleCommentDto implements Serializable {
    private final LocalDateTime createdAt;
    private final String createdBy;
    private final LocalDateTime modifiedAt;
    private final String modifiedBy;
    private final String content;

    public static ArticleCommentDto of(LocalDateTime createdAt, String createdBy,LocalDateTime modifiedAt, String modifiedBy, String content) {
        return new ArticleCommentDto(createdAt, createdBy, modifiedAt, modifiedBy, content);
    }
}
