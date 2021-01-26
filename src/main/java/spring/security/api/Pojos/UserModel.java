package spring.security.api.Pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import spring.security.api.config.AppConfig;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Document(collection = "users")
public class UserModel implements Serializable {

    //    variables
    @ApiModelProperty(notes = "auto-generated", required=false)
    @Id
    private String id;

    @ApiModelProperty(required = true)
    @NotEmpty(message = "firstName is required")
    private String firstName;

    @ApiModelProperty(required = true)
    @NotEmpty(message = "lastName is required")
    private String lastName;

    @ApiModelProperty(notes = "auto-generated", required=false)
    @Indexed(unique = true)
    private String username;

    @ApiModelProperty(required = true)
    @NotEmpty(message = "email is required")
    @Email(message = "invalid email")
    @Pattern(regexp = AppConfig.EMAIL_REGEX, message = "invalid email")
    @Indexed(unique = true)
    private String email;

    @ApiModelProperty(required = true)
    @NotEmpty(message = "phoneNumber is required")
    @Size(max = 12, min = 9, message = "invalid number of characters")
    @Pattern(regexp = "^[0-9]+", message = "invalid phone number")
    private String phoneNumber;

    @ApiModelProperty(required=false)
    private String address;

    @ApiModelProperty(required = true)
    @JsonProperty(value = "password", access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ApiModelProperty(notes = "auto-generated", required=false)
    private String createdAt;

    @ApiModelProperty(notes = "auto-generated", required=false)
    private String updatedAt;

//    public UserModel() {
//    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String firstName, String lastName) {
        this.username = firstName + " " + lastName;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
