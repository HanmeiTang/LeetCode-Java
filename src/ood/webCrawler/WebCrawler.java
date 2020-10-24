package ood.webCrawler;


// 1. Design a web crawler
// What is a web crawler
// 针对什么网页，爬取什么数据 ---> 当拿到一个抽象的概念，一定要具体化，明确use case
// 我到底要support什么网页，抓取什么信息
// Eg1. COVID-19 integrated info --> 不用考虑实时性，一天更新一次也没关系
// Eg2. Google engine  -->
// 文献，股票，新闻

// 把问题抽象出来
// web crawler --> graph traversal --> BFS
// node = html page
// edge = hyperlink

// why we don't use dfs?
// in the future, if we want scale up this service, bfs is easier to run parallelly

// 爬虫实现最难的问题是什么？
// 我认为是如何分配任务
// 首先网页不是可见的100个任务，它实时都在更新
// Producer --> [Pending] --> consumer
//

public class WebCrawler {
}
