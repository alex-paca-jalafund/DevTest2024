package polls.api.poll_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;


@Entity
public class UserEmail {
    @Id
    Long id;

    @Email
    String email;
}
