package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SupplierUpdateRequest {
public String supplierAddress;
public String supplierContactPerson;
public String supplierCreatedAt;
public int supplierCreatedByUserId;
public String supplierEmail;
public int supplierId;
public String supplierName;
public String supplierPhoneNumber;
public String supplierStatus;
public String supplierUpdatedAt;
}
