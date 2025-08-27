package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class FinishedGoodDetailsFilterRequest {

private String finishedGoodDetailsCreatedAt;
private String finishedGoodDetailsExpiryDate;
private Integer finishedGoodDetailsId;
private Integer finishedGoodDetailsInventoryItemId;
private String finishedGoodDetailsManufacturingDate;
private Integer finishedGoodDetailsProductId;
private String finishedGoodDetailsStatus;
private String finishedGoodDetailsUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
