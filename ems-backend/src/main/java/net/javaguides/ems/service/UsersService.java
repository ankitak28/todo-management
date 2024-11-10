package net.javaguides.ems.service;

import net.javaguides.ems.dto.UsersDto;

import java.util.List;

public interface UsersService {

    UsersDto createUser (UsersDto usersDto);
    UsersDto getUserById (Long id);
    List<UsersDto> getAllUsers();
    UsersDto updateUser(Long id, UsersDto usersDto);
    void deleteUser(Long id);
}
