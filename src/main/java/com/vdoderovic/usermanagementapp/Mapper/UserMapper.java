package com.vdoderovic.usermanagementapp.Mapper;

import com.vdoderovic.usermanagementapp.DTO.User.command.UserCreateDTO;
import com.vdoderovic.usermanagementapp.DTO.User.command.UserUpdateDTO;
import com.vdoderovic.usermanagementapp.DTO.User.query.UserDTO;
import com.vdoderovic.usermanagementapp.DTO.User.query.UserWCompDTO;
import com.vdoderovic.usermanagementapp.Entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "cityProxy", target = "city")
    @Mapping(source = "countryProxy", target = "country")
    @Mapping(source = "companyProxy", target = "company")
    User createDTOtoEntity(UserCreateDTO userCreateDTO);
    @Mapping(source = "cityProxy", target = "city")
    @Mapping(source = "countryProxy", target = "country")
    @Mapping(source = "companyProxy", target = "company")
    User updateDTOtoEntity(UserUpdateDTO userUpdateDTO);
    User toEntity(UserDTO userDTO);
    @Mapping(source = "company", target = "companyDTO")
    UserWCompDTO toUserWCompDTO(User user);
    UserDTO toDTO(User user);
    List<UserDTO> toDTOList(List<User> userList);

}
