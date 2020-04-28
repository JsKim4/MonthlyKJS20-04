package kr.kjs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kjs.admin.dto.ProjectHistoryInsertDTO;
import kr.kjs.admin.mapper.AdminMapper;
import kr.kjs.dto.LottoDTO;
import kr.kjs.dto.LottoStat;
import kr.kjs.dto.TagInsertInfo;
import kr.kjs.mapper.LottoMapper;
import kr.kjs.service.LottoService;
import lombok.extern.java.Log;

@Service
@Log
public class LottoServiceImpl implements LottoService {

	@Autowired
	LottoMapper mapper;
	
	@Autowired
	AdminMapper adminMapper;
	
	@Override
	public boolean insertLotto(LottoDTO lottoDTO) {
		try {
			log.info(lottoDTO.toString());
			mapper.insertLotto(lottoDTO);
			adminMapper.insertHistory(new ProjectHistoryInsertDTO("done","주간 로또 자동 insert가 성공적으로 종료되었습니다."));
		}catch(Exception e) {
			adminMapper.insertHistory(new ProjectHistoryInsertDTO("exception","주간 로또 자동 insert가 실패하였습니다."));
			return false;
		}
		return true;
		
	}

	@Override
	public LottoDTO getLotto(String data,String type) {
		if(type.equals("drw"))
			return mapper.getLottoByDrwNo(data);
		if(type.equals("date"))
			return mapper.getLottoByDate(data);
		return null;
	}

	@Override
	public Integer getLastDrwNo() {
		return mapper.getLastDrwNo();
	}

	@Override
	public void insertTag(TagInsertInfo tagInsertInfo) {
		String tagSeq = mapper.insertTag(tagInsertInfo.getTagName());
		for(String drwNo:tagInsertInfo.getDrwList()) {
			try {
				mapper.insertLottoTag(tagSeq, drwNo);
			}catch(Exception e) {
				continue;
			}
		}
	}

	@Override
	public List<LottoStat> getLottoStatList(List<String>tagList) {
		return mapper.getLottoStatList(tagList);
	}
	
	
	

	
}
