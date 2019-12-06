package glim.antony.tomotime.services;

import glim.antony.tomotime.entities.User;
import glim.antony.tomotime.utils.SystemUser;
import glim.antony.tomotime.utils.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService  extends UserDetailsService {
    User findByEmail(String email);
    User findById(Long id);
    boolean isUserExist(String email);
    User save(SystemUser systemUser);
    User updateFirstAndLastName(UserDTO userDTO);
}
