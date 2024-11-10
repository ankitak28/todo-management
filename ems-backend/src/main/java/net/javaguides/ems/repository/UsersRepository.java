package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
}
