package net.javaguides.ems.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name="password")
    private String password;

    public String getPassword(){
        return password;
    }


}
