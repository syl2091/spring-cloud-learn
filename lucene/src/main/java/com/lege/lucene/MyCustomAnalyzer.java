package com.lege.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.apache.lucene.analysis.miscellaneous.CapitalizationFilter;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;

/**
 * @author lege
 * @Description
 * @create 2022-08-30 15:07
 */
public class MyCustomAnalyzer extends Analyzer {
    @Override
    protected TokenStreamComponents createComponents(String s) {
        final StandardTokenizer src = new StandardTokenizer();
        TokenStream result = new StandardFilter(src);
        result = new LowerCaseFilter(result);
        result = new StopFilter(result,  StandardAnalyzer.STOP_WORDS_SET);
        result = new PorterStemFilter(result);
        result = new CapitalizationFilter(result);
        return new TokenStreamComponents(src, result);
    }
}
