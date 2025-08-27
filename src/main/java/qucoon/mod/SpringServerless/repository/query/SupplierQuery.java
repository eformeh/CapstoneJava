
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   SupplierQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
SUPPLIER   SET   supplierStatus   =   'DELETED',   supplierUpdatedAt   =   GETDATE() 
WHERE   supplierId=:supplierId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
SUPPLIER
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
SUPPLIER   WHERE   supplierStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
SUPPLIER(

 supplierAddress,
 supplierContactPerson,
 supplierCreatedByUserId,
 supplierEmail,
 supplierName,
 supplierPhoneNumber,
supplierStatus,
supplierCreatedAt,
supplierUpdatedAt
)   VALUES   (

 :supplierAddress,
 :supplierContactPerson,
 :supplierCreatedByUserId,
 :supplierEmail,
 :supplierName,
 :supplierPhoneNumber,
 COALESCE(:supplierStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
SUPPLIER   SET

 supplierAddress = :supplierAddress,
 supplierContactPerson = :supplierContactPerson,
 supplierCreatedByUserId = :supplierCreatedByUserId,
 supplierEmail = :supplierEmail,
 supplierName = :supplierName,
 supplierPhoneNumber = :supplierPhoneNumber,
 supplierStatus=:userStatus,
 supplierUpdatedAt = GETDATE()
WHERE   supplierId=:supplierId
""";


public   static   final   String   READ_BY_SUPPLIER_SUPPLIERADDRESS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SUPPLIER   WHERE   supplierAddress=:supplierAddress   AND   supplierStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SUPPLIER_SUPPLIERCONTACTPERSON  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SUPPLIER   WHERE   supplierContactPerson=:supplierContactPerson   AND   supplierStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SUPPLIER_SUPPLIERCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SUPPLIER   WHERE   supplierCreatedAt=:supplierCreatedAt   AND   supplierStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SUPPLIER_SUPPLIERCREATEDBYUSERID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SUPPLIER   WHERE   supplierCreatedByUserId=:supplierCreatedByUserId   AND   supplierStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SUPPLIER_SUPPLIEREMAIL  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SUPPLIER   WHERE   supplierEmail=:supplierEmail   AND   supplierStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SUPPLIER_SUPPLIERID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SUPPLIER   WHERE   supplierId=:supplierId   AND   supplierStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SUPPLIER_SUPPLIERNAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SUPPLIER   WHERE   supplierName=:supplierName   AND   supplierStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SUPPLIER_SUPPLIERPHONENUMBER  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SUPPLIER   WHERE   supplierPhoneNumber=:supplierPhoneNumber   AND   supplierStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SUPPLIER_SUPPLIERSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SUPPLIER   WHERE   supplierStatus=:supplierStatus   AND   supplierStatus<>'DELETED'
""";

public   static   final   String   READ_BY_SUPPLIER_SUPPLIERUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
SUPPLIER   WHERE   supplierUpdatedAt=:supplierUpdatedAt   AND   supplierStatus<>'DELETED'
""";



private   SupplierQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
