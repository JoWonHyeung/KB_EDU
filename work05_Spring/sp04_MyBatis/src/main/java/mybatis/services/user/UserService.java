package mybatis.services.user;

import java.util.List;

import mybatis.services.domain.User;

public interface UserService {
	void addUser(User user) throws Exception; //Service Layer에서는 반환값 처리 안함.. 왜냐하면 귀찮아서..강사님 스타일...
	void updateUser(User user) throws Exception;
	//int removeUser(String userId) throws Exception;
	
	User getUser(String userId) throws Exception;
	List<User> getUserList(User user) throws Exception;
}
