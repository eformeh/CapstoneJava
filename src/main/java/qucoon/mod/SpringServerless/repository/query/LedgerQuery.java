
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   LedgerQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
LEDGER   SET   ledgerStatus   =   'DELETED',   ledgerUpdatedAt   =   GETDATE() 
WHERE   ledgerId=:ledgerId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
LEDGER
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
LEDGER   WHERE   ledgerStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
LEDGER(

 ledgerAccountId,
 ledgerBalanceAfter,
 ledgerCredit,
 ledgerDebit,
 ledgerjournalEntryLineAccountId,
ledgerStatus,
ledgerCreatedAt,
ledgerUpdatedAt
)   VALUES   (

 :ledgerAccountId,
 :ledgerBalanceAfter,
 :ledgerCredit,
 :ledgerDebit,
 :ledgerjournalEntryLineAccountId,
 COALESCE(:ledgerStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
LEDGER   SET

 ledgerAccountId = :ledgerAccountId,
 ledgerBalanceAfter = :ledgerBalanceAfter,
 ledgerCredit = :ledgerCredit,
 ledgerDebit = :ledgerDebit,
 ledgerjournalEntryLineAccountId = :ledgerjournalEntryLineAccountId,
 ledgerStatus=:userStatus,
 ledgerUpdatedAt = GETDATE()
WHERE   ledgerId=:ledgerId
""";


public   static   final   String   READ_BY_LEDGER_LEDGERACCOUNTID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEDGER   WHERE   ledgerAccountId=:ledgerAccountId   AND   ledgerStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEDGER_LEDGERBALANCEAFTER  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEDGER   WHERE   ledgerBalanceAfter=:ledgerBalanceAfter   AND   ledgerStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEDGER_LEDGERCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEDGER   WHERE   ledgerCreatedAt=:ledgerCreatedAt   AND   ledgerStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEDGER_LEDGERCREDIT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEDGER   WHERE   ledgerCredit=:ledgerCredit   AND   ledgerStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEDGER_LEDGERDEBIT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEDGER   WHERE   ledgerDebit=:ledgerDebit   AND   ledgerStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEDGER_LEDGERID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEDGER   WHERE   ledgerId=:ledgerId   AND   ledgerStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEDGER_LEDGERJOURNALENTRYLINEACCOUNTID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEDGER   WHERE   ledgerjournalEntryLineAccountId=:ledgerjournalEntryLineAccountId   AND   ledgerStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEDGER_LEDGERSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEDGER   WHERE   ledgerStatus=:ledgerStatus   AND   ledgerStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEDGER_LEDGERUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEDGER   WHERE   ledgerUpdatedAt=:ledgerUpdatedAt   AND   ledgerStatus<>'DELETED'
""";



private   LedgerQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
