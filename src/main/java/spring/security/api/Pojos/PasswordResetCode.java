package spring.security.api.Pojos;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import spring.security.api.config.AppConfig;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Document(collection = "passwordResetCode")
public class PasswordResetCode {

    @ApiModelProperty(required = true)
    @Id
    private String id;

    @ApiModelProperty(required = true)
    @NotEmpty(message = "email is required")
    @Email(message = "invalid email")
    @Pattern(regexp = AppConfig.EMAIL_REGEX, message = "invalid email")
    @Indexed(unique = true)
    private String email;

    @ApiModelProperty(required = true)
    private String code;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
