# HW4 - Maintain an ordered keyword list.

## Keyword
- A keyword is a tuple of [String name, Integer count, Double weight]
    For example:
    ```json
    {
        name: "Fang",  
        count: 3,
        weight: 5.5
    }
    ```
- A keyword should output in format [name, count, weight] : 
    For example: `[Fang,3,5.5]`

## List Ordering Rule
- Primary key: count → smaller count appears earlier
- Secondary key: weight → if count is the same, smaller weight appears earlier
- If both count and weight are the same, keep the insertion order.


## Add and Output
| operations             | description                                  |
| ---------------------- | -------------------------------------------- |
| `add(Keyword k)`       | Insert k to the list in order                |
| `outputIndex(int i)`   | Output the ith keyword in the list           |
| `outputCount(int c)`   | Output all keywords whose count = c          |
| `outputHas(string s)`  | Output all keywords whose name contains s    |
| `outputName(string s)` | Output all keywords whose name is equal to s |
| `outputFirstN(int n)`  | Output the first n keywords                  |
| `outputScore()`        | Output the score of the whole list           |

### Add
- Task: Insert a keyword [k,c,w] to the list in order
- Input tokens:
    - add Fang 3 1.5
- Rule: Smaller count placed in the front. If equal, smaller weight is placed in the front.

### outputIndex
- Task: Output the ith keyword in the list (index starts at 0)
- Input: outputIndex 3
- Output:
    - If out of bound → `InvalidOperation`
    - Else → `[NCCU,4,9.9]`

### outputCount
- Input: outputCount 4
- Output:
    - If no keyword found → `NotFound`
    - Else → `[OK,4,2.2] [MIS,4,3.3] [NCCU,4,9.9]`

### outputHas
- Input: outputHas ang
- Output:
    - If not found → `NotFound`
    - Else → `[Stanger,4,2.2] [Rang,4,3.3] [Fang,4,9.9] `

### outputName
- Input: outputName Fang
- Output:
    - If not found → `NotFound`
    - Else → `[Fang,4,9.9]`

### outputFirstN
- Input: outputFirstN 3
- Output:
    - If N > list size → `InvalidOperation`
    - Else → `[Stanger,4,2.2] [Rang,4,3.3] [Fang,4,9.9] `

### outputScore
Task: Output the score of the whole list = Σ(count × weight)
- Input: outputScore
- Output: `108.50`

## Delete
| operations             | description                                  |
| ---------------------- | -------------------------------------------- |
| `deleteIndex(int i)`   | Delete the ith keyword in the list           |
| `deleteCount(int c)`   | Delete all keywords whose count = c          |
| `deleteHas(string s)`  | Delete all keywords whose name contains s    |
| `deleteName(string s)` | Delete all keywords whose name is equal to s |
| `deleteFirstN(int n)`   | Delete the first n keywords                  |

### Delete Examples
- deleteIndex 3
    - Before: [A,1,1.0] [B,2,2.0] [C,3,3.0]
    - After: [A,1,1.0] [B,2,2.0]
    - If out of bound → `InvalidOperation`
- deleteCount 4 → delete all with count = 4 (no output)
- deleteHas ang → delete all names containing "ang" (no output)
- deleteName Fang → delete all with name "Fang" (no output)
- deleteFirstN 2 → delete first 2 keywords
    - If N > list size → `InvalidOperation`


## Input/ Output Example
### Input File
- Read operations from a txt file.

### Example input file (input.txt):
- Notice: If the file is not placed in the project root directory, you need to provide the path (either a relative path from the project folder, or an absolute path), otherwise the program will not find the file.

```txt
add Fang 3 1.5
add Yu 5 1.2
add NCCU 3 0.8
add UCSB 2 2.2
add MIS 2 1.2
...
outputScore
deleteCount 3
outputCount 2
outputName Yu
deleteName Yu
...
```
### Terminal Example
```
Please input the test file name.
input.txt
38.50
[MIS,2,1.2] [UCSB,2,2.2] 
[Yu,5,1.2]
[Badminton,4,2.3]
[Structure,4,2.1]
InvalidOperation
InvalidOperation
```

## Upload your code using Moodle
- **First Submission**: 10/04(Sun.) 12:00
- **Deadline**: 10/12(Mon.) 00:00