package kr.kjs.service;

import java.util.List;

import kr.kjs.dto.LottoDTO;
import kr.kjs.dto.LottoStat;
import kr.kjs.dto.TagInsertInfo;

public interface LottoService {
	public boolean insertLotto(LottoDTO lottoDTO);
	
	public LottoDTO getLotto(String data,String type);
	
	public Integer getLastDrwNo();
	
	public void insertTag(TagInsertInfo tagInsertInfo);
	
	public List<LottoStat> getLottoStatList(List<String>tagList);
}
