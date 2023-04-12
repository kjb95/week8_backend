package backend.week8.jwt.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticateClientRequestDto {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
