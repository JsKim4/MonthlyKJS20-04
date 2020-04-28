package kr.kjs.admin.dto;

import lombok.Getter;

@Getter
public class AdminLoginDTO {
	private String projectId="lotto";
	private String id;
	private String password;
	
	
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
