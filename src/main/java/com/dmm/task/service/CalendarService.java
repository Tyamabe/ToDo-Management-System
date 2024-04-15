package com.dmm.task.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CalendarService {
    public List<List<LocalDate>> generateCalendar() {
        // 1. 空のListのListを用意する
        List<List<LocalDate>> matrix = new ArrayList<>();

        // 3. その月の1日のLocalDateを取得する。
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);

        // 4. 曜日を取得し、必要ならば前月の日に戻る処理をする
        DayOfWeek firstDayOfWeek = firstDayOfMonth.getDayOfWeek();
        int daysToMonday = firstDayOfWeek.getValue() - DayOfWeek.MONDAY.getValue();
        LocalDate startDate;
        if (daysToMonday > 0) {
            startDate = firstDayOfMonth.minusDays(daysToMonday);
        } else {
            startDate = firstDayOfMonth;
        }

        LocalDate currentDate = startDate;
        while (true) {
            // 2. 1週間分のLocalDateを格納するリストを用意する
            List<LocalDate> weekRow = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                // 5. 1日ずつ増やしながらLocalDateを求め、リストへ格納する
                if (currentDate.getMonthValue() == month) {
                    weekRow.add(currentDate);
                } else {
                    if (weekRow.isEmpty()) {
                        weekRow.add(currentDate); // 月初めに空白を挿入するための条件
                    } else {
                        weekRow.add(null); // 翌月に入った場合の空白
                    }
                }
                currentDate = currentDate.plusDays(1);
            }
            // 6. 週のリストを2次元リストへ格納する
            matrix.add(weekRow);
            
            // ループ終了条件をチェック
            if (currentDate.getMonthValue() > month && currentDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                break; // 月の最終日が日曜日の場合、ループを終了
            }
        }
        return matrix;
    }
}