package kr.kjs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.kjs.dto.LottoDTO;
import kr.kjs.dto.LottoSearchDTO;
import kr.kjs.dto.LottoSimulationDTO;
import kr.kjs.dto.LottoStat;
import kr.kjs.dto.TagSimpleInfo;
@Mapper
public interface LottoMapper {
	public void insertLotto(LottoDTO lottoDTO);
	
	public LottoDTO getLottoByDrwNo(@Param("drwNo")String drwNo);
	
	public LottoDTO getLottoByDate(@Param("searchDate")String date);
	
	public List<LottoDTO> getLottoList();
	
	public Integer getLastDrwNo();
	
	public List<LottoStat> getLottoStatList(LottoSearchDTO searchDTO);
	
	public void insertTag(String tagName);
	
	public List<TagSimpleInfo> getTagList();
	
	public void insertLottoTag(@Param("tagSesq")String tagSeq,@Param("drwNo") String drwNo);
	
	public List<String> getLottoTagList(String tagSeq);
	
	public int modifyTagName(TagSimpleInfo tagSimpleInfo);
	
	public int deleteTag(String tagSeq);
	
	public int deleteLottoTag(@Param("tagSeq")String tagSeq);

	public List<LottoSimulationDTO>getLottoSimulationList(@Param("search")String[] search);
}
