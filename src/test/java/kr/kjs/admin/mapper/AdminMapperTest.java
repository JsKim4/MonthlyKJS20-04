package kr.kjs.admin.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.kjs.admin.dto.ProjectHistoryInsertDTO;
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
	
	@Test
	public void test() {
		ProjectHistoryInsertDTO historyDTO = new ProjectHistoryInsertDTO("done", "test내용");
		mapper.insertHistory(historyDTO);mapper.insertHistory(historyDTO);
		mapper.insertHistory(historyDTO);mapper.insertHistory(historyDTO);
	}
}
