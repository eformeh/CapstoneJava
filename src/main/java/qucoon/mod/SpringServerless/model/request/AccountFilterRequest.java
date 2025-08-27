package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AccountFilterRequest {

private String accountAccountName;
private Integer accountAccountTypeId;
private String accountCreatedAt;
private String accountDescription;
private Integer accountId;
private String accountStatus;
private String accountUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
