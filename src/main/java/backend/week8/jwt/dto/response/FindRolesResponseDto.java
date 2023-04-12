package backend.week8.jwt.dto.response;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
public class FindRolesResponseDto {
	List<String> roles;
}
