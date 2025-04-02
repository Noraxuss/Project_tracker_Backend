package project_tracker_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_tracker_backend.config.security.KeyEncryptionKey;
import project_tracker_backend.domain.User;
import project_tracker_backend.dto.incoming.UserCreationDto;
import project_tracker_backend.dto.mapper.UserMapper;
import project_tracker_backend.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final KeyEncryptionKey keyEncryptionKey;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, KeyEncryptionKey keyEncryptionKey) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.keyEncryptionKey = keyEncryptionKey;
    }

    public void registerUser(UserCreationDto userCreationDto) {
        userCreationDto.setPassword(keyEncryptionKey.generateKEK(userCreationDto.getPassword()));
        User user = userMapper.mapUserCreationDtoToUser(userCreationDto);
        userRepository.save(user);
    }

    public User findUserById(Long id) {
        //TODO Exception throwing instead of null
        return userRepository.findById(id).orElse(null);
    }
}
