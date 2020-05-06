package kr.kjs.admin.mapper;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.kjs.admin.dto.AdminLoginDTO;
import kr.kjs.admin.dto.ProjectHistoryInsertDTO;
import kr.kjs.admin.service.AdminService;
import kr.kjs.mapper.LottoMapper;
import lombok.extern.java.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/admin-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@WebAppConfiguration
@Log
public class AdminMapperTest {
	@Autowired
	AdminMapper mapper;
	
	@Autowired
	AdminService service;
	
	
	@Ignore
	@Test
	public void test() {
		ProjectHistoryInsertDTO historyDTO = new ProjectHistoryInsertDTO("done", "test내용");
	}
	@Ignore
	@Test
	public void testLogin() {
		AdminLoginDTO login = new AdminLoginDTO();
		login.setId("lotto_admin");
		login.setPassword("admin");
		
		log.info(String.valueOf(mapper.login(login)));
	}
	@Ignore
	@Test
	public void testLoginService() {
		AdminLoginDTO loginInfo = new AdminLoginDTO();
		loginInfo.setId("lotto_admin");
		loginInfo.setPassword("admin");
		service.login(loginInfo);
	}
	
	@Autowired
	LottoMapper lmapper;
	@Test
	public void test001() {
		String search[]={"0","0","0","0","0","0"};
		log.info(String.valueOf(lmapper.getLottoSimulationList(search)));
	}
}
