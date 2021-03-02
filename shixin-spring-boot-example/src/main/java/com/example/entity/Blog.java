package com.example.entity;

import com.shixin.dal.entity.BaseDocument;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author shixin
 * @date 2021/2/27
 */
@Data
@Document(collection = "blog")
public class Blog extends BaseDocument {
    private String title;
    private String content;
    private String author;
}
