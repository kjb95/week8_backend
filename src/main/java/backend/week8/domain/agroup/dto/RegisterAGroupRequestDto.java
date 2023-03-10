package backend.week8.domain.agroup.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterAGroupRequestDto {
    private String aGroupName;
}
