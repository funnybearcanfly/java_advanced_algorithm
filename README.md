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
4. 最小生成树 Spinning Tree
    <br>4.1 Kruskal Algorithm.
    <br>基于路径的最小生成树算法。对路径按权重进行排序；依次把边的两个节点加入Disjoint set；当所有子set合为一个set时，停止。
	<br>使用Disjoint set是为了能在O(1)时间内查询边的两个节点是否已经被添加，从而提升性能。
	<br>它属于贪婪算法。时间复杂度为O(N*logN)
	<br>4.2 Prim-Jarnik Algorithm.
	<br>基于节点的最小生成树算法。以一个节点为起点，每次取当前节点上不重复的最短路径。
	<br>有Lazy和Eager两种实现方式。都用到堆来实现，只是前者在运算过程中不主动更新堆，而后者会在添加每条路径前对堆去重并排序。
	<br>平均时间复杂度为O(E*logE)，最差为O(E*logV)。额外内存消耗为O(E)
</p>
<p>
5.  强连接子图 Strongly Connected Component
    <br>5.1 Kosaraju Algorithm.
    <br>做两次DFS。第一次正向DFS，把节点进行拓扑排序；第二次按排序顺序，逆向DFS，找出强连接子图。
	<br>5.2 Tarjan Algorithm.
	<br>做一次DFS，为每个节点指定深度编号，发现节点的后续节点深度小于当前深度时，即发现强连接子图。用栈来存储遍历时节点。
</p>
<p>
6.  最大流量问题 Max Flow
    <br>Ford-Fulkerson Algorithm：关键是定义一个和原图G(V,E)对应的residual graph G'(V,E). 然后分两步循环执行算法
	<br>a. 在G(V,E)找到从s到t的最短路径，用路径上的最小负载去更新G(V,E)对应路径上的负载。
	<br>b. 更新G'(V,E)，再找最短路径、更新。当在G'(V,E)上找不出最短路径时，停止。
</p>
<p>
7.  销售员节点遍历问题 Travelling Salesman Problem
    <br>图的节点之间两两相连。目标是找出一条从原点出发、不重复地经过所有节点、最后回到原点的最短路径。
	<br>a. 从图的角度出发，这是要找到一个Hamiltonian Cycle.
	<br>b. 从问题性质的角度出发，这是一个NP问题。因为如果用穷举法，复杂度将会是O(n!)，无法直接计算。
	<br>综合问题的特点，可以考虑使用Simulated Annealing（退火算法）或Generic Algorithm（遗传算法）。这里实现的是退火算法。
</p>
