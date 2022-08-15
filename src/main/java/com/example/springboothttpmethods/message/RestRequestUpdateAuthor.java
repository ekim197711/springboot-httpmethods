package com.example.springboothttpmethods.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RestRequestUpdateAuthor {
    private Long id;
    private String updatedAuthor;
}
