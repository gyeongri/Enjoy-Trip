package com.ssafy.trip.board.model;

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
@ApiModel(value = "FileInfoDto : 업로드 파일정보", description = "게시글에 업로드한 파일의 정보를 나타낸다.")
public class FileInfoDto {

	@ApiModelProperty(value = "파일 ID")
	private int fileId;
	@ApiModelProperty(value = "글 번호")
	private int articleNo;
	@ApiModelProperty(value = "저장 경로")
	private String filePath;
	
	
//	private String file_id; //(PK)
//	private String file_post_id; //(FK.게시판의 글번호)
//	private String file_original_name; //
//	private String file_save_name; //
//	private String file_size; //
//	private String file_delete_yn; //
//	private String file_create_date; //
//	private String file_deleted_date; //
}
