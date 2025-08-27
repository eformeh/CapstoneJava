
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   OvertimeQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
OVERTIME   SET   overtimeStatus   =   'DELETED',   overtimeUpdatedAt   =   GETDATE() 
WHERE   overtimeId=:overtimeId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
OVERTIME
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
OVERTIME   WHERE   overtimeStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
OVERTIME(

 overtimeDate,
 overtimeEmployeeId,
 overtimeHours,
overtimeStatus,
overtimeCreatedAt,
overtimeUpdatedAt
)   VALUES   (

 :overtimeDate,
 :overtimeEmployeeId,
 :overtimeHours,
 COALESCE(:overtimeStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
OVERTIME   SET

 overtimeDate = :overtimeDate,
 overtimeEmployeeId = :overtimeEmployeeId,
 overtimeHours = :overtimeHours,
 overtimeStatus=:userStatus,
 overtimeUpdatedAt = GETDATE()
WHERE   overtimeId=:overtimeId
""";


public   static   final   String   READ_BY_OVERTIME_OVERTIMECREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
OVERTIME   WHERE   overtimeCreatedAt=:overtimeCreatedAt   AND   overtimeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_OVERTIME_OVERTIMEDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
OVERTIME   WHERE   overtimeDate=:overtimeDate   AND   overtimeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_OVERTIME_OVERTIMEEMPLOYEEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
OVERTIME   WHERE   overtimeEmployeeId=:overtimeEmployeeId   AND   overtimeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_OVERTIME_OVERTIMEHOURS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
OVERTIME   WHERE   overtimeHours=:overtimeHours   AND   overtimeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_OVERTIME_OVERTIMEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
OVERTIME   WHERE   overtimeId=:overtimeId   AND   overtimeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_OVERTIME_OVERTIMESTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
OVERTIME   WHERE   overtimeStatus=:overtimeStatus   AND   overtimeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_OVERTIME_OVERTIMEUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
OVERTIME   WHERE   overtimeUpdatedAt=:overtimeUpdatedAt   AND   overtimeStatus<>'DELETED'
""";



private   OvertimeQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
