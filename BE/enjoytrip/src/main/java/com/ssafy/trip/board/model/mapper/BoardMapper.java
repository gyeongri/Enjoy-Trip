package com.ssafy.trip.board.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.board.model.BoardDto;
import com.ssafy.trip.board.model.CommentDto;
import com.ssafy.trip.board.model.FileInfoDto;

@Mapper
public interface BoardMapper {
	void writeArticle(BoardDto boardDto) throws SQLException;

	void registerFile(BoardDto boardDto) throws Exception;

	List<BoardDto> listArticle(Map<String, Object> param) throws SQLException;

	int getTotalArticleCount(Map<String, Object> param) throws SQLException;

	BoardDto getArticle(int articleNo) throws SQLException;

	void updateHit(int articleNo) throws SQLException;

	void modifyArticle(BoardDto boardDto) throws SQLException;//글 수정하기

//	void deleteFile(int articleNo) throws Exception;
//
	void deleteArticle(int articleNo) throws SQLException;//해당 글 삭제하기(댓글은 제약조건으로 자동삭제)

	List<FileInfoDto> fileInfoList(int articleNo) throws Exception;

	void writeComment(CommentDto commentDto) throws SQLException; //댓글쓰기

	List<CommentDto> listComment(int articleNo) throws SQLException;//댓글 목록 가져오기

	void deleteComment(int commentNo) throws SQLException;//해당 댓글 삭제하기.
}
