
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   UserQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
USER   SET   userStatus   =   'DELETED',   userUpdatedAt   =   GETDATE() 
WHERE   userId=:userId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
USER
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
USER   WHERE   userStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
USER(

 userEmail,
 userEmployeeId,
 userFirstName,
 userLastLoginDate,
 userLastLoginIpAddress,
 userLastName,
 userLoginCount,
 userPassword,
 userRoleId,
userStatus,
userCreatedAt,
userUpdatedAt
)   VALUES   (

 :userEmail,
 :userEmployeeId,
 :userFirstName,
 :userLastLoginDate,
 :userLastLoginIpAddress,
 :userLastName,
 :userLoginCount,
 :userPassword,
 :userRoleId,
 COALESCE(:userStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
USER   SET

 userEmail = :userEmail,
 userEmployeeId = :userEmployeeId,
 userFirstName = :userFirstName,
 userLastLoginDate = :userLastLoginDate,
 userLastLoginIpAddress = :userLastLoginIpAddress,
 userLastName = :userLastName,
 userLoginCount = :userLoginCount,
 userPassword = :userPassword,
 userRoleId = :userRoleId,
 userStatus=:userStatus,
 userUpdatedAt = GETDATE()
WHERE   userId=:userId
""";


public   static   final   String   READ_BY_USER_USERCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
USER   WHERE   userCreatedAt=:userCreatedAt   AND   userStatus<>'DELETED'
""";

public   static   final   String   READ_BY_USER_USEREMAIL  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
USER   WHERE   userEmail=:userEmail   AND   userStatus<>'DELETED'
""";

public   static   final   String   READ_BY_USER_USEREMPLOYEEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
USER   WHERE   userEmployeeId=:userEmployeeId   AND   userStatus<>'DELETED'
""";

public   static   final   String   READ_BY_USER_USERFIRSTNAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
USER   WHERE   userFirstName=:userFirstName   AND   userStatus<>'DELETED'
""";

public   static   final   String   READ_BY_USER_USERID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
USER   WHERE   userId=:userId   AND   userStatus<>'DELETED'
""";

public   static   final   String   READ_BY_USER_USERLASTLOGINDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
USER   WHERE   userLastLoginDate=:userLastLoginDate   AND   userStatus<>'DELETED'
""";

public   static   final   String   READ_BY_USER_USERLASTLOGINIPADDRESS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
USER   WHERE   userLastLoginIpAddress=:userLastLoginIpAddress   AND   userStatus<>'DELETED'
""";

public   static   final   String   READ_BY_USER_USERLASTNAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
USER   WHERE   userLastName=:userLastName   AND   userStatus<>'DELETED'
""";

public   static   final   String   READ_BY_USER_USERLOGINCOUNT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
USER   WHERE   userLoginCount=:userLoginCount   AND   userStatus<>'DELETED'
""";

public   static   final   String   READ_BY_USER_USERPASSWORD  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
USER   WHERE   userPassword=:userPassword   AND   userStatus<>'DELETED'
""";

public   static   final   String   READ_BY_USER_USERROLEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
USER   WHERE   userRoleId=:userRoleId   AND   userStatus<>'DELETED'
""";

public   static   final   String   READ_BY_USER_USERSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
USER   WHERE   userStatus=:userStatus   AND   userStatus<>'DELETED'
""";

public   static   final   String   READ_BY_USER_USERUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
USER   WHERE   userUpdatedAt=:userUpdatedAt   AND   userStatus<>'DELETED'
""";



private   UserQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
