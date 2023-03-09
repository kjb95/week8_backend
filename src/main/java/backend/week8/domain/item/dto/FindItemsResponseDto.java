package backend.week8.domain.item.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindItemsResponseDto {
    private List<ItemDto> items;
}
