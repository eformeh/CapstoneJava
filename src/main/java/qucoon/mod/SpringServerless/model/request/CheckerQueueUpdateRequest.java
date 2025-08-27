package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CheckerQueueUpdateRequest {
public String checkerQueueAction;
public int checkerQueueCheckerId;
public String checkerQueueCreatedAt;
public int checkerQueueId;
public int checkerQueueMakerId;
public String checkerQueueModule;
public String checkerQueueReason;
public String checkerQueueRequest;
public String checkerQueueStatus;
public String checkerQueueUpdatedAt;
}
