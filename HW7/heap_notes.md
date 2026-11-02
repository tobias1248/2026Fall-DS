# Heaps: Properties, Operations, and Complexity

## 1. What Is a Heap?

A heap is a data structure that provides efficient access to the highest-priority element. It is commonly used to implement a **priority queue**.

- A **min-heap** keeps the smallest element at the root.
- A **max-heap** keeps the largest element at the root.

A heap is not a fully sorted collection. It only constrains the priority relationship between each parent and its children. The root is the minimum (or maximum), but the remaining elements are not necessarily in sorted order.

## 2. The Two Properties of a Binary Heap

A binary heap is a binary tree that satisfies both of the following properties.

### 2.1 Complete Binary Tree

Every level is full except possibly the last one. Nodes on the last level are filled from left to right, with no gaps.

```text
          A
        /   \
       B     C
      / \   /
     D   E F
```

### 2.2 Heap-Order Property

In a min-heap, each parent has priority no lower than its children. If priority is based only on numeric values, this means:

```text
parent <= child
```

For example, this is a valid min-heap:

```text
             [1, Badminton]
              /           \
         [1, UCSB]        [2, NCCU]
          /
      [3, Fang]
```

Nodes at the same level do not need to be sorted relative to one another. Each parent only needs to have priority at least as high as its own children.

## 3. Representing a Binary Heap with an Array

A complete binary tree can be stored in an array in level order: top to bottom, and left to right within each level. This avoids storing separate parent, left-child, and right-child pointers.

For a zero-based array, the relationships for index `i` are:

```text
parent(i) = (i - 1) / 2        // when i > 0; integer division
left(i)   = 2 * i + 1
right(i)  = 2 * i + 2
```

The array representation of the example above is:

```text
index:  0               1          2         3        4       5
value: [1,Badminton] [1,UCSB] [2,NCCU] [3,Fang]  ...     ...
```

These index formulas make it possible to find a node's parent and children directly.

## 4. Common Priority Queue Operations

Names vary across languages and implementations, but the common operations have similar meanings:

| Operation | Meaning |
|---|---|
| `insert` / `add` | Add an element |
| `peek` / `findMin` | View the minimum without removing it |
| `poll` / `deleteMin` | Remove and return the minimum |
| `isEmpty` | Check whether the queue is empty |
| `size` | Get the number of elements |

### Inserting an Element: Sift-Up

Place the new element at the end of the array to preserve the complete-tree shape. Compare it with its parent; if the new element has higher priority, swap them. Continue until the heap order is restored or the element reaches the root. This process is called **sift-up**.

### Removing the Minimum: Sift-Down

The minimum is at the root. After removing it, move the last array element to the root. Compare it with its higher-priority child and swap as needed until the heap-order property is restored. This process is called **sift-down**.

## 5. Building a Heap: Top-Down and Bottom-Up

This document uses the following definitions. Some materials use the term `heapify` slightly differently.

### 5.1 Top-Down: Insert Elements One at a Time

Start with an empty heap and insert each element, performing sift-up after every insertion.

With `n` elements, each insertion may take up to `O(log n)` time, so building a heap this way takes `O(n log n)` time in the worst case.

### 5.2 Bottom-Up: Adjust from the Last Internal Node to the Root

First place all elements in an array. Leaves have no children, so they already satisfy the heap-order property. Starting from the last internal node, perform sift-down on each node in reverse level order until reaching the root.

For a zero-based array, the last internal node has index:

```text
floor(n / 2) - 1
```

Bottom-up heap construction takes `O(n)` time. Most nodes are close to the leaves and can move down only a short distance. The few nodes near the root may move farther, but there are fewer of them.

### Why Is Bottom-Up Construction O(n)?

Group nodes by how many levels they can move downward. A node of height `h` can move down at most `h` levels, and there are roughly `n / 2^(h+1)` nodes of that height. The total work can therefore be estimated as:

```text
W ≈ n(1/4 + 2/8 + 3/16 + 4/32 + ...)
```

Let:

```text
S = 1/4 + 2/8 + 3/16 + 4/32 + ...
2S = 1/2 + 2/4 + 3/8 + 4/16 + ...
```

Subtracting the first equation from the second gives:

```text
S = 1/2 + 1/4 + 1/8 + ... = 1
```

So this simplified estimate is about `n`. Rounding in the number of nodes affects the constant, but the total work is still bounded by a constant multiple of `n`. Therefore, the time complexity is `O(n)`.

## 6. Time and Space Complexity

| Operation | Time complexity |
|---|---:|
| View the root (`peek`) | `O(1)` |
| Insert an element | `O(log n)` |
| Remove the root (`poll` / `deleteMin`) | `O(log n)` |
| One sift-up or sift-down | `O(log n)` |
| Build by repeated insertion (top-down) | `O(n log n)` in the worst case |
| Build with bottom-up heap construction | `O(n)` |
| Search for an arbitrary element | `O(n)` |
| Store `n` elements | `O(n)` space |

The height of a binary heap is `O(log n)`, so a sift-up or sift-down takes at most `O(log n)` time.

## 7. How This Relates to HW7

HW7 requires `java.util.PriorityQueue`, so you do not need to implement the array, sift-up, sift-down, or heapify operations yourself. Java's `PriorityQueue` maintains the heap property when elements are inserted and removed.

The priority order for the assignment is defined by `KeywordComparator`:

1. Compare `count`; the smaller count has higher priority.
2. If the counts are equal, compare `name` using case-sensitive `String.compareTo()`.
3. `weight` is stored and printed, but does not affect ordering.

`peek()` views the minimum without removing it. `poll()` removes and returns the minimum. Iterating directly over a `PriorityQueue` does not guarantee sorted order, so HW7's `output` command repeatedly calls `poll()`.

## 8. Common Misconceptions

- A heap is not a sorted array; it only guarantees the priority relationship between parents and children.
- A min-heap guarantees that the root is the minimum. It does not guarantee that the left and right subtrees are sorted relative to each other.
- `peek()` does not remove an element; `poll()` does.
- Repeated insertion and bottom-up heap construction are different methods, with complexities of `O(n log n)` and `O(n)`, respectively.
- A Java `PriorityQueue` iterator does not return elements in priority order.
