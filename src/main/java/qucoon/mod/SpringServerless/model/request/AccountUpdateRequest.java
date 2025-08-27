package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AccountUpdateRequest {
public String accountAccountName;
public int accountAccountTypeId;
public String accountCreatedAt;
public String accountDescription;
public int accountId;
public String accountStatus;
public String accountUpdatedAt;
}
