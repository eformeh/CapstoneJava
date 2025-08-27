package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class SupplierCreateRequest {
public String supplierAddress;
public String supplierContactPerson;
@NotNull(message = "supplierCreatedByUserId is required")
public int supplierCreatedByUserId;
public String supplierEmail;
public String supplierName;
public String supplierPhoneNumber;
}
