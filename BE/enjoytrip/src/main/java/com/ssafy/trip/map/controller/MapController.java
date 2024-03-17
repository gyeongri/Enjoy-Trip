package com.ssafy.trip.map.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.map.model.AttractionInfoDto;
import com.ssafy.trip.map.model.SidoGugunCodeDto;
import com.ssafy.trip.map.model.service.MapService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/map")
@Api("Map 컨트롤러  API V1")
@Slf4j
public class MapController {
	
	private MapService mapService;

	public MapController(MapService mapService) {
		super();
		this.mapService = mapService;
	}
	
	@ApiOperation(value = "관광지 타입 ID 정보", notes = "관광지 타입 ID를 반환한다.", response = List.class)
	@GetMapping("/contentTypeId")
	public ResponseEntity<List<SidoGugunCodeDto>> contentTypeId() throws Exception {
		log.info("contentTypeId - 호출");
		return new ResponseEntity<List<SidoGugunCodeDto>>(mapService.getContentTypeId(), HttpStatus.OK);
	}

	//관광지 타입 id를 입력으로 받도록 수정함.
	@ApiOperation(value = "시도 정보", notes = "전국의 시도를 반환한다.", response = List.class)
	@GetMapping("/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> sido(
			@RequestParam("contentTypeId") @ApiParam(value = "관광지 타입 ID.", required = true) String contentTypeId) throws Exception {
		log.info("sido - 호출");
		return new ResponseEntity<List<SidoGugunCodeDto>>(mapService.getSido(), HttpStatus.OK);
	}

	@ApiOperation(value = "구군 정보", notes = "시도에 속한 구군을 반환한다.", response = List.class)
	@GetMapping("/gugun")
	public ResponseEntity<List<SidoGugunCodeDto>> gugun(
			@RequestParam("sido") @ApiParam(value = "시도코드.", required = true) String sido) throws Exception {
		log.info("gugun - 호출");
		return new ResponseEntity<List<SidoGugunCodeDto>>(mapService.getGugunInSido(sido), HttpStatus.OK);
	}
	
    //스웨거
    @ApiOperation(value = "관광지 정보", notes = "관광지 정보를 반환한다.", response = List.class)
    @GetMapping("/attractionInfo")
    public ResponseEntity<List<AttractionInfoDto>> attractionInfo(
    		@RequestParam String contentTypeId, @RequestParam String sido, @RequestParam String gugun
            ) throws Exception {
        log.info("attractionInfo - 호출");
        List<AttractionInfoDto> lst=mapService.getAttractionInfo(contentTypeId,sido, gugun);
        System.out.println(contentTypeId+" "+sido+" "+gugun);
        return ResponseEntity.ok().body(lst);
    }

}
