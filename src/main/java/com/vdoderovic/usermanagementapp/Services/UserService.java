package com.vdoderovic.usermanagementapp.Services;

import com.vdoderovic.usermanagementapp.DTO.User.command.UserCreateDTO;
import com.vdoderovic.usermanagementapp.DTO.User.command.UserUpdateDTO;
import com.vdoderovic.usermanagementapp.DTO.User.query.UserDTO;
import com.vdoderovic.usermanagementapp.DTO.User.query.UserWCompDTO;
import com.vdoderovic.usermanagementapp.Entities.User;
import com.vdoderovic.usermanagementapp.Mapper.UserMapper;
import com.vdoderovic.usermanagementapp.Repositories.CityRepository;
import com.vdoderovic.usermanagementapp.Repositories.CompanyRepository;
import com.vdoderovic.usermanagementapp.Repositories.CountryRepository;
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
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final CompanyRepository companyRepository;

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

    public String creteUser(UserCreateDTO userCreateDTO) {
        User user = userMapper.createDTOtoEntity(userCreateDTO);

        String check = checkForeign(user);
        if(!check.isBlank()) return check;

        userRepository.save(user);
        return "User created successfully.";
    }

    @Transactional
    public String softDelete(Integer id) {
        boolean exists = userRepository.existsById(id);
        if(exists) userRepository.softDeleteById(id);
        return exists ? "User soft deleted." : "No user found with the provided id.";
    }

    public String delete(Integer id) {
        boolean exists = userRepository.existsById(id);
        if(exists) userRepository.deleteById(id);
        return exists ? "User deleted." : "No user found with the provided id.";
    }

    public String updateUser(Integer id, UserUpdateDTO userUpdateDTO) {

        if(!userExists(id))
            return "No user found with the provided id. Created a new user.";

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
        }

        String check = checkForeign(user);
        if(!check.isBlank()) return check;

        userRepository.save(user);
        return "Updated user with the provided id.";
    }

    private String checkForeign(User user) {
        boolean cityExists = cityExists(user.getCity().getId());
        boolean countryExists = countryExists(user.getCountry().getId());
        boolean companyExists = companyExists(user.getCompany().getId());

        if(!cityExists)
            return "City entity with cityId you provided doesn't exist.";

        if(!countryExists)
            return "Country entity with countryId you provided doesn't exist.";

        if(!companyExists)
            return "Company entity with companyId you provided doesn't exist.";

        return "";
    }

    public boolean userExists(Integer userId) {
        return userRepository.existsById(userId);
    }

    public boolean cityExists(Integer cityId) {
        return cityRepository.existsById(cityId);
    }

    public boolean countryExists(Integer countryId) {
        return countryRepository.existsById(countryId);
    }

    public boolean companyExists(Integer companyId) {
        return companyRepository.existsById(companyId);
    }
}
