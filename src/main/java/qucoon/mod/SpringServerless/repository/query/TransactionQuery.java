
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   TransactionQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
TRANSACTION   SET   transactionStatus   =   'DELETED',   transactionUpdatedAt   =   GETDATE() 
WHERE   transactionId=:transactionId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
TRANSACTION
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
TRANSACTION   WHERE   transactionStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
TRANSACTION(

 transactionAmount,
 transactionDescription,
 transactionNarration,
 transactionReferenceNumber,
 transactionSourceModule,
 transactionSourceReferenceId,
 transactionTransactionCategoryId,
 transactionTransactionDate,
transactionStatus,
transactionCreatedAt,
transactionUpdatedAt
)   VALUES   (

 :transactionAmount,
 :transactionDescription,
 :transactionNarration,
 :transactionReferenceNumber,
 :transactionSourceModule,
 :transactionSourceReferenceId,
 :transactionTransactionCategoryId,
 :transactionTransactionDate,
 COALESCE(:transactionStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
TRANSACTION   SET

 transactionAmount = :transactionAmount,
 transactionDescription = :transactionDescription,
 transactionNarration = :transactionNarration,
 transactionReferenceNumber = :transactionReferenceNumber,
 transactionSourceModule = :transactionSourceModule,
 transactionSourceReferenceId = :transactionSourceReferenceId,
 transactionTransactionCategoryId = :transactionTransactionCategoryId,
 transactionTransactionDate = :transactionTransactionDate,
 transactionStatus=:userStatus,
 transactionUpdatedAt = GETDATE()
WHERE   transactionId=:transactionId
""";


public   static   final   String   READ_BY_TRANSACTION_TRANSACTIONAMOUNT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
TRANSACTION   WHERE   transactionAmount=:transactionAmount   AND   transactionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_TRANSACTION_TRANSACTIONCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
TRANSACTION   WHERE   transactionCreatedAt=:transactionCreatedAt   AND   transactionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_TRANSACTION_TRANSACTIONDESCRIPTION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
TRANSACTION   WHERE   transactionDescription=:transactionDescription   AND   transactionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_TRANSACTION_TRANSACTIONID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
TRANSACTION   WHERE   transactionId=:transactionId   AND   transactionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_TRANSACTION_TRANSACTIONNARRATION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
TRANSACTION   WHERE   transactionNarration=:transactionNarration   AND   transactionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_TRANSACTION_TRANSACTIONREFERENCENUMBER  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
TRANSACTION   WHERE   transactionReferenceNumber=:transactionReferenceNumber   AND   transactionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_TRANSACTION_TRANSACTIONSOURCEMODULE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
TRANSACTION   WHERE   transactionSourceModule=:transactionSourceModule   AND   transactionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_TRANSACTION_TRANSACTIONSOURCEREFERENCEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
TRANSACTION   WHERE   transactionSourceReferenceId=:transactionSourceReferenceId   AND   transactionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_TRANSACTION_TRANSACTIONSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
TRANSACTION   WHERE   transactionStatus=:transactionStatus   AND   transactionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_TRANSACTION_TRANSACTIONTRANSACTIONCATEGORYID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
TRANSACTION   WHERE   transactionTransactionCategoryId=:transactionTransactionCategoryId   AND   transactionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_TRANSACTION_TRANSACTIONTRANSACTIONDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
TRANSACTION   WHERE   transactionTransactionDate=:transactionTransactionDate   AND   transactionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_TRANSACTION_TRANSACTIONUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
TRANSACTION   WHERE   transactionUpdatedAt=:transactionUpdatedAt   AND   transactionStatus<>'DELETED'
""";



private   TransactionQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
