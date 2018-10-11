package com.brainmentors.testengine.util.constants;

public interface QueryConstants {
  String login_sql="SELECT USER_MST.USERID,ROLE_MST.NAME AS ROLENAME,RIGHT_MST.NAME AS RIGHTNAME,RIGHT_MST.SCREENNAME FROM USER_MST, ROLE_MST,RIGHT_MST,USER_ROLE_MAPPING,ROLE_RIGHT_MAPPING   WHERE USER_MST.UID=USER_ROLE_MAPPING.UID AND ROLE_MST.ROLEID=USER_ROLE_MAPPING.ROLEID AND ROLE_MST.ROLEID=ROLE_RIGHT_MAPPING.ROLEID AND RIGHT_MST.RIGHTID=ROLE_RIGHT_MAPPING.RIGHTID AND USER_MST.USERID=? and USER_MST.PASSWORD=? and authentication='yes'";
  String REGISTER_SQL = "insert into user_mst(firstname,lastname,emailid,phoneno,password,confirmpassword,selectcity,selectcollege,selectstream,selectusertype,gender,dateofbirth,collegeid,userid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	String QUESTION_UPLOAD_SQL = "insert into question(qno,name,ans1,ans2,ans3,ans4,rans,score) values(?,?,?,?,?,?,?,?)";
	String fetchUnmpapped = " select qid,qno,name ,ans1,ans2,ans3,ans3,ans4,rans,score from question where status='NO'";
	String searchRecord ="select * from user_mst where emailid=? or phoneno=? or collegeid=?  ";
    String fetchUserRecord="select firstname,lastname,emailid,phoneno,password,confirmpassword,selectcity,selectcollege,selectstream,selectusertype,gender,dateofbirth,collegeid,userid,uid from user_mst where authentication='no' " ;
    String setUserRole="insert into user_role_mapping(uid,roleid) values(?,?) ";
    String setRoleRightMapping="insert into role_right_mapping(rightid,roleid) values(?,?) ";
    String updateTest ="insert into test(testname,testtime) values(?,?) ";
    String findTest="select * from test where testname=? ";
    String getTestId="select testid from test where testname =?";
    String testQuesMap="insert into testmap(testid,qid) values(?,?)  ";
    String fetchTest =" select  testname from test ";
    String UserAuthentication=" update user_mst set authentication=? where uid=?  ";
    String fetchTime ="select testtime from test where testname=?";
    String firstMapping="select qid,qno,name,ans1,ans2,ans3,ans4,rans,score from question";
    String StatusUpdate="update question set status=? where qid=? ";
     String fetchMappedQuestion="select question.qno,question.qid,question.name ,question.ans1,question.ans2,question.ans3,question.ans3,question.ans4,question.rans,question.score from question,test,testmap where test.testid=testmap.testid and testmap.qid=question.qid  and testname=?";
}