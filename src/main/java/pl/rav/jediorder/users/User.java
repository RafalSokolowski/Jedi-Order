package pl.rav.jediorder.users;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.rav.jediorder.support.ValidateUserString;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Entity
// JPA annotation (only marker like Serializable), inform that class can be mapped to a table, when create new entity that use @Entity for a class and create field with @id annotation (@Entity and @id minimum to use JPA entity)

@Data  // @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true) // 'access' defines type of the constructor (here will be private) and 'force=true' to create noArgsConstructor with final fields (use 0/null/false data)
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
// 'access' defines type of the constructor (here will be private) and 'force=true' to create noArgsConstructor with final fields (use 0/null/false data)
@RequiredArgsConstructor
// powyższy NoArgsConstructor usuwa RequiredArgsConstructor dlatego tu trzeba dodać raz jeszcze...

//@Table(name = "users")
public class User implements UserDetails {

    private static final long serialVersion = 1L;

    @Id                                                 //  primary key of current entity
    @GeneratedValue(strategy = GenerationType.AUTO)     // auto increment (in table)
    private Long id;

    private String created;
    private final String username;
    private final String password;
    private final String firstName;
    private final String secondName;
    private final String age;
    private final String email;
    private final String phone;
    private final boolean isAdmin;
    private boolean isOn = true;

    @PrePersist
    void setCreated() {
//        this.created = new Date();

        this.created = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

//        this.created = LocalDateTime.parse(LocalDateTime.now().toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        this.created = LocalDateTime.parse(LocalDateTime.now().toString(), DateTimeFormatter.ISO_DATE_TIME);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (isAdmin)
            return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        else
            return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isOn;
    }

}
