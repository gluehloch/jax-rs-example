package de.awtools.rest.lucene;

import java.io.File;
import java.io.FileFilter;

public class MarkdownFileFilter implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        return pathname.getName().toLowerCase().endsWith(".md");
    }

}
