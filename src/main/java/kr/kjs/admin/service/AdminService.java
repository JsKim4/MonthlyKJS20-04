package kr.kjs.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kjs.admin.dto.AdminLoginDTO;
import kr.kjs.admin.mapper.AdminMapper;
import lombok.extern.java.Log;

@Service
@Log
public class AdminService {
	
	@Autowired
	AdminMapper mapper;

	public Boolean login(AdminLoginDTO loginDTO) {
		return mapper.login(loginDTO)==1;
	}
}
