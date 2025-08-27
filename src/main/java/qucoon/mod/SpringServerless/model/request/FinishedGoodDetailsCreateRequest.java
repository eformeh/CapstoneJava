package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class FinishedGoodDetailsCreateRequest {
public String finishedGoodDetailsExpiryDate;
@NotNull(message = "finishedGoodDetailsInventoryItemId is required")
public int finishedGoodDetailsInventoryItemId;
public String finishedGoodDetailsManufacturingDate;
@NotNull(message = "finishedGoodDetailsProductId is required")
public int finishedGoodDetailsProductId;
}
