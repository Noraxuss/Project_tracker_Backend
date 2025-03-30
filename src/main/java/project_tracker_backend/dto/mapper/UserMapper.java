package project_tracker_backend.dto.mapper;

import org.springframework.stereotype.Component;
import project_tracker_backend.domain.User;
import project_tracker_backend.dto.incoming.UserCreationDto;

@Component
public class UserMapper {

    public User mapUserCreationDtoToUser(UserCreationDto userCreationDto) {
        User user = new User();
        user.setUsername(userCreationDto.getUsername());
        user.setPassword(userCreationDto.getPassword());
        return user;
    }

}
