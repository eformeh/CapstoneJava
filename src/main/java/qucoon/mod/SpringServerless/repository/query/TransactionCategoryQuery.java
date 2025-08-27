
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   TransactionCategoryQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
TRANSACTION_CATEGORY   SET   transactioncategoryStatus   =   'DELETED',   transactioncategoryUpdatedAt   =   GETDATE() 
WHERE   transactionCategoryId=:transactionCategoryId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
TRANSACTION_CATEGORY
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
TRANSACTION_CATEGORY   WHERE   transactioncategoryStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
TRANSACTION_CATEGORY(

 transactionCategoryDescription,
 transactionCategoryName,
 transactionCategoryTransactionNature,
transactionCategoryStatus,
transactionCategoryCreatedAt,
transactionCategoryUpdatedAt
)   VALUES   (

 :transactionCategoryDescription,
 :transactionCategoryName,
 :transactionCategoryTransactionNature,
 COALESCE(:transactionCategoryStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
TRANSACTION_CATEGORY   SET

 transactionCategoryDescription = :transactionCategoryDescription,
 transactionCategoryName = :transactionCategoryName,
 transactionCategoryTransactionNature = :transactionCategoryTransactionNature,
 transactionCategoryStatus=:userStatus,
 transactionCategoryUpdatedAt = GETDATE()
WHERE   transactionCategoryId=:transactionCategoryId
""";


public   static   final   String   READ_BY_TRANSACTION_CATEGORY_TRANSACTIONCATEGORYCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
TRANSACTION_CATEGORY   WHERE   transactionCategoryCreatedAt=:transactionCategoryCreatedAt   AND   transactioncategoryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_TRANSACTION_CATEGORY_TRANSACTIONCATEGORYDESCRIPTION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
TRANSACTION_CATEGORY   WHERE   transactionCategoryDescription=:transactionCategoryDescription   AND   transactioncategoryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_TRANSACTION_CATEGORY_TRANSACTIONCATEGORYID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
TRANSACTION_CATEGORY   WHERE   transactionCategoryId=:transactionCategoryId   AND   transactioncategoryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_TRANSACTION_CATEGORY_TRANSACTIONCATEGORYNAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
TRANSACTION_CATEGORY   WHERE   transactionCategoryName=:transactionCategoryName   AND   transactioncategoryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_TRANSACTION_CATEGORY_TRANSACTIONCATEGORYSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
TRANSACTION_CATEGORY   WHERE   transactionCategoryStatus=:transactionCategoryStatus   AND   transactioncategoryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_TRANSACTION_CATEGORY_TRANSACTIONCATEGORYTRANSACTIONNATURE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
TRANSACTION_CATEGORY   WHERE   transactionCategoryTransactionNature=:transactionCategoryTransactionNature   AND   transactioncategoryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_TRANSACTION_CATEGORY_TRANSACTIONCATEGORYUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
TRANSACTION_CATEGORY   WHERE   transactionCategoryUpdatedAt=:transactionCategoryUpdatedAt   AND   transactioncategoryStatus<>'DELETED'
""";



private   TransactionCategoryQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
