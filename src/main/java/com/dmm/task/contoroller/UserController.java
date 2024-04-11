package com.dmm.task.contoroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dmm.task.data.entity.Users;
import com.dmm.task.data.repository.UsersRepository;

@Controller
public class UserController {
	// @Autowiredアノテーションを付けると、Spring Bootが自動でインスタンスをInjectします。
	@Autowired
	private UsersRepository usersRepository;

	// @RequestMapping(path = "/user", method = RequestMethod.GET)の省略版。
	// HTTPのメソッドGETのみ受け付けます。
	@GetMapping("/users")
	// 引数にorg.springframework.ui.Modelを追加
	public String getUsers(Model model) {
		// ユーザーリスト取得処理を追加
		List<Users> users = usersRepository.findAll();
		// 取得したリストをテンプレートに渡す
		model.addAttribute("users", users);
		return "users";
	}
}