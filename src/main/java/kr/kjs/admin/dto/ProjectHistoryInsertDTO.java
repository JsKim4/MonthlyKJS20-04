package kr.kjs.admin.dto;

import lombok.Getter;

@Getter
public class ProjectHistoryInsertDTO {
	private String project_id="lotto";
	private String status="done";
	private String content;
	
	public ProjectHistoryInsertDTO(String status,String content){
		this.status = status;
		this.content = content;
	}
	
	
}
