package qucoon.mod.SpringServerless.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.*;
import java.util.List;

@Data
@AllArgsConstructor
public class EmployeeOnboardingReadListResponse  {

public String responseCode;
public String responseMessage;
public List<EmployeeOnboarding> data;
}
