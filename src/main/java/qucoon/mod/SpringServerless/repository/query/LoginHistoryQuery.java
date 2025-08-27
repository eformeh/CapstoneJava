
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   LoginHistoryQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
LOGIN_HISTORY   SET   loginhistoryStatus   =   'DELETED',   loginhistoryUpdatedAt   =   GETDATE() 
WHERE   loginHistoryId=:loginHistoryId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
LOGIN_HISTORY
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
LOGIN_HISTORY   WHERE   loginhistoryStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
LOGIN_HISTORY(

 loginHistoryDeviceId,
 loginHistoryIpAddress,
 loginHistoryLatitude,
 loginHistoryLongitude,
 loginHistoryUsername,
loginHistoryStatus,
loginHistoryCreatedAt,
loginHistoryUpdatedAt
)   VALUES   (

 :loginHistoryDeviceId,
 :loginHistoryIpAddress,
 :loginHistoryLatitude,
 :loginHistoryLongitude,
 :loginHistoryUsername,
 COALESCE(:loginHistoryStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
LOGIN_HISTORY   SET

 loginHistoryDeviceId = :loginHistoryDeviceId,
 loginHistoryIpAddress = :loginHistoryIpAddress,
 loginHistoryLatitude = :loginHistoryLatitude,
 loginHistoryLongitude = :loginHistoryLongitude,
 loginHistoryUsername = :loginHistoryUsername,
 loginHistoryStatus=:userStatus,
 loginHistoryUpdatedAt = GETDATE()
WHERE   loginHistoryId=:loginHistoryId
""";


public   static   final   String   READ_BY_LOGIN_HISTORY_LOGINHISTORYCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LOGIN_HISTORY   WHERE   loginHistoryCreatedAt=:loginHistoryCreatedAt   AND   loginhistoryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LOGIN_HISTORY_LOGINHISTORYDEVICEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LOGIN_HISTORY   WHERE   loginHistoryDeviceId=:loginHistoryDeviceId   AND   loginhistoryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LOGIN_HISTORY_LOGINHISTORYID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LOGIN_HISTORY   WHERE   loginHistoryId=:loginHistoryId   AND   loginhistoryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LOGIN_HISTORY_LOGINHISTORYIPADDRESS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LOGIN_HISTORY   WHERE   loginHistoryIpAddress=:loginHistoryIpAddress   AND   loginhistoryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LOGIN_HISTORY_LOGINHISTORYLATITUDE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LOGIN_HISTORY   WHERE   loginHistoryLatitude=:loginHistoryLatitude   AND   loginhistoryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LOGIN_HISTORY_LOGINHISTORYLONGITUDE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LOGIN_HISTORY   WHERE   loginHistoryLongitude=:loginHistoryLongitude   AND   loginhistoryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LOGIN_HISTORY_LOGINHISTORYSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LOGIN_HISTORY   WHERE   loginHistoryStatus=:loginHistoryStatus   AND   loginhistoryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LOGIN_HISTORY_LOGINHISTORYUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LOGIN_HISTORY   WHERE   loginHistoryUpdatedAt=:loginHistoryUpdatedAt   AND   loginhistoryStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LOGIN_HISTORY_LOGINHISTORYUSERNAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LOGIN_HISTORY   WHERE   loginHistoryUsername=:loginHistoryUsername   AND   loginhistoryStatus<>'DELETED'
""";



private   LoginHistoryQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
