package com.ssafy.trip.map.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.trip.map.model.AttractionInfoDto;
import com.ssafy.trip.map.model.SidoGugunCodeDto;

@Mapper
public interface MapMapper {
	List<SidoGugunCodeDto> getSido() throws SQLException;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws SQLException;
	List<AttractionInfoDto> getAttractionInfo(String contentTypeId,String sidoCode, String gugunCode);
	List<SidoGugunCodeDto> getContentTypeId();



}
