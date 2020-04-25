package kr.kjs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	@Override
	public boolean insertLotto(LottoDTO lottoDTO) {
		try {
			log.info(lottoDTO.toString());
			mapper.insertLotto(lottoDTO);
		}catch(Exception e) {
			return false;
		}
		return true;
		
	}

	@Override
	public LottoDTO getLotto(String data,String type) {
		// TODO Auto-generated method stub
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
		
	}

	@Override
	public List<LottoStat> getLottoStatList(List<String>tagList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	
}
