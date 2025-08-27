package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.CheckerQueue;


@Data
public class CheckerQueueDto  {

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

public static CheckerQueueDto from(CheckerQueue p) {
    CheckerQueueDto dto = new CheckerQueueDto();

    dto.setCheckerQueueAction(p.getCheckerQueueAction());
    dto.setCheckerQueueCheckerId(p.getCheckerQueueCheckerId());
    dto.setCheckerQueueCreatedAt(p.getCheckerQueueCreatedAt());
    dto.setCheckerQueueId(p.getCheckerQueueId());
    dto.setCheckerQueueMakerId(p.getCheckerQueueMakerId());
    dto.setCheckerQueueModule(p.getCheckerQueueModule());
    dto.setCheckerQueueReason(p.getCheckerQueueReason());
    dto.setCheckerQueueRequest(p.getCheckerQueueRequest());
    dto.setCheckerQueueStatus(p.getCheckerQueueStatus());
    dto.setCheckerQueueUpdatedAt(p.getCheckerQueueUpdatedAt());
    return dto;
   }
}
