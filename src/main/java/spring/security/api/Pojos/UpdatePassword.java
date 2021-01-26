package spring.security.api.Pojos;

import io.swagger.annotations.ApiModelProperty;
import spring.security.api.config.AppConfig;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UpdatePassword {

    @ApiModelProperty(required = true)
    @NotEmpty(message = "Id is required")
    private String id;

    @ApiModelProperty(required = true)
    @NotEmpty(message = "Old password is required")
    @Size(min = 4, message = AppConfig.MIN_LENGTH_PASSWORD_MSG)
    private String oldPassword;

    @ApiModelProperty(required = true)
    @NotEmpty(message = "new password is required")
    @Size(min = 4, message = AppConfig.MIN_LENGTH_PASSWORD_MSG)
    private String newPassword;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
