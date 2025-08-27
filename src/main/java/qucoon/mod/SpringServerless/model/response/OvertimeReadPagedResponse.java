package qucoon.mod.SpringServerless.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.dto.OvertimeDto;
import java.util.List;

@Data
@AllArgsConstructor
public class OvertimeReadPagedResponse {
    private String responseCode;
    private String responseMessage;
    private List<OvertimeDto> data;
    private long totalRecords;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
}
