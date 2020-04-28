package kr.kjs.admin.dto;

import kr.kjs.admin.vo.ProjectVO;
import lombok.Data;

@Data
public class AdminLoginDTO {
	private String project_id=ProjectVO.PROJECT_ID;
	private String id;
	private String password;
	
	
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
