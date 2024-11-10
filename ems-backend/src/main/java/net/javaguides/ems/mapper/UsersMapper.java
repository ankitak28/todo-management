package net.javaguides.ems.mapper;

import net.javaguides.ems.dto.UsersDto;
import net.javaguides.ems.entity.Users;

public class UsersMapper {

    public static Users mapToUsers(UsersDto usersDto){
        return  new Users(
                usersDto.getId(),
                usersDto.getUsername(),
                usersDto.getEmail(),
                usersDto.getPassword());
    }

    public static UsersDto mapToUsersDto(Users user){
        return new UsersDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword());
    }
}
