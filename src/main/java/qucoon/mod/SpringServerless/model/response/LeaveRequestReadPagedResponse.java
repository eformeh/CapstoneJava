package qucoon.mod.SpringServerless.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.dto.LeaveRequestDto;
import java.util.List;

@Data
@AllArgsConstructor
public class LeaveRequestReadPagedResponse {
    private String responseCode;
    private String responseMessage;
    private List<LeaveRequestDto> data;
    private long totalRecords;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
}
