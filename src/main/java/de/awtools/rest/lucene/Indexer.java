package de.awtools.rest.lucene;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Indexer {

    public static final String CONTENTS = "contents";
    public static final String FILE_NAME = "filename";
    public static final String FILE_PATH = "filepath";
    public static final int MAX_SEARCH = 10;

    private IndexWriter writer;

    public Indexer(String indexDirectoryPath) throws IOException {
        Directory indexDirectory = FSDirectory.open(Paths.get(indexDirectoryPath));

        StandardAnalyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        writer = new IndexWriter(indexDirectory, iwc);
    }

    public void close() throws CorruptIndexException, IOException {
        writer.close();
    }

    private Document getDocument(File file) throws IOException {
        Document document = new Document();

        TextField contentField = new TextField(CONTENTS, new FileReader(file));
        TextField fileNameField = new TextField(FILE_NAME, file.getName(), TextField.Store.YES);
        TextField filePathField = new TextField(FILE_PATH, file.getCanonicalPath(), TextField.Store.YES);

        document.add(contentField);
        document.add(fileNameField);
        document.add(filePathField);

        return document;
    }

    private void indexFile(File file) throws IOException {
        System.out.println("Indexing " + file.getCanonicalPath());
        Document document = getDocument(file);
        writer.addDocument(document);
    }

    public long createIndex(String dataDirPath, FileFilter filter) throws IOException {
        File[] files = new File(dataDirPath).listFiles();

        for (File file : files) {
            if (!file.isDirectory()
                    && !file.isHidden()
                    && file.exists()
                    && file.canRead()
                    && filter.accept(file)) {
                indexFile(file);
            }
        }
        return writer.getPendingNumDocs();
        // return writer.numDocs();
    }
}
