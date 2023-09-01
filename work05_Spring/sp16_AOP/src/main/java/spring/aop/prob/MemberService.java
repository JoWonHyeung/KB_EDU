package spring.aop.prob;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/*
 * 비즈니스 로직을 호출하고 있는 서비스 클래스...
 * 핵심적인 로직(Core Concern) 사이사이에
 * 부수적인 로직(Cross-Cutting-Concern)이 산발적으로 존재되어 있다.
 * ::
 * 결과적으로 oop의 본질을 흐리고 있다.
 * ::
 * 해당 코드에서는 부수적인 관심사에 해당하는 로직을 로그파일 풀력으로 정해서 작성하겠다.
 */
public class MemberService {
	
	private Log log = LogFactory.getLog(getClass());
	
	public void register(String name) {
		log.info(name + " :: 회원 등록 시도 합니다...");
		System.out.println("register... logic... 회원 등록 성공");
		log.info(name + " :: 회원 등록 시도 성공 하셨습니다...");
	}
	
	public void findMember(String id) {
		System.out.println("findMember... logic... 회원 검색 성공");
	}
}
