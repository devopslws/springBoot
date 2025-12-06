package com.demo.shop._01_users;


import com.demo.shop._00_common.ResponseBuilder;
import com.demo.shop._00_common.models.CreateResDTO;
import com.demo.shop._00_common.models.UpdateResDTO;
import com.demo.shop._01_users.models.LoginReqDTO;
import com.demo.shop._01_users.models.SignupReqDTO;
import com.demo.shop._01_users.models.UpdateUserInfoReqDTO;
import com.demo.shop.entities.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@Tag(name="api_1", description = "회원 가입 기능")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<CreateResDTO> registerUser(@Valid  @RequestBody SignupReqDTO signupReq) {
        int id = userService.registerUser(signupReq);
        return ResponseBuilder.postResponse(String.valueOf(id), new CreateResDTO());
    }

    @GetMapping("/user/{id}")
    public User findUserDetail(@PathVariable int id) {
        return userService.findUserDetail(id);
    }

    @PutMapping("/user")
    public ResponseEntity<UpdateResDTO> updateUser(@Valid  @RequestBody UpdateUserInfoReqDTO updateUserInfoReq) {
        int id = userService.updateUserInfo(updateUserInfoReq);
        return ResponseBuilder.postResponse(String.valueOf(id), new CreateResDTO());
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
