package com.ssafy.trip.board.model;

import java.util.List;

import com.ssafy.trip.board.model.FileInfoDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@ApiModel(value = "BoardDto : 게시글정보", description = "게시글의 상세 정보를 나타낸다.")
public class BoardDto {
	
//	게시판
//	private String article_type 글유형(말머리) private String > 여행 정보 공유,여행 후기, 계획 컨펌받기
//	private String article_no 글번호
//	private String article_title 글제목
//	private String writer_id 작성자
//	private String article_content 글내용
//	private String article_hit 조회수
//	private String article_register_time 작성 시간
//	private String article_delete_yn 삭제 여부
//	
	@ApiModelProperty(value = "글유형(말머리)")
	private String articleType;// 글유형(말머리) -> 여행 정보 공유,여행 후기, 계획 컨펌받기
	
	@ApiModelProperty(value = "글번호")
	private int articleNo;// 글번호
	
	@ApiModelProperty(value = "글제목")
	private String articleTitle;// 글제목
	
	@ApiModelProperty(value = "작성자")
	private String userId;// 작성자
	
	@ApiModelProperty(value = "닉네임")
	private String userNickname;// 닉네임
	
	@ApiModelProperty(value = "글내용")
	private String articleContent;// 글내용
	
	@ApiModelProperty(value = "조회수")
	private int articleHit;// 조회수
	
	@ApiModelProperty(value = "작성 시간")
	private String articleRegisterTime;// 작성 시간
	
//	@ApiModelProperty(value = "이미지 파일 경로 리스트")
//	private List<FileInfoDto> fileInfos;
}
