package tn.esprit.tpfoyer.Services;

import lombok.RequiredArgsConstructor;
import tn.esprit.tpfoyer.mapper.UserMapper;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.DTO.UserDTO;
import tn.esprit.tpfoyer.Entities.User;
import tn.esprit.tpfoyer.mapper.UserMapper;
import tn.esprit.tpfoyer.Repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDTO(user);
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);

        // ajouter un password par défaut si absent
        if (user.getPassword() == null) {
            user.setPassword("default123");
        }

        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }


    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }
}