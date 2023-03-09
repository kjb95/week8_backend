package backend.week8.domain.item.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private String itemNo;
    private String itemName;
    private String adultYn;
    private int itemOrgCost;
    private String itemActYn;
}
