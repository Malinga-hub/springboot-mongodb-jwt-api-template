package spring.security.api.Pojos;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.mongodb.core.index.Indexed;
import spring.security.api.config.AppConfig;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ResetPassword {

    @ApiModelProperty(required = true)
    @NotEmpty(message = "reset code is required")
    @Size(max = 4, message = "reset code must be 4 characters")
    private String resetCode;

    @ApiModelProperty(required = true)
    @NotEmpty(message = "email is required")
    @Email(message = "invalid email")
    @Pattern(regexp = AppConfig.EMAIL_REGEX, message = "invalid email")
    private String email;

    @ApiModelProperty(required = true)
    @NotEmpty(message = "new password is required")
    @Size(min = 4, message = AppConfig.MIN_LENGTH_PASSWORD_MSG)
    private String newPassword;

    public String getResetCode() {
        return resetCode;
    }

    public void setResetCode(String resetCode) {
        this.resetCode = resetCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
