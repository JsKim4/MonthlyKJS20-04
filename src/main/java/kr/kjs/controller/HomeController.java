package kr.kjs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import kr.kjs.admin.dto.AdminLoginDTO;
import kr.kjs.admin.service.AdminService;
import kr.kjs.admin.vo.ProjectVO;
import kr.kjs.dto.LottoDTO;
import kr.kjs.dto.LottoSearchDTO;
import kr.kjs.dto.LottoSimulationDTO;
import kr.kjs.dto.LottoStat;
import kr.kjs.dto.TagInsertInfo;
import kr.kjs.dto.TagSimpleInfo;
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
	AdminService adminService;
	
	@Autowired
	RestTemplate restTemplate;

	static final String LOTTO_URL = "https://www.nlotto.co.kr/common.do?method=getLottoNumber&drwNo=";

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("lastDrwNo",service.getLastDrwNo());
		return "home";
	}
	
	@RequestMapping(value = "/statistics", method = RequestMethod.GET)
	public void statistics() {}
	
	@RequestMapping(value = "/simulation", method = RequestMethod.GET)
	public void simulation() {}
	
	@RequestMapping(value = "/admin/", method = RequestMethod.GET)
	public String adminForm() {
		return "admin/index";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/{type}/{data}", method = RequestMethod.GET)
	public ResponseEntity<LottoDTO> home2(@PathVariable("data") String data,@PathVariable("type") String type) {
		LottoDTO responseDTO = service.getLotto(data,type);
		if (responseDTO != null)
			return new ResponseEntity<LottoDTO>(responseDTO, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.FOUND);
	}

	
	@ResponseBody
	@RequestMapping(value = "/statistics/list", method = RequestMethod.GET)
	public ResponseEntity<List<LottoStat>> getLottoStatList(LottoSearchDTO searchDTO) {
		List<LottoStat> responseDTO = service.getLottoStatList(searchDTO);
		if (responseDTO != null)
			return new ResponseEntity<List<LottoStat>>(responseDTO, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.FOUND);
	}
	
	@ResponseBody
	@RequestMapping(value = "/simulation/list", method = RequestMethod.GET)
	public ResponseEntity<List<LottoSimulationDTO>> getLottoSimulation(String search[]) {
		log.info(String.valueOf(service.getLottoSimulationList(search)));
		return new ResponseEntity<List<LottoSimulationDTO>>(service.getLottoSimulationList(search),HttpStatus.OK);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/tag/list", method = RequestMethod.GET)
	public ResponseEntity<List<TagSimpleInfo>> getLottoTagList() {
		List<TagSimpleInfo> responseDTO = service.getTagList();
		if (responseDTO != null)
			return new ResponseEntity<List<TagSimpleInfo>>(responseDTO, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.FOUND);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/lotto/list", method = RequestMethod.GET)
	public ResponseEntity<List<LottoDTO>> getLottoList() {
		List<LottoDTO> responseDTO = service.getLottoList();
		if (responseDTO != null)
			return new ResponseEntity<List<LottoDTO>>(responseDTO, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.FOUND);
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/admin/tag/{tagSeq}", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getTagLotto(@PathVariable("tagSeq") String tagSeq) {
		return new ResponseEntity<List<String>>(service.getLottoTagList(tagSeq),HttpStatus.OK);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/admin/tag", method = RequestMethod.POST)
	public ResponseEntity<String> insertTag(@RequestBody String name) {
		service.insertTag(name);
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/tag", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteTag(@RequestBody String tagSeq) {
		return new ResponseEntity<String>(service.deleteTag(tagSeq)?"success":"fail",HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/tag", method = RequestMethod.PUT)
	public ResponseEntity<String> putTag(@RequestBody TagSimpleInfo tagSimpleInfo) {
		return new ResponseEntity<String>(service.modifyTagName(tagSimpleInfo)?"success":"fail",HttpStatus.OK);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/admin/tag/list", method = RequestMethod.POST)
	public ResponseEntity<String> insertTagList(@RequestBody TagInsertInfo tagInsertInfo) {
		int fail = service.insertTagList(tagInsertInfo);
		return new ResponseEntity<String>(fail==0?"success":"fail"+fail,HttpStatus.OK);
	}
	
	
	
	
	
	
	@RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	public void adminLogin() {}
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody AdminLoginDTO loginDTO,HttpServletRequest request) {
		if(adminService.login(loginDTO)) {
			HttpSession session = request.getSession();
			session.setAttribute(ProjectVO.PROJECT_ID+ProjectVO.ADMIN_LOGIN, "true");
			return new ResponseEntity<String>("success",HttpStatus.OK);
		}
		return new ResponseEntity<String>("fail",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
}
