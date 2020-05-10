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

	static final String LOTTO_URL = "https://www.nlotto.co.kr/common.do?method=getLottoNumber&drwNo=";
	
	
	@Scheduled(cron = "0 15 23 * * 7")
	public void insertSchedule7() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>(); 
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		LottoDTO lottoDTO = restTemplate.getForObject(LOTTO_URL + (service.getLastDrwNo()+1), LottoDTO.class);
		if(lottoDTO.getDrwNo()==null)
			log.warning("Data Insert Failure pls Check"+7);
		else
			service.insertLotto(lottoDTO,"7");
	}
	
	@Scheduled(cron = "0 15 23 * * 6")
	public void insertSchedule6() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>(); 
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		LottoDTO lottoDTO = restTemplate.getForObject(LOTTO_URL + (service.getLastDrwNo()+1), LottoDTO.class);
		if(lottoDTO.getDrwNo()==null)
			log.warning("Data Insert Failure pls Check");
		else
			service.insertLotto(lottoDTO,"6"+6);
	}
	
	@Scheduled(cron = "0 15 23 * * 5")
	public void insertSchedule5() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>(); 
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		LottoDTO lottoDTO = restTemplate.getForObject(LOTTO_URL + (service.getLastDrwNo()+1), LottoDTO.class);
		if(lottoDTO.getDrwNo()==null)
			log.warning("Data Insert Failure pls Check");
		else
			service.insertLotto(lottoDTO,"5"+5);
	}
	
	@Scheduled(cron = "0 15 23 * * 4")
	public void insertSchedule4() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>(); 
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		LottoDTO lottoDTO = restTemplate.getForObject(LOTTO_URL + (service.getLastDrwNo()+1), LottoDTO.class);
		if(lottoDTO.getDrwNo()==null)
			log.warning("Data Insert Failure pls Check"+4);
		else
			service.insertLotto(lottoDTO,"4");
	}
	
	@Scheduled(cron = "0 15 23 * * 3")
	public void insertSchedule3() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>(); 
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		LottoDTO lottoDTO = restTemplate.getForObject(LOTTO_URL + (service.getLastDrwNo()+1), LottoDTO.class);
		if(lottoDTO.getDrwNo()==null)
			log.warning("Data Insert Failure pls Check"+3);
		else
			service.insertLotto(lottoDTO,"3");
	}
	
	@Scheduled(cron = "0 15 23 * * 2")
	public void insertSchedule2() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>(); 
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		LottoDTO lottoDTO = restTemplate.getForObject(LOTTO_URL + (service.getLastDrwNo()+1), LottoDTO.class);
		if(lottoDTO.getDrwNo()==null)
			log.warning("Data Insert Failure pls Check"+2);
		else
			service.insertLotto(lottoDTO,"2");
	}
	
	@Scheduled(cron = "0 15 23 * * 1")
	public void insertSchedule1() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>(); 
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		LottoDTO lottoDTO = restTemplate.getForObject(LOTTO_URL + (service.getLastDrwNo()+1), LottoDTO.class);
		if(lottoDTO.getDrwNo()==null)
			log.warning("Data Insert Failure pls Check"+1);
		else
			service.insertLotto(lottoDTO,"1");
	}
	
	
	@Scheduled(cron = "0 15 23 * * 0")
	public void insertSchedule0() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>(); 
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		LottoDTO lottoDTO = restTemplate.getForObject(LOTTO_URL + (service.getLastDrwNo()+1), LottoDTO.class);
		if(lottoDTO.getDrwNo()==null)
			log.warning("Data Insert Failure pls Check");
		else
			service.insertLotto(lottoDTO,"0");
	}
	
}
