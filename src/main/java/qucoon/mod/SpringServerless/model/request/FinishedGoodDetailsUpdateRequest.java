package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FinishedGoodDetailsUpdateRequest {
public String finishedGoodDetailsCreatedAt;
public String finishedGoodDetailsExpiryDate;
public int finishedGoodDetailsId;
public int finishedGoodDetailsInventoryItemId;
public String finishedGoodDetailsManufacturingDate;
public int finishedGoodDetailsProductId;
public String finishedGoodDetailsStatus;
public String finishedGoodDetailsUpdatedAt;
}
