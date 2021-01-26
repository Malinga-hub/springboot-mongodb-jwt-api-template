package spring.security.api.Pojos;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

public class DeleteUser {

    @ApiModelProperty(required = true)
    @NotEmpty(message = "id is required")
    private String id;

    public String getId() {
        return id;
    }
}
