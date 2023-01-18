package org.library.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.library.backend.dto.PersonCommentDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link org.library.backend.models.Comment} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CommentDTO implements Serializable {
    private Integer id;
    @Size(max = 200)
    @NotNull
    private String content;
    private Instant createdAt;
    private Integer rating;
    @NotNull
    private PersonCommentDTO personID;
}