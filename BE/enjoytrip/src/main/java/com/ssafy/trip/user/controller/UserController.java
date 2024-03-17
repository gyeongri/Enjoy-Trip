package com.ssafy.trip.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.user.model.UserDto;
import com.ssafy.trip.user.model.service.UserService;
import com.ssafy.trip.util.JWTUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.POST} , maxAge = 6000)
@RestController
@RequestMapping("/user")
@Api("User 컨트롤러  API V1")
@Slf4j
public class UserController {
	
	private UserService userService;
	private JWTUtil jwtUtil;

	public UserController(UserService userService, JWTUtil jwtUtil) {
		super();
		this.userService = userService;
		this.jwtUtil = jwtUtil;
	}
	
	@ApiOperation(value = "회원가입", notes = "회원가입하기")
	@PostMapping("/regist")
	public ResponseEntity<?> regist(
			@RequestBody @ApiParam(value = "회원가입 시 필요한 회원정보(아이디, 비밀번호, 개인정보 등).", required = true) UserDto userDto) {
		log.info("regist userDto - {}", userDto);
		System.out.println(userDto.toString());
		
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		HttpStatus status = HttpStatus.ACCEPTED;
//		System.out.println(status);
		try {
			userService.regist(userDto);
			return new ResponseEntity<Void>(HttpStatus.CREATED);

		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@ApiOperation(value = "회원탈퇴", notes = "해당 아이디를 가진 회원 탈퇴처리하기")
	@PostMapping("/withdrawal/{userid}")
	public ResponseEntity<String> withdrawal(
			@PathVariable("userid") @ApiParam(value = "회원탈퇴 시 필요한 회원정보: userid", required = true) String userId) {
		log.info("withdrawal userDto - {}", userId);
		System.out.println(userId);

		try {
			log.info("withdrawal - 호출");
			userService.withdrawal(userId);
			return ResponseEntity.ok().build();

		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	
	
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ApiOperation(value = "로그인", notes = "아이디와 비밀번호를 이용하여 로그인 처리.")
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(
			@RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) UserDto userDto) {
		System.out.println(userDto.toString());
		log.debug("login user : {}", userDto);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		HttpStatus status = HttpStatus.ACCEPTED;
		System.out.println(status);
		try {
			UserDto loginUser = userService.login(userDto);
			
//			System.out.println(loginUser.toString());
//			System.out.println(loginUser);
			log.debug("login user22 : {}", loginUser);
			if(loginUser != null) {
				System.out.println("if "+loginUser);
				String accessToken = jwtUtil.createAccessToken(loginUser.getUserId());
				String refreshToken = jwtUtil.createRefreshToken(loginUser.getUserId());
//				System.out.println(accessToken);
//				System.out.println(refreshToken);
//				System.out.println(loginUser.getUserId());
				log.debug("access token : {}", accessToken);
				log.debug("refresh token : {}", refreshToken);
				
//				발급받은 refresh token을 DB에 저장.
				userService.saveRefreshToken(loginUser.getUserId(), refreshToken);
				
//				JSON으로 token 전달.
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				
				status = HttpStatus.CREATED;
				
				System.out.println(resultMap.toString());
			} else {
				System.out.println("else"+loginUser);
				resultMap.put("message", "아이디 또는 패스워드를 확인해주세요.");
				status = HttpStatus.UNAUTHORIZED;
			} 
			
		} catch (Exception e) {
			System.out.println("로그인 에러 발생 "+ e);
			log.debug("로그인 에러 발생 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "회원인증", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
	@GetMapping("/info/{userId}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("userId") @ApiParam(value = "인증할 회원의 아이디.", required = true) String userId,
			HttpServletRequest request) {
//		logger.debug("userId : {} ", userId);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtUtil.checkToken(request.getHeader("Authorization"))) {
			log.info("사용 가능한 토큰!!!");
			System.out.println("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				System.out.println(userId);
				UserDto userDto = userService.userInfo(userId);
				System.out.println(userDto.toString());
				resultMap.put("userInfo", userDto);
				status = HttpStatus.OK;
			} catch (Exception e) {
				log.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			log.error("사용 불가능 토큰!!!");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "회원정보 조회", notes = "회원 정보를 담은 userDto을 반환한다.", response = Map.class)
	@GetMapping("/getUserProfile/{userId}")
	public ResponseEntity<Map<String, Object>> getUserProfile(
			@PathVariable("userId") @ApiParam(value = "조회할 회원의 아이디.", required = true) String userId,
			HttpServletRequest request) {
//		logger.debug("userId : {} ", userId);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
			try {
//				로그인 사용자 정보.
				System.out.println(userId);
				UserDto userDto = userService.userInfo(userId);
				System.out.println(userDto.toString());
				resultMap.put("userInfo", userDto);
				status = HttpStatus.OK;
			} catch (Exception e) {
				log.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	
	
	
	@ApiOperation(value = "로그아웃", notes = "회원 정보를 담은 Token을 제거한다.", response = Map.class)
	@GetMapping("/logout/{userId}")
	public ResponseEntity<?> removeToken(@PathVariable ("userId") @ApiParam(value = "로그아웃할 회원의 아이디.", required = true) String userId) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			userService.deleRefreshToken(userId);
			status = HttpStatus.OK;
		} catch (Exception e) {
			//System.out.println();
			log.error("로그아웃 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "Access Token 재발급", notes = "만료된 access token을 재발급받는다.", response = Map.class)
	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody UserDto userDto, HttpServletRequest request)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refreshToken");
		log.debug("token : {}, userDto : {}", token, userDto);
		if (jwtUtil.checkToken(token)) {
			if (token.equals(userService.getRefreshToken(userDto.getUserId()))) {
				String accessToken = jwtUtil.createAccessToken(userDto.getUserId());
				log.debug("token : {}", accessToken);
				log.debug("정상적으로 액세스토큰 재발급!!!");
				resultMap.put("access-token", accessToken);
				status = HttpStatus.CREATED;
			}
		} else {
			log.debug("리프레쉬토큰도 사용불가!!!!!!!");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

}
