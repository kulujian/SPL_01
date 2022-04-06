package com.kulu.thymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kulu.domain.User;
import com.kulu.service.UserService;

@Controller  // 這裡方法的返回值是要做頁面路徑進行跳轉，不可使用RestController
public class ThymeleafController {

	@Autowired
	private UserService userService;
	
	/*
	 *  傳入值使用MVC中Model物件
	 *  返回值類型使用String，做為一個頁面地址
	 */
	@RequestMapping(path = "/Thymeleaf/users")
	public String users(Model model) {
		//獲取數據
		List<User> users = userService.findAll();
		//網域中存入數據
		model.addAttribute("users", users);
		model.addAttribute("msg", "hello thymeleaf");
		//頁面跳轉
		/*
		 *  在SpringBoot模板引擎Thymeleaf之後，已經配置好了路徑的前綴及後綴名稱
		 *  填寫回傳路徑時，只需指定模板引擎的文件名就可以了
		 */
		return "table-standard";
	}
}
