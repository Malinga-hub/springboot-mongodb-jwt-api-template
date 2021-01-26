package spring.security.api.Controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import spring.security.api.Pojos.*;
import spring.security.api.config.AppConfig;
import spring.security.api.services.UserService;
import spring.security.api.util.PayloadUtil;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@Validated
public class UserController {

    @Autowired
    UserService userService;

    //    register user
    @PostMapping("/register")
    public ResponsePayload register(@Valid @RequestBody UserModel userModel, HttpServletResponse res) throws Exception {
        return userService.register(userModel, res);
    }

    //    get user
    @ApiOperation(value = "Authorized request")
    @GetMapping("/getOne/{id}")
    public ResponsePayload getUserById(@PathVariable("id") String id, HttpServletResponse res) {
        return userService.getUserById(id, res);
    }

    //    get all users
    @GetMapping("/all")
    @ApiOperation(value = "Authorized request")
    public ResponsePayload getAllUsers() {
        return userService.getAllUsers();
    }

    //    update user
    @PostMapping("/updateOne")
    @ApiOperation(value = "Authorized request")
    public ResponsePayload updateUser(@Valid @RequestBody UserModel userModel, HttpServletResponse res) {
        return userService.updateUser(userModel, res);
    }

    //    update password
    @PostMapping("/changePassword")
    @ApiOperation(value = "Authorized request")
    public ResponsePayload updateUserPassword(@Valid @RequestBody UpdatePassword updatePassword, HttpServletResponse res) {
        return userService.updateUserPassword(updatePassword, res);
    }

//    send password reset code
    @PostMapping("/password-reset-code")
    @ApiOperation(value = "Authorized request")
    public ResponsePayload sendPasswordResetCode(@Valid @RequestBody PasswordResetCode passwordResetCode, HttpServletResponse res){
        return userService.sendPasswordResetCode(passwordResetCode, res);
    }

//    reset password
    @PostMapping("/reset-password")
    @ApiOperation(value = "Authorized request")
    public ResponsePayload resetPassword(@Valid @RequestBody ResetPassword resetPassword, HttpServletResponse res){
        return userService.resetPassword(resetPassword, res);
    }

    //delete user
    @PostMapping("/deleteOne")
    @ApiOperation(value = "Authorized request")
    public ResponsePayload deleteUser(@Valid @RequestBody DeleteUser deleteUser, HttpServletResponse res) {
        return userService.deleteUser(deleteUser, res);
    }

    //    handle errors
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponsePayload handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        Map<String, Object> errorObject = new HashMap<>();
        errorObject.put("error", errors);

        return PayloadUtil.setPayload(AppConfig.BAD_REQUEST_MSG, AppConfig.BAD_REQUEST_CODE, "0", errorObject);
    }
}
