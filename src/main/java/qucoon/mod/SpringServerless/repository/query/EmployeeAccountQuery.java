
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   EmployeeAccountQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
EMPLOYEE_ACCOUNT   SET   employeeaccountStatus   =   'DELETED',   employeeaccountUpdatedAt   =   GETDATE() 
WHERE   employeeAccountId=:employeeAccountId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ACCOUNT
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
EMPLOYEE_ACCOUNT   WHERE   employeeaccountStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ACCOUNT(

 employeeAccountBankName,
 employeeAccountEmployeeId,
 employeeAccountName,
 employeeAccountNumber,
employeeAccountStatus,
employeeAccountCreatedAt,
employeeAccountUpdatedAt
)   VALUES   (

 :employeeAccountBankName,
 :employeeAccountEmployeeId,
 :employeeAccountName,
 :employeeAccountNumber,
 COALESCE(:employeeAccountStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
EMPLOYEE_ACCOUNT   SET

 employeeAccountBankName = :employeeAccountBankName,
 employeeAccountEmployeeId = :employeeAccountEmployeeId,
 employeeAccountName = :employeeAccountName,
 employeeAccountNumber = :employeeAccountNumber,
 employeeAccountStatus=:userStatus,
 employeeAccountUpdatedAt = GETDATE()
WHERE   employeeAccountId=:employeeAccountId
""";


public   static   final   String   READ_BY_EMPLOYEE_ACCOUNT_EMPLOYEEACCOUNTBANKNAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ACCOUNT   WHERE   employeeAccountBankName=:employeeAccountBankName   AND   employeeaccountStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_ACCOUNT_EMPLOYEEACCOUNTCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ACCOUNT   WHERE   employeeAccountCreatedAt=:employeeAccountCreatedAt   AND   employeeaccountStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_ACCOUNT_EMPLOYEEACCOUNTEMPLOYEEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ACCOUNT   WHERE   employeeAccountEmployeeId=:employeeAccountEmployeeId   AND   employeeaccountStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_ACCOUNT_EMPLOYEEACCOUNTID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ACCOUNT   WHERE   employeeAccountId=:employeeAccountId   AND   employeeaccountStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_ACCOUNT_EMPLOYEEACCOUNTNAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ACCOUNT   WHERE   employeeAccountName=:employeeAccountName   AND   employeeaccountStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_ACCOUNT_EMPLOYEEACCOUNTNUMBER  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ACCOUNT   WHERE   employeeAccountNumber=:employeeAccountNumber   AND   employeeaccountStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_ACCOUNT_EMPLOYEEACCOUNTSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ACCOUNT   WHERE   employeeAccountStatus=:employeeAccountStatus   AND   employeeaccountStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_ACCOUNT_EMPLOYEEACCOUNTUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ACCOUNT   WHERE   employeeAccountUpdatedAt=:employeeAccountUpdatedAt   AND   employeeaccountStatus<>'DELETED'
""";



private   EmployeeAccountQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
