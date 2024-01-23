package com.microservices.user.controller;

import com.microservices.user.dto.UserRecordDTO;
import com.microservices.user.models.UserModel;
import com.microservices.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserModel> save(@RequestBody @Valid UserRecordDTO userRecordDTO) {
        UserModel user = new UserModel();
        BeanUtils.copyProperties(userRecordDTO, user);
        UserModel userToSave = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userToSave);
    }
}
