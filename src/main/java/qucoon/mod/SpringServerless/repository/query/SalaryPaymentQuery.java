
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   SalaryPaymentQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
SALARY_PAYMENT   SET   salarypaymentStatus   =   'DELETED',   salarypaymentUpdatedAt   =   GETDATE() 
WHERE   salaryPaymentId=:salaryPaymentId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
SALARY_PAYMENT
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
SALARY_PAYMENT   WHERE   salarypaymentStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
SALARY_PAYMENT(

 salaryPaymentAmount,
 salaryPaymentApprovedBy,
 salaryPaymentChannel,
 salaryPaymentEmployeeAccountId,
 salaryPaymentSalaryId,
 salaryPaymentTransactionId,
salaryPaymentStatus,
salaryPaymentCreatedAt,
salaryPaymentUpdatedAt
)   VALUES   (

 :salaryPaymentAmount,
 :salaryPaymentApprovedBy,
 :salaryPaymentChannel,
 :salaryPaymentEmployeeAccountId,
 :salaryPaymentSalaryId,
 :salaryPaymentTransactionId,
 COALESCE(:salaryPaymentStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
SALARY_PAYMENT   SET

 salaryPaymentAmount = :salaryPaymentAmount,
 salaryPaymentApprovedBy = :salaryPaymentApprovedBy,
 salaryPaymentChannel = :salaryPaymentChannel,
 salaryPaymentEmployeeAccountId = :salaryPaymentEmployeeAccountId,
 salaryPaymentSalaryId = :salaryPaymentSalaryId,
 salaryPaymentTransactionId = :salaryPaymentTransactionId,
 salaryPaymentStatus=:userStatus,
 salaryPaymentUpdatedAt = GETDATE()
WHERE   salaryPaymentId=:salaryPaymentId
""";


public   static   final   String   READ_BY_SALARY_PAYMENT_SALARYPAYMENTAMOUNT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALARY_PAYMENT   WHERE   salaryPaymentAmount=:salaryPaymentAmount   AND   salarypaymentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALARY_PAYMENT_SALARYPAYMENTAPPROVEDBY  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALARY_PAYMENT   WHERE   salaryPaymentApprovedBy=:salaryPaymentApprovedBy   AND   salarypaymentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALARY_PAYMENT_SALARYPAYMENTCHANNEL  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALARY_PAYMENT   WHERE   salaryPaymentChannel=:salaryPaymentChannel   AND   salarypaymentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALARY_PAYMENT_SALARYPAYMENTCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALARY_PAYMENT   WHERE   salaryPaymentCreatedAt=:salaryPaymentCreatedAt   AND   salarypaymentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALARY_PAYMENT_SALARYPAYMENTEMPLOYEEACCOUNTID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALARY_PAYMENT   WHERE   salaryPaymentEmployeeAccountId=:salaryPaymentEmployeeAccountId   AND   salarypaymentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALARY_PAYMENT_SALARYPAYMENTID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALARY_PAYMENT   WHERE   salaryPaymentId=:salaryPaymentId   AND   salarypaymentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALARY_PAYMENT_SALARYPAYMENTSALARYID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALARY_PAYMENT   WHERE   salaryPaymentSalaryId=:salaryPaymentSalaryId   AND   salarypaymentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALARY_PAYMENT_SALARYPAYMENTSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALARY_PAYMENT   WHERE   salaryPaymentStatus=:salaryPaymentStatus   AND   salarypaymentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALARY_PAYMENT_SALARYPAYMENTTRANSACTIONID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALARY_PAYMENT   WHERE   salaryPaymentTransactionId=:salaryPaymentTransactionId   AND   salarypaymentStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALARY_PAYMENT_SALARYPAYMENTUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALARY_PAYMENT   WHERE   salaryPaymentUpdatedAt=:salaryPaymentUpdatedAt   AND   salarypaymentStatus<>'DELETED'
""";



private   SalaryPaymentQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
