package com.dmm.task.contoroller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dmm.task.data.entity.Task;
import com.dmm.task.service.TaskService;

@Controller//コントローラーとして使うためのアノテーション
public class TaskController {
    private TaskService taskService;
    
    //public TaskController(TaskService taskService) {
    //	this.taskService = taskService;
    //}
    @GetMapping("/create")//GETリクエストが'/main'パスに対して行われた時にこのメソッドを呼び出すよ
    public String showCalendar(@AuthenticationPrincipal UserDetails userDetails, Model model) {//Spring SecurityのUserDetailsインタフェースを注入。ログイン中のユーザー情報にアクセスできるhttps://terakoya.sejuku.net/question/detail/34030
        // UserDetailsインターフェースを注入して、Usenameを取得
        String username = userDetails.getUsername();
        // ログインしたユーザーが登録したタスクを取得
        List<Task> userTasks = taskService.getUserTasks(username);
        // カレンダー画面でタスク情報を表示するために、上で取得したタスク情報をモデルに追加する。
        model.addAttribute("create", userTasks);
        
        return "create"; // カレンダー画面
    }   
}