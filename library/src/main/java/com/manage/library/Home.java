package com.manage.library;

import java.sql.Timestamp;
import java.sql.Date;

// 一覧画面で取得する値を用意し、getterとsetterを用意するクラス。
public class Home {

  private int book_id;
  private String book_title;
  private boolean lending_status;
  private Timestamp lended_at;
  private Date due_date;
  private String user_name;

  public Home(int book_id, String book_title, boolean lending_status, Timestamp lended_at, Date due_date,
      String user_name) {
    this.book_id = book_id;
    this.book_title = book_title;
    this.lending_status = lending_status;
    this.lended_at = lended_at;
    this.due_date = due_date;
    this.user_name = user_name;
  }

  public Home() {
  }

  public int getBook_id() {
    return this.book_id;
  }

  public String getBook_title() {
    return this.book_title;
  }

  public boolean getLending_status() {
    return this.lending_status;
  }

  public Timestamp getLended_at() {
    return this.lended_at;
  }

  public Date getDue_date() {
    return this.due_date;
  }

  public String getUser_name() {
    return this.user_name;
  }

  public void setBook_id(int book_id) {
    this.book_id = book_id;
  }

  public void setBook_title(String book_title) {
    this.book_title = book_title;
  }

  public void setLending_status(boolean lending_status) {
    this.lending_status = lending_status;
  }

  public void setLended_at(Timestamp lended_at) {
    this.lended_at = lended_at;
  }

  public void setDue_date(Date due_date) {
    this.due_date = due_date;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }
}
