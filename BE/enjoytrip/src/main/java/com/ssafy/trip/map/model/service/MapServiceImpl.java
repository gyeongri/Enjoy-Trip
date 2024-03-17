package com.ssafy.trip.map.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.trip.map.model.AttractionInfoDto;
import com.ssafy.trip.map.model.SidoGugunCodeDto;
import com.ssafy.trip.map.model.mapper.MapMapper;

@Service
public class MapServiceImpl implements MapService {

	private MapMapper mapMapper;

	public MapServiceImpl(MapMapper mapMapper) {
		super();
		this.mapMapper = mapMapper;
	}

	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		return mapMapper.getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		return mapMapper.getGugunInSido(sido);
	}

	@Override
	public List<AttractionInfoDto> getAttractionInfo(String contentTypeId,String sidoCode, String gugunCode) throws Exception {
		return mapMapper.getAttractionInfo(contentTypeId,sidoCode, gugunCode);
	}

	@Override
	public List<SidoGugunCodeDto> getContentTypeId() {
		return mapMapper.getContentTypeId();
	}
}
