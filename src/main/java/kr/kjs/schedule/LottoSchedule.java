package kr.kjs.schedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import kr.kjs.admin.service.AdminService;
import kr.kjs.dto.LottoDTO;
import kr.kjs.service.LottoService;
import lombok.extern.java.Log;


@Log
public class LottoSchedule {
	
	@Autowired
	LottoService service;

	@Autowired
	AdminService adminService;
	
	@Autowired
	RestTemplate restTemplate;

	static final String LOTTO_URL = "http://www.nlotto.co.kr/common.do?method=getLottoNumber&drwNo=";
	
	
	@Scheduled(cron = "* * 21 * * 6")
	public void insertSchedule() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>(); 
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		LottoDTO lottoDTO = restTemplate.getForObject(LOTTO_URL + (service.getLastDrwNo()+1), LottoDTO.class);
		if(lottoDTO == null)
			log.warning("Data Insert Failure pls Check"+7);
		else
			service.insertLotto(lottoDTO);
	}
	
	
	@Scheduled(cron = "* 59 23 * * 7")
	public void insertScheduleTemp() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>(); 
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		LottoDTO lottoDTO = null;
		try {
			lottoDTO = restTemplate.getForObject(LOTTO_URL + (service.getLastDrwNo()+1), LottoDTO.class);
		}
		catch(Exception e) {
			
		}
		if(lottoDTO.getDrwNo()==null)
			log.warning("Data Insert Failure pls Check"+7);
		else
			service.insertLotto(lottoDTO);
	}
}
