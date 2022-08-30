package com.lege.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.custom.CustomAnalyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lege
 * @Description
 * @create 2022-08-30 15:08
 */
public class LuceneAnalyzerIntegrationTest {

    private static final String SAMPLE_TEXT = "This is baeldung.com Lucene Analyzers test";
    private static final String FIELD_NAME = "sampleName";

    /**
     * 标准分析
     *
     * @throws IOException
     */
    @Test
    public void whenUseStandardAnalyzer_thenAnalyzed() throws IOException {
        List<String> result = analyze(SAMPLE_TEXT, new StandardAnalyzer());

        result.forEach(System.out::println);
    }

    /**
     * 停止分析
     *
     * @throws IOException
     */
    @Test
    public void whenUseStopAnalyzer_thenAnalyzed() throws IOException {
        List<String> result = analyze(SAMPLE_TEXT, new StopAnalyzer());
        result.forEach(System.out::println);
    }

    /**
     * 简单分析
     *
     * @throws IOException
     */
    @Test
    public void whenUseSimpleAnalyzer_thenAnalyzed() throws IOException {
        List<String> result = analyze(SAMPLE_TEXT, new SimpleAnalyzer());
        result.forEach(System.out::println);
    }

    /**
     * 空白分析
     */
    @Test
    public void whenUseWhiteSpaceAnalyzer_thenAnalyzed() throws IOException {
        List<String> result = analyze(SAMPLE_TEXT, new WhitespaceAnalyzer());
        result.forEach(System.out::println);
    }

    /**
     * 关键词分析
     * @throws IOException
     */
    @Test
    public void whenUseKeywordAnalyzer_thenAnalyzed() throws IOException {
        List<String> result = analyze(SAMPLE_TEXT, new KeywordAnalyzer());
        result.forEach(System.out::println);
    }


    /**
     * 语言分析
     */
    @Test
    public void whenUseEnglishAnalyzer_thenAnalyzed() throws IOException {
        List<String> result = analyze(SAMPLE_TEXT, new EnglishAnalyzer());
        result.forEach(System.out::println);
    }

    @Test
    public void whenUseCustomAnalyzerBuilder_thenAnalyzed() throws IOException {
        Analyzer analyzer = CustomAnalyzer.builder()
                .withTokenizer("standard")
                .addTokenFilter("lowercase")
                .addTokenFilter("stop")
                .addTokenFilter("porterstem")
                .addTokenFilter("capitalization")
                .build();
        List<String> result = analyze(SAMPLE_TEXT, analyzer);
        result.forEach(System.out::println);


    }

    @Test
    public void whenUseCustomAnalyzer_thenAnalyzed() throws IOException {
        List<String> result = analyze(SAMPLE_TEXT, new MyCustomAnalyzer());
        result.forEach(System.out::println);
    }

    public List<String> analyze(String text, Analyzer analyzer) throws IOException {
        List<String> result = new ArrayList<String>();
        TokenStream tokenStream = analyzer.tokenStream(FIELD_NAME, text);
        CharTermAttribute attr = tokenStream.addAttribute(CharTermAttribute.class);
        tokenStream.reset();
        while (tokenStream.incrementToken()) {
            result.add(attr.toString());
        }
        return result;
    }



}
