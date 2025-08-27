package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Overtime;


@Data
public class OvertimeDto  {

private String overtimeCreatedAt;
private String overtimeDate;
private Integer overtimeEmployeeId;
private Double overtimeHours;
private Integer overtimeId;
private String overtimeStatus;
private String overtimeUpdatedAt;

public static OvertimeDto from(Overtime p) {
    OvertimeDto dto = new OvertimeDto();

    dto.setOvertimeCreatedAt(p.getOvertimeCreatedAt());
    dto.setOvertimeDate(p.getOvertimeDate());
    dto.setOvertimeEmployeeId(p.getOvertimeEmployeeId());
    dto.setOvertimeHours(p.getOvertimeHours());
    dto.setOvertimeId(p.getOvertimeId());
    dto.setOvertimeStatus(p.getOvertimeStatus());
    dto.setOvertimeUpdatedAt(p.getOvertimeUpdatedAt());
    return dto;
   }
}
