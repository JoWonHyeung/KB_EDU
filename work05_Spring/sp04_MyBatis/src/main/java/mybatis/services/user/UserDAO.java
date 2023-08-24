package mybatis.services.user;

import java.util.List;

import mybatis.services.domain.User;

//Template... 기능
/*
 * mybatis-userservice-mapping10.xml
 * 쿼리문 태그 id값이 Template 기능의 이름이 된다...
 * 쿼리문 태그 parameterType이 Template 인자값
 * 쿼리문 태그 resultMap, resultType의 값이 Template 기능의 리턴타입과 연결
 */
public interface UserDAO {
	int addUser(User user) throws Exception;
	int updateUser(User user) throws Exception;
	int removeUser(String userId) throws Exception;
	
	User getUser(String userId) throws Exception;
	List<User> getUserList(User user) throws Exception;
}
