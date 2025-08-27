package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.FinishedGoodDetails;


@Data
public class FinishedGoodDetailsDto  {

private String finishedGoodDetailsCreatedAt;
private String finishedGoodDetailsExpiryDate;
private Integer finishedGoodDetailsId;
private Integer finishedGoodDetailsInventoryItemId;
private String finishedGoodDetailsManufacturingDate;
private Integer finishedGoodDetailsProductId;
private String finishedGoodDetailsStatus;
private String finishedGoodDetailsUpdatedAt;

public static FinishedGoodDetailsDto from(FinishedGoodDetails p) {
    FinishedGoodDetailsDto dto = new FinishedGoodDetailsDto();

    dto.setFinishedGoodDetailsCreatedAt(p.getFinishedGoodDetailsCreatedAt());
    dto.setFinishedGoodDetailsExpiryDate(p.getFinishedGoodDetailsExpiryDate());
    dto.setFinishedGoodDetailsId(p.getFinishedGoodDetailsId());
    dto.setFinishedGoodDetailsInventoryItemId(p.getFinishedGoodDetailsInventoryItemId());
    dto.setFinishedGoodDetailsManufacturingDate(p.getFinishedGoodDetailsManufacturingDate());
    dto.setFinishedGoodDetailsProductId(p.getFinishedGoodDetailsProductId());
    dto.setFinishedGoodDetailsStatus(p.getFinishedGoodDetailsStatus());
    dto.setFinishedGoodDetailsUpdatedAt(p.getFinishedGoodDetailsUpdatedAt());
    return dto;
   }
}
