package com.vdoderovic.usermanagementapp.Controllers;

import com.vdoderovic.usermanagementapp.DTO.User.command.UserCreateDTO;
import com.vdoderovic.usermanagementapp.DTO.User.command.UserUpdateDTO;
import com.vdoderovic.usermanagementapp.DTO.User.query.UserDTO;
import com.vdoderovic.usermanagementapp.DTO.User.query.UserWCompDTO;
import com.vdoderovic.usermanagementapp.Exceptions.UserExceptionDTO;
import com.vdoderovic.usermanagementapp.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get-all-by-company/{id}")
    public ResponseEntity<List<UserWCompDTO>> getAllByCompany(@PathVariable(value = "id") Integer id){
        return new ResponseEntity<>(userService.getAllByCompany(id), HttpStatus.OK);
    }

    @GetMapping("/get-all-deactivated")
    public ResponseEntity<List<UserDTO>> getAllDeactivated(){
        return new ResponseEntity<>(userService.getAllDeactivated(), HttpStatus.OK);
    }

    @GetMapping("/get-all-by-date/{date}")
    public ResponseEntity<List<UserDTO>> getAllByDate(@PathVariable(value = "date") String dateS){
        LocalDate date = LocalDate.parse(dateS);
        return new ResponseEntity<>(userService.getAllByDate(date), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody UserCreateDTO userCreateDTO){
        userService.creteUser(userCreateDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @Valid @RequestBody UserUpdateDTO userUpdateDTO){
        String response = userService.updateUser(id, userUpdateDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/soft-delete/{id}")
    public ResponseEntity<String> softDelete(@PathVariable Integer id){
        String response = userService.softDelete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        String response = userService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
