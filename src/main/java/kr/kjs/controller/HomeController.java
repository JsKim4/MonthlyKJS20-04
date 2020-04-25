package kr.kjs.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import kr.kjs.dto.LottoDTO;
import kr.kjs.service.LottoService;
import lombok.extern.java.Log;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log
public class HomeController {
	@Autowired
	LottoService service;

	@Autowired
	RestTemplate restTemplate;

	static final String LOTTO_URL = "https://www.nlotto.co.kr/common.do?method=getLottoNumber&drwNo=";

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@Scheduled(cron = "0 0 21 * * 7")
	public void insertSchedule() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>(); 
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		LottoDTO lottoDTO = restTemplate.getForObject(LOTTO_URL + (service.getLastDrwNo()+1), LottoDTO.class);
		if(lottoDTO.getDrwNo()==null)
			log.warning("Data Insert Failure pls Check");
		else
			service.insertLotto(lottoDTO);
	}

	@ResponseBody
	@RequestMapping(value = "/{drwNo}", method = RequestMethod.GET)
	public ResponseEntity<LottoDTO> home2(@PathVariable("drwNo") String drwNo) {
		LottoDTO responseDTO = service.getLottoByDrwNo(drwNo);
		if (responseDTO != null)
			return new ResponseEntity<LottoDTO>(service.getLottoByDrwNo(drwNo), HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

}
