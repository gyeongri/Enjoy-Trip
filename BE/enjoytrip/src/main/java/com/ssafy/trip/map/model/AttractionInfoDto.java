package com.ssafy.trip.map.model;

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
@ApiModel(value = "AttractionInfoDto : 관광지 정보", description = "관광지 정보를 나타낸다.")
public class AttractionInfoDto {
	
	@ApiModelProperty(value = "관광지명")
	private String title;
	
	@ApiModelProperty(value = "관광지 id")
	private int contentId;
	
	@ApiModelProperty(value = "관광지 타입 id")
	private int contentTypeId;
	
	@ApiModelProperty(value = "주소1")
	private String addr1;
	
	@ApiModelProperty(value = "주소2")
	private String addr2;
	
	@ApiModelProperty(value = "이미지1")
	private String firstImage;
	
	@ApiModelProperty(value = "이미지2")
	private String firstImage2;
	
	@ApiModelProperty(value = "시도코드")
	private int sidoCode;
	
	@ApiModelProperty(value = "구군코드")
	private int gugunCode;
	
	@ApiModelProperty(value = "위도")
	private String latitude;
	
	@ApiModelProperty(value = "경도")
	private String longitude;
	
	@ApiModelProperty(value = "mlevel")
	private String mlevel;
	
	@ApiModelProperty(value = "readcount")
	private String readcount;

	@ApiModelProperty(value = "전화번호")
	private String tel;

	@ApiModelProperty(value = "우편주소")
	private String zipcode;


}
