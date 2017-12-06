# java_advanced_algorithm
Java高级算法的示例代码 Sxample code for Java advanced algorithms

Graph相关的算法
<p>
1. 广度优先搜索 Breadth First Search. 
    <br>可用于网络爬虫。
</p>
<p>
2. 深度优先搜索 Depth First Search.
    <br>可用于环监测、图节点的拓扑排序、迷宫生成和探路等。
</p>
<p>
3. 最短路径算法 Shortest Path Algorithm. 
    <br>3.1 Dijkstra Algorithm.
    <br>可用优先队列（堆）来优化实现。无法处理负权重路径。O(V*logV + E)
    <br>3.2 Bellman-Ford Algorithm.
    <br>通过反复遍历路径序列来实现。可以处理负权重路径和环。可用于发现负环（Negative Cycle），如，外汇套利；或侦测关键路径。O(V*E)
    <br>3.3 DAG Algorithm.
    <br>优先生成节点的拓扑排序，然后按顺序做Relaxing操作。无法处理带环图。O(V + E)
</p>
<p>
4. 最小生成树 
    <br>4.1 Kruskal Algorithm.
    <br>基于路径的最小生成树算法。对路径按权重进行排序；依次把边的两个节点加入Disjoint set；当所有子set合为一个set时，停止。
	<br>使用Disjoint set是为了能在O(1)时间内查询边的两个节点是否已经被添加，从而提升性能。
	<br>它属于贪婪算法。时间复杂度为O(N*logN)
	<br>4.2 Prim-Jarnik Algorithm.
	<br>基于节点的最小生成树算法。以一个节点为起点，每次取当前节点上不重复的最短路径。
	<br>有Lazy和Eager两种实现方式。都用到堆来实现，只是前者在运算过程中不主动更新堆，而后者会在添加每条路径前对堆去重并排序。
	<br>平均时间复杂度为O(E*logE)，最差为O(E*logV)。额外内存消耗为O(E)
</p>