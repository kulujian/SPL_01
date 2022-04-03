package com.kulu.comtroller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kulu.domain.ResponseResult;
import com.kulu.domain.SystemUser;
import com.kulu.service.SystemUserService;
import com.kulu.utils.JwtUtil;

@RestController
@RequestMapping(path = "/sys_user")
public class SystemUserController {

	@Autowired
	private SystemUserService systemUserService;
	/**
	 *  @param user 通過請求體(Requestbody)獲得，前端輸入資料傳送
	 * 	@return 統一回應訊息格式
	 */
	@PostMapping(path = "/login")
	public ResponseResult login(@RequestBody SystemUser user) {
		// 校驗用戶名稱、密碼
		SystemUser loginUser = systemUserService.login(user);
		Map<String, Object> map;
		if (loginUser != null) {
			// 如果正確 生成token返回 (使用jwt生成)
			map = new HashMap<>();
			String token = JwtUtil.createJWT(UUID.randomUUID().toString(), String.valueOf(loginUser.getId()), null);
			map.put("token", token);
		} else {
			// 如果不正確 給出相應提示
			return new ResponseResult(300, "登入失敗，帳號或密碼錯誤");
		}
		return new ResponseResult(200, "登入成功", map);
	}
}
