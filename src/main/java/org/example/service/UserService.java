package org.example.service;

import org.example.dto.UserDto;
import org.example.model.User;
import org.example.repository.UserRepository;

import java.util.List;

import static org.example.mapper.UserMapper.INSTANCE;

public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean authentication(String username, String password) {
        return repository.authUser(username, password);
    }


    public UserDto findById(Integer id) {
        validateId(id);
        return INSTANCE.toDto(repository.getById(id));
    }

    public UserDto create(UserDto userDto) {
        return INSTANCE.toDto(repository.save(INSTANCE.toEntity(userDto)));
    }

    public UserDto put(Integer id, UserDto userDto) {
        validateId(userDto.getId());
        validateId(id);
        validateUser(userDto);
        validateMatchingIds(id, userDto.getId());

        return INSTANCE.toDto(repository.update(INSTANCE.toEntity(userDto)));
    }

    public UserDto patch(Integer id, UserDto userDto) {
        validateId(id);
        User user = repository.getById(id);


        if (userDto.getUsername() != null && !userDto.getUsername().isEmpty()) {
            user.setUsername(userDto.getUsername());
        }

        if (userDto.getPassword() != null && !userDto.getPassword().isEmpty()) {
            user.setPassword(userDto.getPassword());
        }

        if (userDto.getEmail() != null && !userDto.getEmail().isEmpty()) {
            user.setEmail(userDto.getEmail());
        }

        return INSTANCE.toDto(repository.update(INSTANCE.toEntity(userDto)));
    }


    public List<UserDto> findAll() {
        return INSTANCE.toDto(repository.getAll());
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    private void validateMatchingIds(Integer urlId, Integer userId) {
        if (urlId == null || userId == null || urlId != userId) {
            throw new IllegalArgumentException("Ids must match");
        }
    }

    private void validateId(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Id cant be null or less then 0");
        }
    }

    private void validateUser(UserDto userDto) {
        boolean isValid = true;

        if (userDto.getUsername() == null || userDto.getUsername().isEmpty()) {
            isValid = false;
        }
        if (userDto.getPassword() == null || userDto.getPassword().isEmpty()) {
            isValid = false;
        }
        if (userDto.getEmail() == null || userDto.getEmail().isEmpty()) {
            isValid = false;
        }

        if (!isValid) {
            throw new IllegalArgumentException("Username, password and email are required");
        }
    }
}
