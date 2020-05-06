package kr.kjs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LottoSimulationDTO{
	private String drwNo;
	private String drwtNo1;
	private String drwtNo2;
	private String drwtNo3;
	private String drwtNo4;
	private String drwtNo5;
	private String drwtNo6;
	private String bnusNo;
	private String drwNoDate;
	private String firstWinamnt;
	private String firstPrzwnerCo;
	private String firstAccumamnt;
	private String totSellamnt;
	private String rank;
}
