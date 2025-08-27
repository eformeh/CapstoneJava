
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   JournalEntryLineQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
JOURNAL_ENTRY_LINE   SET   journalentrylineStatus   =   'DELETED',   journalentrylineUpdatedAt   =   GETDATE() 
WHERE   journalEntryLineId=:journalEntryLineId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
JOURNAL_ENTRY_LINE
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
JOURNAL_ENTRY_LINE   WHERE   journalentrylineStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
JOURNAL_ENTRY_LINE(

 journalEntryLineAccountId,
 journalEntryLineAmount,
 journalEntryLineEntryType,
 journalEntryLineTransactionId,
journalEntryLineStatus,
journalEntryLineCreatedAt,
journalEntryLineUpdatedAt
)   VALUES   (

 :journalEntryLineAccountId,
 :journalEntryLineAmount,
 :journalEntryLineEntryType,
 :journalEntryLineTransactionId,
 COALESCE(:journalEntryLineStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
JOURNAL_ENTRY_LINE   SET

 journalEntryLineAccountId = :journalEntryLineAccountId,
 journalEntryLineAmount = :journalEntryLineAmount,
 journalEntryLineEntryType = :journalEntryLineEntryType,
 journalEntryLineTransactionId = :journalEntryLineTransactionId,
 journalEntryLineStatus=:userStatus,
 journalEntryLineUpdatedAt = GETDATE()
WHERE   journalEntryLineId=:journalEntryLineId
""";


public   static   final   String   READ_BY_JOURNAL_ENTRY_LINE_JOURNALENTRYLINEACCOUNTID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
JOURNAL_ENTRY_LINE   WHERE   journalEntryLineAccountId=:journalEntryLineAccountId   AND   journalentrylineStatus<>'DELETED'
""";

public   static   final   String   READ_BY_JOURNAL_ENTRY_LINE_JOURNALENTRYLINEAMOUNT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
JOURNAL_ENTRY_LINE   WHERE   journalEntryLineAmount=:journalEntryLineAmount   AND   journalentrylineStatus<>'DELETED'
""";

public   static   final   String   READ_BY_JOURNAL_ENTRY_LINE_JOURNALENTRYLINECREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
JOURNAL_ENTRY_LINE   WHERE   journalEntryLineCreatedAt=:journalEntryLineCreatedAt   AND   journalentrylineStatus<>'DELETED'
""";

public   static   final   String   READ_BY_JOURNAL_ENTRY_LINE_JOURNALENTRYLINEENTRYTYPE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
JOURNAL_ENTRY_LINE   WHERE   journalEntryLineEntryType=:journalEntryLineEntryType   AND   journalentrylineStatus<>'DELETED'
""";

public   static   final   String   READ_BY_JOURNAL_ENTRY_LINE_JOURNALENTRYLINEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
JOURNAL_ENTRY_LINE   WHERE   journalEntryLineId=:journalEntryLineId   AND   journalentrylineStatus<>'DELETED'
""";

public   static   final   String   READ_BY_JOURNAL_ENTRY_LINE_JOURNALENTRYLINESTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
JOURNAL_ENTRY_LINE   WHERE   journalEntryLineStatus=:journalEntryLineStatus   AND   journalentrylineStatus<>'DELETED'
""";

public   static   final   String   READ_BY_JOURNAL_ENTRY_LINE_JOURNALENTRYLINETRANSACTIONID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
JOURNAL_ENTRY_LINE   WHERE   journalEntryLineTransactionId=:journalEntryLineTransactionId   AND   journalentrylineStatus<>'DELETED'
""";

public   static   final   String   READ_BY_JOURNAL_ENTRY_LINE_JOURNALENTRYLINEUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
JOURNAL_ENTRY_LINE   WHERE   journalEntryLineUpdatedAt=:journalEntryLineUpdatedAt   AND   journalentrylineStatus<>'DELETED'
""";



private   JournalEntryLineQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
