# Hash & Heaps

## Heaps
Heaps are a type of data structure represented as a complete binary tree where satisfay the next property:
- If it's a max Heap: When every node is greater than its child node/s.
- It is's a min Heap: When every node is smaller than its child node/s.

Is internally represented as a vector where:

![image](https://user-images.githubusercontent.com/3811449/147384190-aeeb99a3-38a9-46c9-97f2-ae48f6d1afb8.png)


- The head of the array is the max (or min) element.
- The left child is in the 2* currentNode -1 position in the array.
- The right child is in the 2 * currentNode -2 position in the array.


### Insert a new node
- The new element is inserted to the array.
- Hepify* the subtree until the heap property is satisfied.
- Inserting a new element to the heap has a cost of O(log n)[[1]](#1)

### Delete a node
- Access to the node to delete.
- Swap it with the most remote leaf (the last element of the array).
- Hepify from the swapped node.
- Deleting a new element to the heap has a cost of O(log n) [[2]](#2)

### Uses
- Whenever you need quick access to the largest (or smallest) item.
- Priority queues, schedulers (where the **earliest** item is desired).
- Dijktra implementation.

REFERENCES

<a id="1">[1]</a> StackOverflow, (2010) [What's faster: inserting into a PQ or sorting retrospectively?](https://stackoverflow.com/questions/3759112/whats-faster-inserting-into-a-priority-queue-or-sorting-retrospectively/10761286)
       
<a id="2">[2]</a> StackOverflow, (2009) [Time complexity of the heap pop operations](https://stackoverflow.com/questions/52556930/time-complexity-of-the-heap-pop-operation)
