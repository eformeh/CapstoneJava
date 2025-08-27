
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   SalePaymentLogQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
SALE_PAYMENT_LOG   SET   salepaymentlogStatus   =   'DELETED',   salepaymentlogUpdatedAt   =   GETDATE() 
WHERE   salePaymentLogid=:salePaymentLogid
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
SALE_PAYMENT_LOG
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
SALE_PAYMENT_LOG   WHERE   salepaymentlogStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
SALE_PAYMENT_LOG(

 salePaymentLogAmount,
 salePaymentLogEmployeeid,
 salePaymentLogMethod,
 salePaymentLogNotes,
 salePaymentLogSaleid,
 salePaymentUpdatedAt,
salePaymentLogStatus,
salePaymentLogCreatedAt,
salePaymentLogUpdatedAt
)   VALUES   (

 :salePaymentLogAmount,
 :salePaymentLogEmployeeid,
 :salePaymentLogMethod,
 :salePaymentLogNotes,
 :salePaymentLogSaleid,
 :salePaymentUpdatedAt,
 COALESCE(:salePaymentLogStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
SALE_PAYMENT_LOG   SET

 salePaymentLogAmount = :salePaymentLogAmount,
 salePaymentLogEmployeeid = :salePaymentLogEmployeeid,
 salePaymentLogMethod = :salePaymentLogMethod,
 salePaymentLogNotes = :salePaymentLogNotes,
 salePaymentLogSaleid = :salePaymentLogSaleid,
 salePaymentUpdatedAt = :salePaymentUpdatedAt,
 salePaymentLogStatus=:userStatus,
 salePaymentLogUpdatedAt = GETDATE()
WHERE   salePaymentLogid=:salePaymentLogid
""";


public   static   final   String   READ_BY_SALE_PAYMENT_LOG_SALEPAYMENTLOGAMOUNT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_PAYMENT_LOG   WHERE   salePaymentLogAmount=:salePaymentLogAmount   AND   salepaymentlogStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_PAYMENT_LOG_SALEPAYMENTLOGCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_PAYMENT_LOG   WHERE   salePaymentLogCreatedAt=:salePaymentLogCreatedAt   AND   salepaymentlogStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_PAYMENT_LOG_SALEPAYMENTLOGEMPLOYEEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_PAYMENT_LOG   WHERE   salePaymentLogEmployeeid=:salePaymentLogEmployeeid   AND   salepaymentlogStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_PAYMENT_LOG_SALEPAYMENTLOGID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_PAYMENT_LOG   WHERE   salePaymentLogid=:salePaymentLogid   AND   salepaymentlogStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_PAYMENT_LOG_SALEPAYMENTLOGMETHOD  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_PAYMENT_LOG   WHERE   salePaymentLogMethod=:salePaymentLogMethod   AND   salepaymentlogStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_PAYMENT_LOG_SALEPAYMENTLOGNOTES  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_PAYMENT_LOG   WHERE   salePaymentLogNotes=:salePaymentLogNotes   AND   salepaymentlogStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_PAYMENT_LOG_SALEPAYMENTLOGSALEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_PAYMENT_LOG   WHERE   salePaymentLogSaleid=:salePaymentLogSaleid   AND   salepaymentlogStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_PAYMENT_LOG_SALEPAYMENTLOGSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_PAYMENT_LOG   WHERE   salePaymentLogStatus=:salePaymentLogStatus   AND   salepaymentlogStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SALE_PAYMENT_LOG_SALEPAYMENTUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SALE_PAYMENT_LOG   WHERE   salePaymentUpdatedAt=:salePaymentUpdatedAt   AND   salepaymentlogStatus<>'DELETED'
""";



private   SalePaymentLogQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
