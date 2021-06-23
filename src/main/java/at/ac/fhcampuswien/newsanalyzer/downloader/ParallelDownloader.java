package at.ac.fhcampuswien.newsanalyzer.downloader;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;


public class ParallelDownloader extends Downloader {

    @Override
    public int process(List<String> urls) {
        for(int i = 0; i < urls.size(); i++) {
            saveUrl(urls.get(i));
        }
        return urls.size();

    }



    private void saveUrl(String url){
        int numWorkers = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(numWorkers);
        pool.execute(() -> saveUrl2File(url));
    }



}
