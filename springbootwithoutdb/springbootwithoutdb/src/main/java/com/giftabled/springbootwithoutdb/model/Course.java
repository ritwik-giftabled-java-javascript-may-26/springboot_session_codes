package com.giftabled.springbootwithoutdb.model;

import lombok.*;

//@Getter
//@Setter
//@ToString

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private Long id;
    private String title;
    private String description;
}
