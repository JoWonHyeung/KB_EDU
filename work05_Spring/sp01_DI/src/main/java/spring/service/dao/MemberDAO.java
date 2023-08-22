package spring.service.dao;

public interface MemberDAO {
	void register(String id, String name, String address);
	void delete(String id);
}
