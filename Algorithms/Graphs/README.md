# Graphs
Some topic covered:

### Graph Basics
Main ways to traverse a graph: DFS and BFS.

## Main Algorithms

### Depth First Search
Use a stack for traverse it. DFS by itself doesn't guarantee the shortest path, only a path. Therefore use DFS when you want to **exhaust** all possibilities, and check which one is the best/count the number of all possible ways.

- Find connected components (ideal for island count type problems and island variants).
- Shortest time.
- Finding Bridges of graph.

```
public void DFS(T node){
  
    Stack<T> stack = new Stack<>();
    stack.push(node);

    while(!stack.isEmpty()){
    
        T current = stack.pop();
        if(!visited.contains(current)){
              process(node);
              visited.add(node);
              
              if(adjacentMatrix.contains(current)){
                    List<T> children = adjacentMatrix.getChildren();
                    for(child: children)
                      stack.push(child);
              }
        }
    }
    
    return;
}
```

### Breadth First Search
Use a queue for traverse it. BFS guarantees visiting all nodes at distance 1 before those at distance 2, etc, which means it gives an optimal solution. Therefore use BFS when you want to find the **shortest** path from a certain source node to a certain destination. (Or more generally, the smallest number of steps to reach the end state from a given initial state.)

- Shortest path*.
- Coloring graph.
- Bipartition.

```
public void BFS(T node){
    Queue<T> queue = new LinkedList<>();
    
    while(!queue.isEmpty()){
        T current = queue.poll();
        if(!visited.contains(current)){
              process(node);
              visited.add(node);
              
              if(adjacentMatrix.contains(current)){
                    List<T> children = adjacentMatrix.getChildren();
                    for(child: children)
                      stack.push(child);
              }
        }
    }
    
    return;
}
```

## Common strategies

### Union Find
Performs operations in a disjoint sets in order to identify if problems talks about finding groups or components.
- Count the number of disjoint sets.
- Find the reduntant connection.
- Number of operation to make a network connected.


### Detect Cycle
- DFS approach.
- Topological Sort approach
- Floyd approach


### Topological Sort
Given a directed acylic graph, the topological sort is a linear ordering of vertices such that for every directed edge u v, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.






</br>
</br>
</br>
</br>
</br>

REFERENCES:

- [Full Course Graphs for Technical Inteviews](https://www.youtube.com/watch?v=tWVWeAqZ0WU&t=694s)
- [Main graphs algo exercises](https://leetcode.com/discuss/general-discussion/655708/Graph-For-Beginners-Problems-or-Pattern-or-Sample-Solutions) and its [list](https://leetcode.com/discuss/interview-question/753236/List-of-graph-algorithms-for-coding-interview)
- [DFS implementation](https://favtutor.com/blogs/depth-first-search-java)
- [Basic Graph Patterns for most problems: A leetcode discussion](https://leetcode.com/discuss/general-discussion/655708/Graph-For-Beginners-Problems-or-Pattern-or-Sample-Solutions)

