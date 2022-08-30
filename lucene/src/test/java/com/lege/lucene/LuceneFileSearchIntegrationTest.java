package com.lege.lucene;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author lege
 * @Description
 * @create 2022-08-30 14:06
 */
public class LuceneFileSearchIntegrationTest {

    @Test
    public void givenSearchQueryWhenFetchedFileNamehenCorrect() throws IOException, URISyntaxException {
        String indexPath = "index";
        String dataPath = "data/file1.txt";

        Directory directory = FSDirectory.open(Paths.get(indexPath));
        LuceneFileSearch luceneFileSearch = new LuceneFileSearch(directory, new StandardAnalyzer());

        luceneFileSearch.addFileToIndex(dataPath);

        List<Document> docs = luceneFileSearch.searchFiles("contents", "沈永乐");
        docs.forEach(System.out::println);
    }
}
