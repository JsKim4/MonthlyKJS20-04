package kr.kjs.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class TagInsertInfo {
	private String tagName;
	private List<String> drwList;
}
