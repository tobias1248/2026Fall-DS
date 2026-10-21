# HW7 – Maintain a Keyword Min-Heap

Implement a **min-heap** data structure that maintains a collection of keywords.  
Each keyword has three attributes:
- name (String)
- count (Integer)
- weight (Double)

---

## Heap Properties

- The heap must satisfy:  
  `n.count ≥ n.parent.count`  
  (i.e., the root has the minimum count value)
- Implement the heap using `java.util.PriorityQueue`.
- When two keywords have the same `count`, break the tie by comparing `name` in ascending order, case-sensitive (`String.compareTo`).

---

## Commands

### 1. add
Insert a keyword `[name, count, weight]` into the heap.

**Format:**
```
add <name> <count> <weight>
```

**Example:**
```
add Fang 3 0.5
```

---

### 2. peek
Output (but do not remove) the keyword with the minimal count.

**Format:**
```
peek
```

**Output:**
- If the heap is empty:
  ```
  InvalidOperation
  ```
- Otherwise:
  ```
  [NCCU,4,9.9]
  ```

---

### 3. removeMin
Output (and remove) the root keyword (the same element that would be returned by `peek`).

**Format:**
```
removeMin
```

**Output:**
- If the heap is empty:
  ```
  InvalidOperation
  ```
- Otherwise:
  ```
  [NCCU,4,9.9]
  ```

---

### 4. output
Output **and remove** all keywords in ascending order (based on count).

Note: `PriorityQueue` does not iterate in ascending order (a for-each loop or `toString()` will not work) — keep removing the minimum element one at a time instead.

**Format:**
```
output
```

**Output:**
- If the heap is empty:
  ```
  InvalidOperation
  ```
- Otherwise:
  ```
  [NCCU,4,9.9] [MIS,5,6.8] [DS,6,1.6]
  ```

---

## Input / Output Specification

**Input:**
- Each line in the input file contains one command.
- Tokens are separated by spaces.

**Output:**
- Separate keywords with a single space.
- Do not include trailing spaces at the end of a line.

---

## Example

**Input:**
```plaintext
add Fang 3 1.2
add Yu 5 1.8
add NCCU 2 0.6
add UCSB 1 1.9
peek
add MIS 4 2.2
removeMin
add Badminton 1 0.6
output
```

**Output:**
```plaintext
[UCSB,1,1.9]
[UCSB,1,1.9]
[Badminton,1,0.6] [NCCU,2,0.6] [Fang,3,1.2] [MIS,4,2.2] [Yu,5,1.8]
```

---

## Notes

- This assignment has **no bonus**.  
- The file input.txt can be placed anywhere your program can access — e.g. the same folder as your `.java` files, or your project's root folder if your IDE doesn't look in the source folder. You do not need to include input.txt when submitting your assignment.

---

## Submission

- **First Submission:** 10/25 (Sun.) 11:59  
- **Final Deadline:** 11/1 (Sun.) 23:59  
- Upload your code via **Moodle**.

