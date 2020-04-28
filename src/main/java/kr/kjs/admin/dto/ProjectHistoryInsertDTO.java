package kr.kjs.admin.dto;

import kr.kjs.admin.vo.ProjectVO;
import lombok.Getter;

@Getter
public class ProjectHistoryInsertDTO {
	private String project_id=ProjectVO.PROJECT_ID;
	private String status="done";
	private String content;
	
	public ProjectHistoryInsertDTO(String status,String content){
		this.status = status;
		this.content = content;
	}
	
	
}
