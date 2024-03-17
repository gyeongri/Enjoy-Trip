
package com.ssafy.trip.map.model.service;

import java.util.List;

import com.ssafy.trip.map.model.AttractionInfoDto;
import com.ssafy.trip.map.model.SidoGugunCodeDto;

public interface MapService {
    List<SidoGugunCodeDto> getSido() throws Exception;
    List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
    List<AttractionInfoDto> getAttractionInfo(String contentTypeId,String sidoCode, String gugunCode) throws Exception;
    List<SidoGugunCodeDto> getContentTypeId();
}