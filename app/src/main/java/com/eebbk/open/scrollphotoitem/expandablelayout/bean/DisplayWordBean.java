package com.eebbk.open.scrollphotoitem.expandablelayout.bean;

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2018/1/23 17:56
 * Email:  369013520@qq.com
 */

public class DisplayWordBean {

    /**
     * 关键字
     */
    private String word;

    /**
     * 音标
     */
    private String phonetic;

    /**
     * 词语解释文本
     */
    private String wordParaphraseVo;

    /**
     * 近义词
     */
    private String wordSynonymVo;

    /**
     * 反义词
     */
    private String wordAntonymVo;

    /**
     * 造句
     */
    private String wordSentenceVo;

    public String getWord() {
        return word;
    }

    public DisplayWordBean setWord(String word) {
        this.word = word;
        return this;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public DisplayWordBean setPhonetic(String phonetic) {
        this.phonetic = phonetic;
        return this;
    }

    public String getWordParaphraseVo() {
        return wordParaphraseVo;
    }

    public DisplayWordBean setWordParaphraseVo(String wordParaphraseVo) {
        this.wordParaphraseVo = wordParaphraseVo;
        return this;
    }

    public String getWordSynonymVo() {
        return wordSynonymVo;
    }

    public DisplayWordBean setWordSynonymVo(String wordSynonymVo) {
        this.wordSynonymVo = wordSynonymVo;
        return this;
    }

    public String getWordAntonymVo() {
        return wordAntonymVo;
    }

    public DisplayWordBean setWordAntonymVo(String wordAntonymVo) {
        this.wordAntonymVo = wordAntonymVo;
        return this;
    }

    public String getWordSentenceVo() {
        return wordSentenceVo;
    }

    public DisplayWordBean setWordSentenceVo(String wordSentenceVo) {
        this.wordSentenceVo = wordSentenceVo;
        return this;
    }
}
