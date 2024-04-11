package com.dmm.task.contoroller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dmm.task.data.entity.Task;
import com.dmm.task.service.CalendarService;

//コントローラーとして使うためのアノテーション
@Controller
public class CalenderController {
	@Autowired
	private CalendarService calendarService;
	//@Autowiredアノテーションの注入でコンストラクタが不要になるということでコメントアウトする
   //public CalenderController(CalendarService calendarService) {
    //    this.calendarService = calendarService;
    //}
    //カレンダ表示用のGetメソッド
    @GetMapping("/main")//GETリクエストが'/main'パスに対して行われた時にこのメソッドを呼び出すよ
    public String showCalendar(Model model) {
        LocalDate today = LocalDate.now();//現在の日付を取得
        int year = today.getYear();//その年と
        int month = today.getMonthValue();//その月を使用してカレンダーを作る
        
        List<List<LocalDate>> matrix = calendarService.generateCalendar();//CalendarServiceのgenerateCalendar()メソッドを呼び出して
        model.addAttribute("matrix", matrix);//モデルに追加。これがカレンダー画面に反映されてほしい。★あとでチェックする
        
        // tasks 属性を設定しないとエラーになる（とりあえず現時点でのタスクリスト追加）★あとで修正
        Map<LocalDate, List<Task>> tasks = new HashMap<>();
        model.addAttribute("tasks", tasks);
        
        return "main"; //カレンダー画面
    }
}
