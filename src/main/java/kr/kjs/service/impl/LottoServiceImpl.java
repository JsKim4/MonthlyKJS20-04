package kr.kjs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kjs.admin.dto.ProjectHistoryInsertDTO;
import kr.kjs.admin.mapper.AdminMapper;
import kr.kjs.dto.LottoDTO;
import kr.kjs.dto.LottoStat;
import kr.kjs.dto.TagInsertInfo;
import kr.kjs.dto.TagSimpleInfo;
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
	public List<LottoDTO> getLottoList() {
		return mapper.getLottoList();
	}

	@Override
	public Integer getLastDrwNo() {
		return mapper.getLastDrwNo();
	}

	@Override
	public Boolean insertTag(String name) {
		mapper.insertTag(name);
		return true;
	}

	@Override
	public List<LottoStat> getLottoStatList(List<String>tagList) {
		return mapper.getLottoStatList(tagList);
	}

	@Override
	public int insertTagList(TagInsertInfo tagInsertInfo) {
		int fail = 0;
		String tagSeq = tagInsertInfo.getTagSeq();
		for(String drwNo:tagInsertInfo.getDrwList()) {
			try {
				mapper.insertLottoTag(tagSeq, drwNo);
			}catch(Exception e) {
				fail++;
				continue;
			}
		}
		if(fail!=0) 
			adminMapper.insertHistory(new ProjectHistoryInsertDTO("warning","tagInsert 실패 보고 "+fail+"/"+tagInsertInfo.getDrwList().size()));
		return fail;
	}

	@Override
	public List<TagSimpleInfo> getTagList() {
		return mapper.getTagList();
	}

	@Override
	public List<String> getLottoTagList(String tagSeq) {
		return mapper.getLottoTagList(tagSeq);
	}

	@Override
	public Boolean modifyTagName(TagSimpleInfo tagSimpleInfo) {
		return mapper.modifyTagName(tagSimpleInfo)==1;
	}

	@Override
	public Boolean deleteTag(String tagSeq) {
		return mapper.deleteTag(tagSeq)==1;
	}

	@Override
	public Integer deleteLottoTag(TagInsertInfo tagInsertInfo) {
		int fail = 0;
		String tagSeq = tagInsertInfo.getTagSeq();
		for(String drwNo:tagInsertInfo.getDrwList()) {
			try {
				mapper.deleteLottoTag(tagSeq, drwNo);
			}catch(Exception e) {
				fail++;
				continue;
			}
		}
		if(fail!=0) 
			adminMapper.insertHistory(new ProjectHistoryInsertDTO("warn","tagDelete 실패 보고 "+fail+"/"+tagInsertInfo.getDrwList().size()));
		return fail;
	}
	
	
	

	
}
