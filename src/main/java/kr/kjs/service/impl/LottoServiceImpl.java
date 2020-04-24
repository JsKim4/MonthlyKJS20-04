package kr.kjs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kjs.dto.LottoDTO;
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
	public LottoDTO getLottoByDrwNo(String drwNo) {
		// TODO Auto-generated method stub
		return mapper.getLottoByDrwNo(drwNo);
	}

}
