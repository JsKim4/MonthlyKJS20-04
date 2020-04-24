package kr.kjs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.kjs.dto.LottoDTO;
@Mapper
public interface LottoMapper {
	public void insertLotto(LottoDTO lottoDTO);
	
	public LottoDTO getLottoByDrwNo(@Param("drwNo")String drwNo);
}
