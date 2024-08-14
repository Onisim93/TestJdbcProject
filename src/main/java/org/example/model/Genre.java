package org.example.model;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Genre {

    private Integer id;
    private String name;
    private String description;


    public Genre(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public Genre(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
