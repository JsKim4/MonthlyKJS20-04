package kr.kjs.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.kjs.admin.dto.AdminLoginDTO;
import kr.kjs.admin.dto.ProjectHistoryInsertDTO;

@Mapper
public interface AdminMapper {
	public String login(AdminLoginDTO loginDTO);
	
	public void insertHistory(ProjectHistoryInsertDTO historyDTO);
}
