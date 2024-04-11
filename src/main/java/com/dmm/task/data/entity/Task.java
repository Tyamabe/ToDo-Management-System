package com.dmm.task.data.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Task {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)//このアノテーションが必須らしい→https://zenn.dev/dev_yoon/articles/a4710fef6e7494
private Long id;

private String title;
private String name;
private String text;
private LocalDate date;
private boolean done;
	
}
