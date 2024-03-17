package com.ssafy.trip.board.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel(value = "CommentListDto : 댓글 목록", description = "댓글 목록을 나타낸다.")
public class CommentListDto {
	@ApiModelProperty(value = "댓글목록")
	private List<CommentDto> comments;
}
