package glim.antony.tomotime.utils.dto;

import glim.antony.tomotime.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private String email;
    private String firstName;

    public UserDTO(User user) {
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
    }
}
