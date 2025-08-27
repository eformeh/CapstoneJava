
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   SalaryQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
SALARY   SET   salaryStatus   =   'DELETED',   salaryUpdatedAt   =   GETDATE() 
WHERE   salaryId=:salaryId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
SALARY
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
SALARY   WHERE   salaryStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
SALARY(

 salaryBasicAmount,
 salaryEmployeeId,
 salaryGrossPay,
 salaryNetPay,
 salaryPayPeriodId,
salaryStatus,
salaryCreatedAt,
salaryUpdatedAt
)   VALUES   (

 :salaryBasicAmount,
 :salaryEmployeeId,
 :salaryGrossPay,
 :salaryNetPay,
 :salaryPayPeriodId,
 COALESCE(:salaryStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
SALARY   SET

 salaryBasicAmount = :salaryBasicAmount,
 salaryEmployeeId = :salaryEmployeeId,
 salaryGrossPay = :salaryGrossPay,
 salaryNetPay = :salaryNetPay,
 salaryPayPeriodId = :salaryPayPeriodId,
 salaryStatus=:userStatus,
 salaryUpdatedAt = GETDATE()
WHERE   salaryId=:salaryId
""";


public   static   final   String   READ_BY_SALARY_SALARYBASICAMOUNT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALARY   WHERE   salaryBasicAmount=:salaryBasicAmount   AND   salaryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALARY_SALARYCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALARY   WHERE   salaryCreatedAt=:salaryCreatedAt   AND   salaryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALARY_SALARYEMPLOYEEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALARY   WHERE   salaryEmployeeId=:salaryEmployeeId   AND   salaryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALARY_SALARYGROSSPAY  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALARY   WHERE   salaryGrossPay=:salaryGrossPay   AND   salaryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALARY_SALARYID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALARY   WHERE   salaryId=:salaryId   AND   salaryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALARY_SALARYNETPAY  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALARY   WHERE   salaryNetPay=:salaryNetPay   AND   salaryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALARY_SALARYPAYPERIODID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALARY   WHERE   salaryPayPeriodId=:salaryPayPeriodId   AND   salaryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALARY_SALARYSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALARY   WHERE   salaryStatus=:salaryStatus   AND   salaryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALARY_SALARYUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALARY   WHERE   salaryUpdatedAt=:salaryUpdatedAt   AND   salaryStatus<>'DELETED'
""";



private   SalaryQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
