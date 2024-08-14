package org.example.model;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class Author {

    private Integer id;
    private String name;
    private String bio;

    public Author(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    public Author(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
