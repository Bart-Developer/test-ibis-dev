package back.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "REGISTRATION_USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    public Long id;

    public String name;
    public String phone;
    public String email;
    public LocalDate createdAt;

    public User(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.createdAt = LocalDate.now();
    }
}
