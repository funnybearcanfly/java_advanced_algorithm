package com.funnybear.advanced.algorithm.BreadthFirstSearch.WebCrawler;

public class App {

	public static void main(String[] args) {

		WebCrawler crawler = new WebCrawler();

		String rootUrl = "http://www.google.com";

		crawler.discoverWeb(rootUrl);

	}

}
