package com.ssafy.trip.user.model;

import java.util.List;

import com.ssafy.trip.board.model.FileInfoDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//???????
@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel(value = "UserDto : 회원정보", description = "회원의 상세 정보를 나타낸다.")
public class UserDto {
	@ApiModelProperty(value = "아이디")
	private String userId; // 아이디	(ㅎㅇㄱㅇ,ㅍㅅ)
	
	@ApiModelProperty(value = "삭제 여부")
	private String deleteYn; // 삭제 여부 (백엔드) (삭제시 로그인X,개인페이지X)
	
	@ApiModelProperty(value = "권한")
	private String userPosition; //  권한 (백엔드) (PK)
	
	@ApiModelProperty(value = "비밀번호")
	private String userPwd; // 비밀번호(ㅎㅇㄱㅇ,ㅍㅅ)	
	
	@ApiModelProperty(value = "닉네임")
	private String userNickname; // 닉네임(ㅎㅇㄱㅇ,ㅍㅅ)
	
	@ApiModelProperty(value = "이메일 아이디")
	private String email; // 이메일(ㅎㅇㄱㅇ,ㅍㅅ)
	
	@ApiModelProperty(value = "이메일 도메인")
	private String emailDomain; // 이메일도메인
	
	@ApiModelProperty(value = "성별")
	private String gender; // 성별(ㅎㅇㄱㅇ)

	@ApiModelProperty(value = "프로필 사진 이미지")
	private String profileImg; // 프로필 사진 이미지(ㅎㅇㄱㅇ)
	
	@ApiModelProperty(value = "refreshToken")
	private String refreshToken;

	
}