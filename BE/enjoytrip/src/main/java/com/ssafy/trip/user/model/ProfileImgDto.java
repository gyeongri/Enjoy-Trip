package com.ssafy.trip.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel(value = "ProfileImgDto : 프로필 이미지 정보", description = "유저별 프로필 파일의 정보를 나타낸다.")
public class ProfileImgDto {
	@ApiModelProperty(value = "파일 ID")
	private int fileId;
	@ApiModelProperty(value = "유저ID")
	private int userId;
	@ApiModelProperty(value = "저장 경로")//서버에 저장될 경로
	private String filePath;
}
