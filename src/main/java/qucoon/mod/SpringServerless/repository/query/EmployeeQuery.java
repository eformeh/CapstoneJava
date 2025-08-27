
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   EmployeeQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
EMPLOYEE   SET   employeeStatus   =   'DELETED',   employeeUpdatedAt   =   GETDATE() 
WHERE   employeeId=:employeeId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
EMPLOYEE
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
EMPLOYEE   WHERE   employeeStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
EMPLOYEE(

 employeeContractEndDate,
 employeeDateOfBirth,
 employeeEmail,
 employeeEmploymentStatus,
 employeeEmploymentType,
 employeeFirstName,
 employeeHireDate,
 employeeJobId,
 employeeLastName,
 employeeMaritalStatus,
 employeeNationality,
 employeePhone,
 employeePhotoUrl,
employeeStatus,
employeeCreatedAt,
employeeUpdatedAt
)   VALUES   (

 :employeeContractEndDate,
 :employeeDateOfBirth,
 :employeeEmail,
 :employeeEmploymentStatus,
 :employeeEmploymentType,
 :employeeFirstName,
 :employeeHireDate,
 :employeeJobId,
 :employeeLastName,
 :employeeMaritalStatus,
 :employeeNationality,
 :employeePhone,
 :employeePhotoUrl,
 COALESCE(:employeeStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
EMPLOYEE   SET

 employeeContractEndDate = :employeeContractEndDate,
 employeeDateOfBirth = :employeeDateOfBirth,
 employeeEmail = :employeeEmail,
 employeeEmploymentStatus = :employeeEmploymentStatus,
 employeeEmploymentType = :employeeEmploymentType,
 employeeFirstName = :employeeFirstName,
 employeeHireDate = :employeeHireDate,
 employeeJobId = :employeeJobId,
 employeeLastName = :employeeLastName,
 employeeMaritalStatus = :employeeMaritalStatus,
 employeeNationality = :employeeNationality,
 employeePhone = :employeePhone,
 employeePhotoUrl = :employeePhotoUrl,
 employeeStatus=:userStatus,
 employeeUpdatedAt = GETDATE()
WHERE   employeeId=:employeeId
""";


public   static   final   String   READ_BY_EMPLOYEE_EMPLOYEECONTRACTENDDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE   WHERE   employeeContractEndDate=:employeeContractEndDate   AND   employeeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_EMPLOYEECREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE   WHERE   employeeCreatedAt=:employeeCreatedAt   AND   employeeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_EMPLOYEEDATEOFBIRTH  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE   WHERE   employeeDateOfBirth=:employeeDateOfBirth   AND   employeeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_EMPLOYEEEMAIL  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE   WHERE   employeeEmail=:employeeEmail   AND   employeeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_EMPLOYEEEMPLOYMENTSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE   WHERE   employeeEmploymentStatus=:employeeEmploymentStatus   AND   employeeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_EMPLOYEEEMPLOYMENTTYPE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE   WHERE   employeeEmploymentType=:employeeEmploymentType   AND   employeeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_EMPLOYEEFIRSTNAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE   WHERE   employeeFirstName=:employeeFirstName   AND   employeeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_EMPLOYEEHIREDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE   WHERE   employeeHireDate=:employeeHireDate   AND   employeeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_EMPLOYEEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE   WHERE   employeeId=:employeeId   AND   employeeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_EMPLOYEEJOBID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE   WHERE   employeeJobId=:employeeJobId   AND   employeeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_EMPLOYEELASTNAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE   WHERE   employeeLastName=:employeeLastName   AND   employeeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_EMPLOYEEMARITALSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE   WHERE   employeeMaritalStatus=:employeeMaritalStatus   AND   employeeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_EMPLOYEENATIONALITY  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE   WHERE   employeeNationality=:employeeNationality   AND   employeeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_EMPLOYEEPHONE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE   WHERE   employeePhone=:employeePhone   AND   employeeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_EMPLOYEEPHOTOURL  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE   WHERE   employeePhotoUrl=:employeePhotoUrl   AND   employeeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_EMPLOYEESTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE   WHERE   employeeStatus=:employeeStatus   AND   employeeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_EMPLOYEEUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE   WHERE   employeeUpdatedAt=:employeeUpdatedAt   AND   employeeStatus<>'DELETED'
""";



private   EmployeeQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
