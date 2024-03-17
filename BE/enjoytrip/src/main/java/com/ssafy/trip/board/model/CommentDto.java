package com.ssafy.trip.board.model;

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
@ApiModel(value = "CommentDto : 댓글정보", description = "댓글의 상세 정보를 나타낸다.")
public class CommentDto {
	//댓글
	
	@ApiModelProperty(value = "댓글 번호")
	private int commentNo;// 댓글 번호
	
	@ApiModelProperty(value = "댓글 작성자")
	private String userId;// 댓글 작성자
	
	@ApiModelProperty(value = "댓글 내용")
	private String commentContent;// 댓글 내용
	
	@ApiModelProperty(value = "댓글 작성시간")
	private String commentRegisterTime;// 댓글 작성시간
	
	@ApiModelProperty(value = "게시글 번호")
	private int articleNo;// 게시글 번호
	
	@ApiModelProperty(value = "닉네임")
	private String userNickname;// 닉네임
}
