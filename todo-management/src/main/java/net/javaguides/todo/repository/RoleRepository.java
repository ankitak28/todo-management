package net.javaguides.todo.repository;

import net.javaguides.todo.entity.Role;
import net.javaguides.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    }
