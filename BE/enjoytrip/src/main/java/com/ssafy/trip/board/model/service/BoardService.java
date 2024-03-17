package com.ssafy.trip.board.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.trip.board.model.BoardDto;
import com.ssafy.trip.board.model.BoardListDto;
import com.ssafy.trip.board.model.CommentDto;
import com.ssafy.trip.board.model.CommentListDto;

public interface BoardService {
	void writeArticle(BoardDto boardDto) throws Exception;
	BoardListDto listArticle(Map<String, String> map) throws Exception;
//	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	BoardDto getArticle(int articleNo) throws Exception;
	void updateHit(int articleNo) throws Exception;
	
	void modifyArticle(BoardDto boardDto) throws Exception;
//	
	void deleteArticle(int articleNo) throws Exception;
	void writeComment(CommentDto commentDto) throws Exception;
	List<CommentDto> listComment(int articleNo) throws SQLException;
	void deleteComment(int commentNo) throws SQLException;
}
