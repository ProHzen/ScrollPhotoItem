package com.eebbk.open.scrollphotoitem.expandablelayout.bean;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2018/1/23 19:16
 * Email:  369013520@qq.com
 */

public class DisplayDictCharacter {

    /**
     * 关键字
     */
    private String word;

    /**
     * 释义
     */
    private String explanation;

    /**
     * 例证
     */
    private String example;

    /**
     * 多音
     */
    private String multiTone;


    /**
     * 短语
     */
    private String phrase;

    /**
     * 音标
     */
    private String phonetic;

    public String getWord() {
        return word;
    }

    public DisplayDictCharacter setWord(String word) {
        this.word = word;
        return this;
    }

    public String getExplanation() {
        return explanation;
    }

    public DisplayDictCharacter setExplanation(String explanation) {
        this.explanation = explanation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public DisplayDictCharacter setExample(String example) {
        this.example = example;
        return this;
    }

    public String getMultiTone() {
        return multiTone;
    }

    public DisplayDictCharacter setMultiTone(String multiTone) {
        this.multiTone = multiTone;
        return this;
    }

    public String getPhrase() {
        return phrase;
    }

    public DisplayDictCharacter setPhrase(String phrase) {
        this.phrase = phrase;
        return this;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public DisplayDictCharacter setPhonetic(String phonetic) {
        this.phonetic = phonetic;
        return this;
    }

    public void clear() {
        word = "";
        phonetic = "";
        explanation = "";
        example = "";
        phrase = "";
        multiTone = "";
    }
}
