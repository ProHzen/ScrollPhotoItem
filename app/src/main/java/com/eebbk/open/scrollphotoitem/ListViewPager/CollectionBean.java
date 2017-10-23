package com.eebbk.open.scrollphotoitem.ListViewPager;

import java.util.Date;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/9/28 10:01
 * Email:  369013520@qq.com
 */

public class CollectionBean {

    private Date time;
    private String questionId;
    private String titleContent;
    private String questionPojo;
    private String searchType;
    private String questionType;
    private String subject;
    private String grade;

    public Date getTime() {
        return time;
    }

    public CollectionBean setTime(Date time) {
        this.time = time;
        return this;
    }

    public String getQuestionId() {
        return questionId;
    }

    public CollectionBean setQuestionId(String questionId) {
        this.questionId = questionId;
        return this;
    }

    String getTitleContent() {
        return titleContent;
    }

    CollectionBean setTitleContent(String titleContent) {
        this.titleContent = titleContent;
        return this;
    }

    public String getQuestionPojo() {
        return questionPojo;
    }

    public CollectionBean setQuestionPojo(String questionPojo) {
        this.questionPojo = questionPojo;
        return this;
    }

    public String getSearchType() {
        return searchType;
    }

    public CollectionBean setSearchType(String searchType) {
        this.searchType = searchType;
        return this;
    }

    public String getQuestionType() {
        return questionType;
    }

    public CollectionBean setQuestionType(String questionType) {
        this.questionType = questionType;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public CollectionBean setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getGrade() {
        return grade;
    }

    public CollectionBean setGrade(String grade) {
        this.grade = grade;
        return this;
    }
}
