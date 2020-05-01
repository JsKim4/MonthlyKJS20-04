package kr.kjs.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class LottoSearchDTO {
	private List<String> orCondition;
	private List<String> andCondition;
}
