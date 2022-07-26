package fastcampus.projectboard.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ArticleUpdateDto implements Serializable {
    private final String title;
    private final String content;
    private final String hashtag;

    public static ArticleUpdateDto of(String title, String content, String hashtag) {
        return new ArticleUpdateDto(title, content, hashtag);
    }
}
