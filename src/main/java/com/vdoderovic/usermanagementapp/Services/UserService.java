package com.vdoderovic.usermanagementapp.Services;

import com.vdoderovic.usermanagementapp.DTO.User.command.UserCreateDTO;
import com.vdoderovic.usermanagementapp.DTO.User.command.UserUpdateDTO;
import com.vdoderovic.usermanagementapp.DTO.User.query.UserDTO;
import com.vdoderovic.usermanagementapp.DTO.User.query.UserWCompDTO;
import com.vdoderovic.usermanagementapp.Entities.User;
import com.vdoderovic.usermanagementapp.Mapper.UserMapper;
import com.vdoderovic.usermanagementapp.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDTO> getAll() {
        return userMapper.toDTOList(userRepository.findAll());
    }

    public List<UserWCompDTO> getAllByCompany(Integer id) {
        return userRepository
                .getAllByCompIdEager(id)
                .stream()
                .map(userMapper::toUserWCompDTO)
                .toList();
    }

    public List<UserDTO> getAllDeactivated() {
        return userMapper.toDTOList(userRepository.getAllDeactivated());
    }

    public List<UserDTO> getAllByDate(LocalDate date) {
        return userMapper.toDTOList(userRepository.findAllByCreatedAt(date));
    }

    public void creteUser(UserCreateDTO userCreateDTO) {
        userRepository.save(userMapper.createDTOtoEntity(userCreateDTO));
    }

    @Transactional
    public String softDelete(Integer id) {
        boolean exists = userRepository.existsById(id);
        if(exists) userRepository.deleteById(id);
        return exists ? "User soft deleted." : "No user found with the provided id.";
    }

    public String delete(Integer id) {
        boolean exists = userRepository.existsById(id);
        if(exists) userRepository.deleteById(id);
        return exists ? "User deleted." : "No user found with the provided id.";
    }

    public String updateUser(Integer id, UserUpdateDTO userUpdateDTO) {

        String resp = "No user found with the provided id. Created a new user.";

        Optional<User> optionalUser = userRepository.findById(id);
        User user = userMapper.updateDTOtoEntity(userUpdateDTO);

        if(optionalUser.isPresent()) {
            User u = optionalUser.get();
            Class<?> clazz = user.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(user);
                    if (value == null || value instanceof String && ((String) value).isEmpty()) {
                        field.set(user, field.get(u));
                    }
                } catch (IllegalAccessException ignored) {}
            }
            resp = "Updated user with the provided id.";
        }

        try{
            userRepository.save(user);
        } catch (Exception e) {
            resp = "No user found with the provided id. All fields my be set to create a new user.";
        }

        return resp;
    }
}
