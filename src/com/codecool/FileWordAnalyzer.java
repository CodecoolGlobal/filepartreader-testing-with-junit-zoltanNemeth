package com.codecool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List getWordsOrderedAlphabetically () throws IOException {
        List listToReturn = new ArrayList();
        String[] words = filePartReader.readLines().split(" ");
        Arrays.sort(words);
        for (String word : words) {
            listToReturn.add(word);
        }
        return listToReturn;
    }

    public List getWordsContainingSubstring (String subString ) throws IOException {
        List listToReturn = new ArrayList();
        String[] words = filePartReader.readLines().split(" ");
        Arrays.sort(words);
        for (String word : words) {
            if (word.contains(subString)) {
                listToReturn.add(word);
            }
        }
        return listToReturn;
    }

    public List getStringsWhichPalindromes () throws IOException {
        List listToReturn = new ArrayList();
        filePartReader.readLines();
        String[] words = filePartReader.readLines().split(" ");
        for (String word : words){
            StringBuilder sb = new StringBuilder();
            sb.append(word);
            if (word.equals(sb.reverse().toString())) {
                listToReturn.add(word);
            }
        }
        return listToReturn;
    }
}
