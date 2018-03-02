package com.eebbk.open.scrollphotoitem.expandablelayout.bean;


/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2018/1/23 17:45
 * Email:  369013520@qq.com
 */

public class DisplayCharacterBean {

    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public int type;

    public DisplayCharacterBean(int type) {
        this.type = type;
    }

    /**
     * 关键字
     */
    private String word;

    /**
     * 拼音
     */
    private String phonetic;

    /**
     * 拼音播放地址
     */
    private String phoneticVoiceVo;

    /**
     * 音序
     */
    private String phoneticSequence;

    /**
     * 多音字
     */
    private String polyphone;

    /**
     * 部首
     */
    private String radicals;

    /**
     * 笔画
     */
    private String strokes;

    /**
     * 结构
     */
    private String structure;

    /**
     * 笔顺url
     */
    private String strokesOrderUrl;

    /**
     * 相似词
     */
    private String characterSimilarity;

    /**
     * 易错提示
     */
    private String fallibilityHint;

    /**
     * 图解url
     */
    private String diagrammatizeUrl;

    /**
     * 字义（现代汉语意思）
     */
    private String characterParaphrase;

    /**
     * 近义词
     */
    private String characterSynonym;

    /**
     * 反义词
     */
    private String characterAntonym;

    /**
     * 造句
     */
    private String characterSentence;

    /**
     * 组词
     */
    private String combineWords;

    /**
     * 字源视频url
     */
    private String characterOriginVideoUrl;

    public String getWord() {
        return word;
    }

    public DisplayCharacterBean setWord(String word) {
        this.word = word;
        return this;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public DisplayCharacterBean setPhonetic(String phonetic) {
        this.phonetic = phonetic;
        return this;
    }

    public String getPhoneticVoiceVo() {
        return phoneticVoiceVo;
    }

    public DisplayCharacterBean setPhoneticVoiceVo(String phoneticVoiceVo) {
        this.phoneticVoiceVo = phoneticVoiceVo;
        return this;
    }

    public String getPhoneticSequence() {
        return phoneticSequence;
    }

    public DisplayCharacterBean setPhoneticSequence(String phoneticSequence) {
        this.phoneticSequence = phoneticSequence;
        return this;
    }

    public String getPolyphone() {
        return polyphone;
    }

    public DisplayCharacterBean setPolyphone(String polyphone) {
        this.polyphone = polyphone;
        return this;
    }

    public String getRadicals() {
        return radicals;
    }

    public DisplayCharacterBean setRadicals(String radicals) {
        this.radicals = radicals;
        return this;
    }

    public String getStrokes() {
        return strokes;
    }

    public DisplayCharacterBean setStrokes(String strokes) {
        this.strokes = strokes;
        return this;
    }

    public String getStructure() {
        return structure;
    }

    public DisplayCharacterBean setStructure(String structure) {
        this.structure = structure;
        return this;
    }

    public String getStrokesOrderUrl() {
        return strokesOrderUrl;
    }

    public DisplayCharacterBean setStrokesOrderUrl(String strokesOrderUrl) {
        this.strokesOrderUrl = strokesOrderUrl;
        return this;
    }

    public String getCharacterSimilarity() {
        return characterSimilarity;
    }

    public DisplayCharacterBean setCharacterSimilarity(String characterSimilarity) {
        this.characterSimilarity = characterSimilarity;
        return this;
    }

    public String getFallibilityHint() {
        return fallibilityHint;
    }

    public DisplayCharacterBean setFallibilityHint(String fallibilityHint) {
        this.fallibilityHint = fallibilityHint;
        return this;
    }

    public String getDiagrammatizeUrl() {
        return diagrammatizeUrl;
    }

    public DisplayCharacterBean setDiagrammatizeUrl(String diagrammatizeUrl) {
        this.diagrammatizeUrl = diagrammatizeUrl;
        return this;
    }

    public String getCharacterParaphrase() {
        return characterParaphrase;
    }

    public DisplayCharacterBean setCharacterParaphrase(String characterParaphrase) {
        this.characterParaphrase = characterParaphrase;
        return this;
    }

    public String getCharacterSynonym() {
        return characterSynonym;
    }

    public DisplayCharacterBean setCharacterSynonym(String characterSynonym) {
        this.characterSynonym = characterSynonym;
        return this;
    }

    public String getCharacterAntonym() {
        return characterAntonym;
    }

    public DisplayCharacterBean setCharacterAntonym(String characterAntonym) {
        this.characterAntonym = characterAntonym;
        return this;
    }

    public String getCharacterSentence() {
        return characterSentence;
    }

    public DisplayCharacterBean setCharacterSentence(String characterSentence) {
        this.characterSentence = characterSentence;
        return this;
    }

    public String getCombineWords() {
        return combineWords;
    }

    public DisplayCharacterBean setCombineWords(String combineWords) {
        this.combineWords = combineWords;
        return this;
    }

    public String getCharacterOriginVideoUrl() {
        return characterOriginVideoUrl;
    }

    public DisplayCharacterBean setCharacterOriginVideoUrl(String characterOriginVideoUrl) {
        this.characterOriginVideoUrl = characterOriginVideoUrl;
        return this;
    }

    public int getType() {
        return type;
    }

    public DisplayCharacterBean setType(int type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "DisplayCharacterBean{" +
                "word='" + word + '\'' +
                ", phonetic='" + phonetic + '\'' +
                ", phoneticVoiceVo='" + phoneticVoiceVo + '\'' +
                ", phoneticSequence='" + phoneticSequence + '\'' +
                ", polyphone='" + polyphone + '\'' +
                ", radicals='" + radicals + '\'' +
                ", strokes='" + strokes + '\'' +
                ", structure='" + structure + '\'' +
                ", strokesOrderUrl='" + strokesOrderUrl + '\'' +
                ", characterSimilarity='" + characterSimilarity + '\'' +
                ", fallibilityHint='" + fallibilityHint + '\'' +
                ", diagrammatizeUrl='" + diagrammatizeUrl + '\'' +
                ", characterParaphrase='" + characterParaphrase + '\'' +
                ", characterSynonym='" + characterSynonym + '\'' +
                ", characterAntonym='" + characterAntonym + '\'' +
                ", characterSentence='" + characterSentence + '\'' +
                ", combineWords='" + combineWords + '\'' +
                ", characterOriginVideoUrl='" + characterOriginVideoUrl + '\'' +
                '}';
    }
}
