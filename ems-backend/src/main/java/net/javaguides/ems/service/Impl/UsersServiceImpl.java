package net.javaguides.ems.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.UsersDto;
import net.javaguides.ems.entity.Users;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.mapper.UsersMapper;
import net.javaguides.ems.repository.UsersRepository;
import net.javaguides.ems.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {
    private UsersRepository usersRepository;
    @Override
    public UsersDto createUser(UsersDto usersDto) {
        Users user = UsersMapper.mapToUsers(usersDto);
        Users savedUsers = usersRepository.save(user);
        return UsersMapper.mapToUsersDto(savedUsers);
    }

    @Override
    public UsersDto getUserById(Long id) {
        Users user = usersRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Id does not exist.")
        );
        UsersDto savedUsersDto = UsersMapper.mapToUsersDto(user);
                return savedUsersDto;
    }

    @Override
    public List<UsersDto> getAllUsers() {
        List<Users> users = usersRepository.findAll();
        return users.stream().map((user)->UsersMapper.mapToUsersDto(user)).collect(Collectors.toList());
    }

    @Override
    public UsersDto updateUser(Long id, UsersDto usersDto) {
        Users user = usersRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Id does not exist"));

        user.setUsername(usersDto.getUsername());
        user.setEmail(usersDto.getEmail());
        user.setPassword(usersDto.getPassword());


        Users savedUsers = usersRepository.save(user);
        UsersDto savedUsersDto = UsersMapper.mapToUsersDto(savedUsers);
        return savedUsersDto;
    }

    @Override
    public void deleteUser(Long id) {

        Users users = usersRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("")
        );
        usersRepository.deleteById(id);

    }
}
