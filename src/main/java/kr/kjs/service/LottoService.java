package kr.kjs.service;

import kr.kjs.dto.LottoDTO;

public interface LottoService {
	public boolean insertLotto(LottoDTO lottoDTO);
	
	public LottoDTO getLotto(String data,String type);
	
	public Integer getLastDrwNo();
}
