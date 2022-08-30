package com.lege.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.BytesRef;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author lege
 * @Description
 * @create 2022-08-29 16:38
 */
public class InMemoryLuceneIndex {

    private Directory memoryIndex;
    private Analyzer analyzer;

    public InMemoryLuceneIndex(Directory memoryIndex, Analyzer analyzer) {
        super();
        this.memoryIndex = memoryIndex;
        this.analyzer = analyzer;
    }

    /**
     *
     * @param title
     * @param body
     */
    public void indexDocument(String title, String body) {

        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        try {
            IndexWriter writter = new IndexWriter(memoryIndex, indexWriterConfig);
            Document document = new Document();

            document.add(new TextField("title", title, Field.Store.YES));
            document.add(new TextField("body", body, Field.Store.YES));
            document.add(new SortedDocValuesField("title", new BytesRef(title)));

            writter.addDocument(document);
            writter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Document> searchIndex(String inField, String queryString) {
        try {
            Query query = new QueryParser(inField, analyzer).parse(queryString);

            IndexReader indexReader = DirectoryReader.open(memoryIndex);
            IndexSearcher searcher = new IndexSearcher(indexReader);
            TopDocs topDocs = searcher.search(query, 10);
            List<Document> documents = new ArrayList<>();
            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
                documents.add(searcher.doc(scoreDoc.doc));
            }

            return documents;
        } catch (IOException | org.apache.lucene.queryparser.classic.ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void deleteDocument(Term term) {
        try {
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
            IndexWriter writter = new IndexWriter(memoryIndex, indexWriterConfig);
            writter.deleteDocuments(term);
            writter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Document> searchIndex(Query query) {
        try {
            IndexReader indexReader = DirectoryReader.open(memoryIndex);
            IndexSearcher searcher = new IndexSearcher(indexReader);
            TopDocs topDocs = searcher.search(query, 10);
            List<Document> documents = new ArrayList<>();
            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
                documents.add(searcher.doc(scoreDoc.doc));
            }

            return documents;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<Document> searchIndex(Query query, Sort sort) {
        try {
            IndexReader indexReader = DirectoryReader.open(memoryIndex);
            IndexSearcher searcher = new IndexSearcher(indexReader);
            TopDocs topDocs = searcher.search(query, 10, sort);
            List<Document> documents = new ArrayList<>();
            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
                documents.add(searcher.doc(scoreDoc.doc));
            }

            return documents;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


}
