package kr.kjs.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	static final String LOTTO_URL="https://www.nlotto.co.kr/common.do?method=getLottoNumber&drwNo=";
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/{drwNo}", method = RequestMethod.GET)
	public ResponseEntity<LottoDTO> home2(@PathVariable("drwNo") String drwNo) {
		LottoDTO responseDTO = service.getLottoByDrwNo(drwNo);
		if(responseDTO!=null)
			return new ResponseEntity<LottoDTO>(service.getLottoByDrwNo(drwNo),HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/init/asd123qqa12sad34ds5sdvvbcvccbvbccbc681adasd/{startDrwNo}/{endDrwNo}", method = RequestMethod.GET)
	public ResponseEntity<String> init(@PathVariable("startDrwNo") Integer startDrwNo,@PathVariable("endDrwNo") Integer endDrwNo) {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		//Add the Jackson Message converter
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		// Note: here we are making this converter to process any kind of response, 
		// not only application/*json, which is the default behaviour
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));        
		messageConverters.add(converter); 
		restTemplate.setMessageConverters(messageConverters);
		Integer failCount = 0;
		Integer successCount = 0;
		for(int i= startDrwNo;i<=endDrwNo;i++) {
			if(service.insertLotto(restTemplate.getForObject(LOTTO_URL+i, LottoDTO.class)))
				successCount++;
			else
				failCount++;
		}
		return new ResponseEntity<String>("success : "+successCount+"\nFailCount : "+failCount,HttpStatus.OK);
		
	}

	
}
