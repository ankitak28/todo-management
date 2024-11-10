package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.UsersDto;
import net.javaguides.ems.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersController  {

    private UsersService usersService;

    @GetMapping("id")
    public ResponseEntity<UsersDto> getUserById(@PathVariable Long id){
        UsersDto usersDto = usersService.getUserById(1L);
        return  ResponseEntity.ok(usersDto);
    }

    @GetMapping
    public ResponseEntity<List<UsersDto>> getAllUsers(){

        List<UsersDto> usersList = usersService.getAllUsers();
        return ResponseEntity.ok(usersList);
    }

    @PostMapping
    public ResponseEntity<UsersDto> createUser(@RequestBody UsersDto usersDto){
        UsersDto savedUser = usersService.createUser(usersDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<UsersDto> updateUser(@RequestBody UsersDto usersDto, @PathVariable("id") Long id){

        UsersDto updatedUserDto = usersService.updateUser(id,usersDto);
        return ResponseEntity.ok(updatedUserDto);

    }

    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteMapping(@PathVariable("id") Long id){

        usersService.deleteUser(id);
        return ResponseEntity.ok("User Deleted!");
    }

}

