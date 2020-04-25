package kr.kjs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.kjs.dto.LottoDTO;
import kr.kjs.dto.LottoStat;
@Mapper
public interface LottoMapper {
	public void insertLotto(LottoDTO lottoDTO);
	
	public LottoDTO getLottoByDrwNo(@Param("drwNo")String drwNo);
	
	public LottoDTO getLottoByDate(@Param("searchDate")String date);
	
	public Integer getLastDrwNo();
	
	public List<LottoStat> getLottoStatList(@Param("tagList")List<String> tagList);
	
	public String insertTag(String tagName);
	
	public void insertLottoTag(@Param("tagSesq")String tagSeq,@Param("lottoList") String drwNo);
}
