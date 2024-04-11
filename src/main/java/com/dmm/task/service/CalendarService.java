package com.dmm.task.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CalendarService {
    public List<List<LocalDate>> generateCalendar() {
    	//1. 空のListのListを用意する
    	List<List<LocalDate>> matrix = new ArrayList<>();        
    	//3. その月の1日のLocalDateを取得する。
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
    	
        //4.そして曜日を取得する。上で取得したLocalDateに曜日の値（DayOfWeek#getValue)をマイナスして前月分のLocalDateを求める
        //4-2. 取得したLocalDate(=firstDayOfMonth)に曜日の値(DayOfWeek.getValue)をマイナスする
        DayOfWeek firstDayOfWeek = firstDayOfMonth.getDayOfWeek();
        int daysForMonday = firstDayOfWeek.getValue() - DayOfWeek.MONDAY.getValue();
        LocalDate startDate;
        if (daysForMonday > 0) {
            startDate = firstDayOfMonth.minusDays(daysForMonday);
        } else {
            startDate = firstDayOfMonth;
        }
        
        // 5. 1日ずつ増やしながらLocalDateを求め、リストへ格納する
        LocalDate currentDate = startDate;
        while (matrix.size() < 6) { // どんなに長い月も6週間まで←これも無限ループを抜けるため、、、
           // 2. 1週間分のLocalDateを格納するリストを用意する←ここに入れないと無限ループから抜け出せなかった
        	List<LocalDate> weekRow = new ArrayList<>(); // 週ごとのリストをリセット
            for (int i = 0; i < 7; i++) {
            	//currentDate.getMonthValue()が当月であレバ
                if (currentDate.getMonthValue() == month) {
                	weekRow.add(currentDate);
                }//else {//翌月に入った日付の場合は何もしない
//                	weekRow.add(null); // カレンダーの日付がないとこ
  //              }
                currentDate = currentDate.plusDays(1);//5. 1日ずつ増やしながらLocalDateを求める
            }
            // 6. 完成した週のリストを2次元リストへ追加する
            matrix.add(weekRow);
            
            // ループ終了条件のチェック
            // 今月ジャないし、月曜だったら
            //if (currentDate.getMonthValue() != month && currentDate.getDayOfWeek() == DayOfWeek.MONDAY) {
//              continueLoop = false;
//            }
        }
        return matrix;
    }
}
       