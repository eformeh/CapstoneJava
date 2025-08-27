package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CheckerQueueFilterRequest {

private String checkerQueueAction;
private Integer checkerQueueCheckerId;
private String checkerQueueCreatedAt;
private Integer checkerQueueId;
private Integer checkerQueueMakerId;
private String checkerQueueModule;
private String checkerQueueReason;
private String checkerQueueRequest;
private String checkerQueueStatus;
private String checkerQueueUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
