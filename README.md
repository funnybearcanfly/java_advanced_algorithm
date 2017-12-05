# java_advanced_algorithm
Java高级算法的示例代码 Sxample code for Java advanced algorithms

Graph相关的算法
1. 广度优先搜索 Breadth First Search. 可用于网络爬虫。
2. 深度优先搜索 Depth First Search. 可用于环监测、图节点的拓扑排序、迷宫生成和探路等。
3. 最短路径算法 Shortest Path Algorithm. 
    <br>3.1 Dijkstra Algorithm. 可用优先队列（堆）来优化实现。无法处理负权重路径。O(V*logV + E)
    <br>3.2 Bellman-Ford Algorithm. 通过反复遍历路径序列来实现。可以处理负权重路径和环。可用于发现负环（Negative Cycle），如，外汇套利；或侦测关键路径。O(V*E)
    <br>3.3 DAG Algorithm. 优先生成节点的拓扑排序，然后按顺序做Relaxing操作。无法处理带环图。O(V + E)
