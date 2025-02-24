package me._1rr.resource.rest;

import lombok.extern.slf4j.Slf4j;
import me._1rr.resource.dto.UserDto;
import me._1rr.resource.service.UserService;
import me._1rr.resource.vo.UserVo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("api/users")
public class UserRest {

    private final UserService userService;

    public UserRest(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<?> addNewUser(
            @Validated(UserDto.CreateUser.class)
            @RequestBody
            UserDto userDto
    ) {
        String username = userService.createNewUser(userDto);
        URI location = URI.create("/api/users?username=" + username);
        return ResponseEntity
                .created(location)
                .build();
    }

    @GetMapping("")
    public ResponseEntity<UserVo> getUserByUsername(
            @AuthenticationPrincipal Jwt jwt
    ) {
        UserVo userVo = userService.getUserByUsername(jwt.getSubject());
        return ResponseEntity.ok(userVo);
    }

    @PutMapping("")
    public ResponseEntity<Void> updateUserByUsername(
            @AuthenticationPrincipal Jwt jwt,
            @RequestBody UserDto userDto
    ) {
        userService.updateUserByUsername(jwt.getSubject(), userDto);
        return ResponseEntity
                .noContent()
                .build();
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteUserByUsername(
            @AuthenticationPrincipal Jwt jwt
    ) {
        userService.deleteUserByUsername(jwt.getSubject());
        return ResponseEntity
                .noContent()
                .build();
    }
}
