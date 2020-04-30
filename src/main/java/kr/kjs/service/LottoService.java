package kr.kjs.service;

import java.util.List;

import kr.kjs.dto.LottoDTO;
import kr.kjs.dto.LottoStat;
import kr.kjs.dto.TagInsertInfo;
import kr.kjs.dto.TagSimpleInfo;

public interface LottoService {
	public boolean insertLotto(LottoDTO lottoDTO);
	
	public LottoDTO getLotto(String data,String type);
	
	public List<LottoDTO> getLottoList();
	
	public Integer getLastDrwNo();
	
	public List<LottoStat> getLottoStatList(List<String>tagList);
	
	public Boolean insertTag(String name);

	public List<TagSimpleInfo> getTagList();
	
	public int insertTagList(TagInsertInfo tagInsertInfo);

	public List<String> getLottoTagList(String tagSeq);
	
	public Boolean modifyTagName(TagSimpleInfo tagSimpleInfo);
	
	public Boolean deleteTag(String tagSeq);
	
}
