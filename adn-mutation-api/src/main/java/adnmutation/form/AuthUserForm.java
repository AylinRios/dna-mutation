package adnmutation.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthUserForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
