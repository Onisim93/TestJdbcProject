package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDto {

    private Integer id;
    private String username;

    @ToString.Exclude
    private String password;
    private String email;


    public UserDto(Integer id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

}
