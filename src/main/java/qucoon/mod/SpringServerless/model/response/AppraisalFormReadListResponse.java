package qucoon.mod.SpringServerless.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.*;
import java.util.List;

@Data
@AllArgsConstructor
public class AppraisalFormReadListResponse  {

public String responseCode;
public String responseMessage;
public List<AppraisalForm> data;
}
