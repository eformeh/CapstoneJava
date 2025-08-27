
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   CustomerQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
CUSTOMER   SET   customerStatus   =   'DELETED',   customerUpdatedAt   =   GETDATE() 
WHERE   customerId=:customerId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
CUSTOMER
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
CUSTOMER   WHERE   customerStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
CUSTOMER(

 customerAddress,
 customerCompanyName,
 customerCreditBalance,
 customerEmail,
 customerName,
 customerNotes,
 customerPhone,
 customerType,
customerStatus,
customerCreatedAt,
customerUpdatedAt
)   VALUES   (

 :customerAddress,
 :customerCompanyName,
 :customerCreditBalance,
 :customerEmail,
 :customerName,
 :customerNotes,
 :customerPhone,
 :customerType,
 COALESCE(:customerStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
CUSTOMER   SET

 customerAddress = :customerAddress,
 customerCompanyName = :customerCompanyName,
 customerCreditBalance = :customerCreditBalance,
 customerEmail = :customerEmail,
 customerName = :customerName,
 customerNotes = :customerNotes,
 customerPhone = :customerPhone,
 customerType = :customerType,
 customerStatus=:userStatus,
 customerUpdatedAt = GETDATE()
WHERE   customerId=:customerId
""";


public   static   final   String   READ_BY_CUSTOMER_CUSTOMERADDRESS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CUSTOMER   WHERE   customerAddress=:customerAddress   AND   customerStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CUSTOMER_CUSTOMERCOMPANYNAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CUSTOMER   WHERE   customerCompanyName=:customerCompanyName   AND   customerStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CUSTOMER_CUSTOMERCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CUSTOMER   WHERE   customerCreatedAt=:customerCreatedAt   AND   customerStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CUSTOMER_CUSTOMERCREDITBALANCE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CUSTOMER   WHERE   customerCreditBalance=:customerCreditBalance   AND   customerStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CUSTOMER_CUSTOMEREMAIL  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CUSTOMER   WHERE   customerEmail=:customerEmail   AND   customerStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CUSTOMER_CUSTOMERID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CUSTOMER   WHERE   customerId=:customerId   AND   customerStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CUSTOMER_CUSTOMERNAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CUSTOMER   WHERE   customerName=:customerName   AND   customerStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CUSTOMER_CUSTOMERNOTES  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CUSTOMER   WHERE   customerNotes=:customerNotes   AND   customerStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CUSTOMER_CUSTOMERPHONE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CUSTOMER   WHERE   customerPhone=:customerPhone   AND   customerStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CUSTOMER_CUSTOMERSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CUSTOMER   WHERE   customerStatus=:customerStatus   AND   customerStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CUSTOMER_CUSTOMERTYPE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CUSTOMER   WHERE   customerType=:customerType   AND   customerStatus<>'DELETED'
""";

public   static   final   String   READ_BY_CUSTOMER_CUSTOMERUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
CUSTOMER   WHERE   customerUpdatedAt=:customerUpdatedAt   AND   customerStatus<>'DELETED'
""";



private   CustomerQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
