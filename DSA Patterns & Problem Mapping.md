# DSA Patterns & Problem Mapping

> Personal interview revision guide for the LeetCode repository.
>
> Goal: Do not memorize individual solutions. Memorize the **pattern, trigger, invariant, and template**.

---

# Table of Contents

1. Pattern Recognition Decision Tree
2. Arrays & Hashing
3. Two Pointers
4. Sliding Window
5. Binary Search
6. Stack
7. Monotonic Stack
8. Linked Lists
9. Trees
10. Binary Search Trees
11. Graphs
12. Matrix / Grid
13. Backtracking
14. Dynamic Programming
15. Greedy
16. Prefix Sum
17. SQL
18. Full Problem-to-Pattern Mapping
19. Interview Revision Checklist

---

# 1. Pattern Recognition Decision Tree

When you see a new problem, ask these questions in order.

```text
                            NEW PROBLEM
                                 |
                 +---------------+---------------+
                 |                               |
              Array/String                    Tree/Graph
                 |                               |
       +---------+---------+              +------+------+
       |                   |              |             |
   Contiguous?          Sorted?          Tree         Graph
       |                   |              |             |
      Yes                 Yes        +----+----+   +----+----+
       |                   |         |         |   |         |
Sliding Window      Binary Search/  Level    Path BFS/DFS  Dependencies
                    Two Pointers     |        |
                                    BFS      DFS

```

More detailed triggers:

| Problem Signal | Likely Pattern |
|---|---|
| Duplicate / frequency | HashMap / HashSet |
| Pair in sorted array | Two Pointers |
| Contiguous substring/subarray | Sliding Window |
| Search sorted data | Binary Search |
| Min/max possible answer | Binary Search on Answer |
| Next greater/smaller | Monotonic Stack |
| Matching brackets | Stack |
| Linked list cycle | Fast/Slow Pointer |
| Reverse linked list | Pointer Manipulation |
| Tree level | BFS |
| Tree path/height | DFS |
| BST | Use ordering property |
| Dependencies | Directed Graph / Topological Sort |
| Undirected connections | DFS/BFS + Parent |
| All combinations | Backtracking |
| Count ways / optimize | Dynamic Programming |
| Grid / island | DFS/BFS |
| Locally optimal decision | Greedy |
| Range sum | Prefix Sum |

---

# 2. Arrays & Hashing

## Recognition Trigger

Look for:

- Duplicate
- Frequency
- Count
- Previously seen
- Lookup
- Pair relationship
- Distinct values

## Core Idea

Use extra memory to avoid repeatedly searching.

## Template

```java
Map<Integer, Integer> frequency = new HashMap<>();

for (int num : nums) {
    frequency.put(num, frequency.getOrDefault(num, 0) + 1);
}
```

For existence:

```java
Set<Integer> seen = new HashSet<>();

for (int num : nums) {
    if (!seen.add(num)) {
        return true;
    }
}
```

## Problems

| Problem | Core Pattern | Memory Trigger |
|---|---|---|
| Contains Duplicate | HashSet | Have I seen this before? |
| Majority Element | Frequency / Boyer-Moore | Element occurring > n/2 |
| Intersection of Two Arrays II | Frequency HashMap | Match counts between arrays |
| First Unique Character | Frequency Array/Map | Count then scan |
| Count Good Meals | HashMap + Complement | Pair sum is power of two |
| Count Special Quadruplets | HashMap / Enumeration | Count combinations efficiently |
| Custom Sort String | Frequency Counting | Reorder using custom priority |

## Memory Sentence

> Need to remember something from earlier elements? Use HashMap or HashSet.

---

# 3. Two Pointers

## Recognition Trigger

- Sorted array
- Pair sum
- Compare from both ends
- Palindrome
- Remove duplicates
- Maximum area
- Subsequences

## Template

```java
int left = 0;
int right = nums.length - 1;

while (left < right) {

    if (condition) {
        left++;
    } else {
        right--;
    }
}
```

## Problems

| Problem | Pattern | Key Insight |
|---|---|---|
| 3Sum | Sort + Two Pointers | Fix one number, solve 2Sum |
| Container With Most Water | Two Pointers | Move smaller height |
| Boats to Save People | Sort + Two Pointers | Pair heaviest with lightest |
| Is Subsequence | Two Pointers | Match characters sequentially |
| Max Number of K-Sum Pairs | Sort/Map + Two Pointers | Find complement pairs |
| Longest Word Through Deleting | Two Pointers | Check subsequence |

## Memory Sentence

> Sorted data + relationship between two elements = Two Pointers.

---

# 4. Sliding Window

## Recognition Trigger

Look for:

- Subarray
- Substring
- Contiguous
- Longest
- Shortest
- At most K
- Without repeating

## Generic Template

```java
int left = 0;

for (int right = 0; right < nums.length; right++) {

    // Add nums[right]

    while (window is invalid) {
        // Remove nums[left]
        left++;
    }

    // Update answer
}
```

## Problems

| Problem | Window Type | Key Idea |
|---|---|---|
| Longest Substring Without Repeating Characters | Variable | Shrink when duplicate appears |
| Maximum Erasure Value | Variable + HashSet | Unique elements in window |
| Max Consecutive Ones | Fixed/Variable scan | Count consecutive values |

## Memory Sentence

> Contiguous region + optimize while expanding/shrinking = Sliding Window.

---

# 5. Binary Search

## Recognition Trigger

- Sorted
- Search
- First/last occurrence
- Minimum possible
- Maximum possible
- Monotonic condition
- Can eliminate half?

## Standard Template

```java
int left = 0;
int right = nums.length - 1;

while (left <= right) {

    int mid = left + (right - left) / 2;

    if (condition) {
        // move one direction
    } else {
        // move other direction
    }
}
```

## Problems

| Problem | Pattern | Key Insight |
|---|---|---|
| Binary Search | Standard | Compare target with mid |
| First Bad Version | Boundary Search | Find first true |
| Guess Number Higher or Lower | Binary Search | API gives direction |
| Kth Missing Positive Number | Binary Search | Missing count formula |
| Implement strStr | Search / String Matching | Locate pattern |

## Boundary Search Template

```java
while (left < right) {

    int mid = left + (right - left) / 2;

    if (condition(mid)) {
        right = mid;
    } else {
        left = mid + 1;
    }
}
```

## Memory Sentence

> If the answer space is ordered and the condition changes monotonically, use Binary Search.

---

# 6. Stack

## Recognition Trigger

- Nested structure
- Expression evaluation
- Undo
- Reverse order
- Matching
- Most recent unresolved element

## Template

```java
Stack<Integer> stack = new Stack<>();

for (int num : nums) {

    while (!stack.isEmpty() && condition) {
        stack.pop();
    }

    stack.push(num);
}
```

## Problems

| Problem | Pattern |
|---|---|
| Evaluate Reverse Polish Notation | Stack evaluation |
| Implement Queue Using Stacks | Two stacks |
| Implement Stack Using Queues | Queue simulation |

## Memory Sentence

> Last unresolved item should be processed first = Stack.

---

# 7. Monotonic Stack

## Recognition Trigger

- Next greater
- Next smaller
- Previous greater
- Previous smaller
- Lexicographically smallest sequence

## Template

```java
Stack<Integer> stack = new Stack<>();

for (int i = 0; i < nums.length; i++) {

    while (!stack.isEmpty()
            && nums[stack.peek()] > nums[i]) {

        stack.pop();
    }

    stack.push(i);
}
```

## Problems

| Problem | Pattern |
|---|---|
| Find the Most Competitive Subsequence | Monotonic Stack |

## Memory Sentence

> Need nearest greater/smaller or maintain an optimal sequence = Monotonic Stack.

---

# 8. Linked List Patterns

---

## 8.1 Pointer Manipulation

### Golden Rule

Before modifying a pointer:

```text
Save next → Modify current → Move pointers
```

### Reverse Template

```java
ListNode prev = null;
ListNode current = head;

while (current != null) {

    ListNode next = current.next;

    current.next = prev;

    prev = current;
    current = next;
}

return prev;
```

### Problems

| Problem | Pattern |
|---|---|
| Add Two Numbers | Simulation + Carry |
| Delete Node in Linked List | Pointer overwrite |
| Design Linked List | Linked List operations |

---

## 8.2 Fast and Slow Pointers

### Recognition

- Cycle
- Middle
- Circular list

### Template

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {

    slow = slow.next;
    fast = fast.next.next;
}
```

### Problems

| Problem | Pattern |
|---|---|
| Linked List Cycle | Floyd Cycle Detection |
| Linked List Cycle II | Floyd Cycle Entry Detection |

## Memory Sentence

> Cycle or middle of linked list = Fast and Slow Pointers.

---

# 9. Tree Patterns

The most important question for tree problems:

> What information should the child return to its parent?

---

## 9.1 DFS Traversal

### Template

```java
void dfs(TreeNode node) {

    if (node == null) {
        return;
    }

    dfs(node.left);

    dfs(node.right);
}
```

### Problems

| Problem | Pattern |
|---|---|
| Binary Tree Preorder Traversal | DFS |
| Binary Tree Inorder Traversal | DFS |
| Binary Tree Postorder Traversal | DFS |

---

## 9.2 Tree Height / Bottom-Up DFS

### Template

```java
int dfs(TreeNode node) {

    if (node == null) {
        return 0;
    }

    int left = dfs(node.left);
    int right = dfs(node.right);

    return 1 + Math.max(left, right);
}
```

### Problems

| Problem | Pattern | Child Returns |
|---|---|---|
| Maximum Depth of Binary Tree | DFS Height | Height |
| Balanced Binary Tree | DFS + Height | Height / invalid signal |

### Memory Sentence

> For bottom-up tree problems, children calculate information and return it to the parent.

---

## 9.3 Tree BFS / Level Order

### Recognition

- Level
- Right side
- Average at each level
- Breadth

### Template

```java
Queue<TreeNode> queue = new LinkedList<>();

queue.offer(root);

while (!queue.isEmpty()) {

    int size = queue.size();

    for (int i = 0; i < size; i++) {

        TreeNode node = queue.poll();

        if (node.left != null) {
            queue.offer(node.left);
        }

        if (node.right != null) {
            queue.offer(node.right);
        }
    }
}
```

### Problems

| Problem | Pattern |
|---|---|
| Binary Tree Level Order Traversal | BFS |
| Binary Tree Right Side View | BFS / Last node per level |

### Memory Sentence

> Tree + levels = BFS.

---

## 9.4 Tree Path Problems

### Problems

| Problem | Pattern | Key Idea |
|---|---|---|
| Binary Tree Paths | DFS + Backtracking | Build path root-to-leaf |
| Binary Tree Maximum Path Sum | DFS + Global Maximum | Return best downward path |

### Maximum Path Sum Formula

```text
leftGain = max(0, dfs(left))
rightGain = max(0, dfs(right))

currentPath =
node.val + leftGain + rightGain

return =
node.val + max(leftGain, rightGain)
```

### Key Insight

> A node can use both children for the global answer, but can return only one branch to its parent.

---

## 9.5 Tree Transformation

### Problems

| Problem | Pattern |
|---|---|
| Invert Binary Tree | Recursive swap children |

Template:

```java
TreeNode left = root.left;

root.left = invertTree(root.right);
root.right = invertTree(left);
```

---

## 9.6 Tree Structural Comparison

### Template

```java
boolean same(TreeNode a, TreeNode b) {

    if (a == null && b == null) {
        return true;
    }

    if (a == null || b == null) {
        return false;
    }

    if (a.val != b.val) {
        return false;
    }

    return same(a.left, b.left)
        && same(a.right, b.right);
}
```

### Problems

| Problem | Pattern |
|---|---|
| Subtree of Another Tree | Tree traversal + structural comparison |
| Linked List in Binary Tree | DFS + sequence matching |

## Memory Sentence

> Same structure + same values = recursive comparison.

---

# 10. Binary Search Tree Patterns

## Core Property

```text
left subtree < root < right subtree
```

Always ask:

> Can I use ordering to avoid traversing the entire tree?

---

## Problems

| Problem | Pattern | Key Insight |
|---|---|---|
| Insert Into BST | BST Traversal | Compare and move left/right |
| Kth Smallest Element in BST | Inorder Traversal | BST inorder is sorted |
| LCA of BST | BST Ordering | First split point |

---

## LCA Template

```java
if (p.val < root.val && q.val < root.val) {
    return lowestCommonAncestor(root.left, p, q);
}

if (p.val > root.val && q.val > root.val) {
    return lowestCommonAncestor(root.right, p, q);
}

return root;
```

## Memory Sentence

> BST means ordering is information. Use it.

---

# 11. Graph Patterns

---

## 11.1 Graph Representation

### Adjacency List

```java
List<List<Integer>> graph = new ArrayList<>();

for (int i = 0; i < n; i++) {
    graph.add(new ArrayList<>());
}
```

Directed edge:

```java
graph.get(from).add(to);
```

Undirected edge:

```java
graph.get(a).add(b);
graph.get(b).add(a);
```

---

## 11.2 Directed Graph Cycle Detection

### Recognition

- Course prerequisites
- Dependencies
- Build order
- Package dependencies
- Task scheduling

### Three States

```text
0 = Unvisited
1 = Currently visiting
2 = Completely processed
```

### Template

```java
boolean hasCycle(int node) {

    if (state[node] == 1) {
        return true;
    }

    if (state[node] == 2) {
        return false;
    }

    state[node] = 1;

    for (int neighbor : graph.get(node)) {

        if (hasCycle(neighbor)) {
            return true;
        }
    }

    state[node] = 2;

    return false;
}
```

### Problems

| Problem | Pattern |
|---|---|
| Course Schedule | Directed graph + cycle detection |

### Memory Sentence

> Directed dependency graph → revisit node in current DFS path → cycle.

---

## 11.3 Undirected Graph Cycle Detection

### Critical Difference

In an undirected graph:

```text
A → B
B → A
```

Going back to the parent is normal.

Therefore track the parent.

### Template

```java
boolean dfs(int node, int parent) {

    visited[node] = true;

    for (int neighbor : graph.get(node)) {

        if (neighbor == parent) {
            continue;
        }

        if (visited[neighbor]) {
            return true;
        }

        if (dfs(neighbor, node)) {
            return true;
        }
    }

    return false;
}
```

### Problems

| Problem | Pattern |
|---|---|
| Graph Valid Tree | DFS + Parent + Connectivity |

### Valid Tree Conditions

```text
1. No cycle
2. All nodes connected
```

Alternative shortcut:

```text
Undirected graph is a tree iff:
edges == n - 1
AND
all nodes are connected
```

### Memory Sentence

> Undirected graph → visited neighbor is a cycle only if it is not my parent.

---

# 12. Matrix / Grid Patterns

## Key Insight

A grid is a graph.

```text
Cell = Node
Adjacent cells = Edges
```

## Direction Template

```java
int[][] directions = {
    {1, 0},
    {-1, 0},
    {0, 1},
    {0, -1}
};
```

## DFS Template

```java
void dfs(int row, int col) {

    if (invalid(row, col)) {
        return;
    }

    visited[row][col] = true;

    for (int[] dir : directions) {

        int newRow = row + dir[0];
        int newCol = col + dir[1];

        dfs(newRow, newCol);
    }
}
```

## Problems

| Problem | Pattern |
|---|---|
| Flood Fill | DFS/BFS Grid |
| Max Area of Island | DFS + Area Count |
| Game of Life | Matrix Simulation |
| Check Every Row and Column Contains All Numbers | Matrix + Set/Frequency |
| Matrix Diagonal Sum | Matrix Traversal |
| Matrix Block Sum | 2D Prefix Sum |
| Maximal Square | 2D DP |

## Memory Sentence

> Grid problem? Convert cells and neighbors into graph thinking.

---

# 13. Backtracking

## Recognition Trigger

- Generate all
- All permutations
- All combinations
- Every possible
- Arrangement
- Subset

## Golden Formula

```text
Choose
   ↓
Explore
   ↓
Undo
```

## Template

```java
void backtrack(List<Integer> current) {

    if (baseCondition) {
        result.add(new ArrayList<>(current));
        return;
    }

    for (...) {

        // Choose
        current.add(value);

        // Explore
        backtrack(current);

        // Undo
        current.remove(current.size() - 1);
    }
}
```

## Problems

| Problem | Pattern |
|---|---|
| Beautiful Arrangement | Backtracking |
| Generate Parentheses | Backtracking with constraints |
| Letter Case Permutation | Backtracking |
| Matchsticks to Square | Backtracking + pruning |

## Memory Sentence

> Need every possible valid answer = Backtracking.

---

# 14. Dynamic Programming

## Recognition Trigger

- Maximum
- Minimum
- Number of ways
- Optimal
- Repeated subproblems
- Choices at each position

Ask:

> Can the answer to this problem be constructed from answers to smaller problems?

---

## 14.1 Fibonacci Pattern

### Formula

```text
dp[i] = dp[i - 1] + dp[i - 2]
```

### Problems

| Problem |
|---|
| Fibonacci Number |
| Climbing Stairs |

### Memory Sentence

> Current answer depends on fixed previous states.

---

## 14.2 Take / Skip Pattern

### Formula

```text
dp[i] = max(
    skip current,
    take current + compatible previous state
)
```

### Problems

| Problem | Pattern |
|---|---|
| House Robber | Take/Skip |
| Delete and Earn | House Robber Transformation |
| House Robber II | Circular Take/Skip |

### House Robber

```text
dp[i] = max(
    dp[i - 1],
    nums[i] + dp[i - 2]
)
```

### Memory Sentence

> At each item: take it or skip it.

---

## 14.3 Coin Change / Knapsack Pattern

### Problems

| Problem | Goal |
|---|---|
| Coin Change | Minimum coins |
| Coin Change II | Number of combinations |
| Combination Sum IV | Number of ordered combinations |

### Important Difference

```text
Coin Change II
Order does NOT matter.

Combination Sum IV
Order DOES matter.
```

### Memory Sentence

> Capacity/target + choices = Knapsack-style DP.

---

## 14.4 String DP

### Recognition

Usually two strings.

### State

```text
dp[i][j]
```

Represents answer involving prefixes or suffixes of two strings.

### Problems

| Problem | Pattern |
|---|---|
| Longest Common Subsequence | 2D DP |
| Edit Distance | 2D DP |

### LCS Formula

```text
if chars match:
    dp[i][j] = 1 + dp[i-1][j-1]

else:
    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
```

### Memory Sentence

> Two strings changing independently = usually 2D DP.

---

## 14.5 Palindrome DP

### Problems

| Problem | Pattern |
|---|---|
| Longest Palindromic Subsequence | 2D DP |
| Longest Palindromic Substring | Expand Around Center / DP |
| Longest Palindrome | Frequency / Pairing |

### Recognition

```text
Compare left and right characters
Then solve inside
```

### Formula

```text
dp[i][j] =
chars[i] == chars[j]
&& dp[i+1][j-1]
```

---

## 14.6 Sequence DP

### Problems

| Problem | Pattern |
|---|---|
| Longest Increasing Subsequence | DP / Binary Search Optimization |
| Largest Divisible Subset | LIS-style DP |
| Arithmetic Slices | DP Counting |

### Memory Sentence

> Sequence where answer ending at i depends on earlier positions = Sequence DP.

---

## 14.7 Advanced State DP

### Problems

| Problem | Pattern |
|---|---|
| Best Time to Buy and Sell Stock with Cooldown | State Machine DP |
| Best Time to Buy and Sell Stock with Transaction Fee | State Machine DP |
| Knight Probability in Chessboard | DP + Probability |
| Integer Break | Mathematical DP |
| Maximal Square | 2D DP |

---

# 15. Stock Problem Pattern

Stock problems are worth grouping separately.

## Question to Ask

```text
How many transactions?

One?
Unlimited?
Cooldown?
Transaction fee?
```

---

## One Transaction

### Problem

Best Time to Buy and Sell Stock

### Pattern

Track:

```text
minimum price so far
maximum profit so far
```

```java
minPrice = Math.min(minPrice, price);
maxProfit = Math.max(maxProfit, price - minPrice);
```

---

## Unlimited Transactions

### Problem

Best Time to Buy and Sell Stock II

### Pattern

Capture all upward movement.

---

## Cooldown

### Problem

Best Time to Buy and Sell Stock with Cooldown

### Pattern

State machine:

```text
Holding
Selling
Resting
```

---

## Transaction Fee

### Problem

Best Time to Buy and Sell Stock with Transaction Fee

### Pattern

State machine + transaction cost.

---

# 16. Greedy

## Recognition Trigger

- Can choose locally optimal move
- Minimum jumps
- Reachability
- Interval optimization
- Resource allocation

Ask:

> If I make the best local decision, can I still reach the global optimum?

## Problems

| Problem | Pattern |
|---|---|
| Jump Game | Greedy Reachability |
| Jump Game II | Greedy BFS-like Range |
| Gas Station | Greedy Prefix |
| Boats to Save People | Greedy + Two Pointers |
| Can Place Flowers | Greedy Placement |
| Best Time to Buy and Sell Stock II | Greedy |

---

## Jump Game

Track:

```text
farthest reachable index
```

If:

```text
i > farthest
```

then unreachable.

---

## Jump Game II

Think in ranges:

```text
currentEnd
farthest
jumps
```

### Memory Sentence

> Greedy often means maintaining the best boundary reachable so far.

---

# 17. Prefix Sum

## Recognition Trigger

- Range sum
- Submatrix sum
- Repeated sum queries

## 1D Formula

```text
prefix[i] = prefix[i - 1] + nums[i]
```

Range:

```text
sum(left, right)
=
prefix[right] - prefix[left - 1]
```

---

## 2D Prefix Sum

### Problem

Matrix Block Sum

### Memory Sentence

> Repeated range calculations → precompute cumulative sums.

---

# 18. String Patterns

## Problems

| Problem | Pattern |
|---|---|
| Add Binary | Simulation + Carry |
| Check if Two String Arrays are Equivalent | Two Pointers |
| Longest Common Prefix | Horizontal Scanning |
| Length of Last Word | Reverse Traversal |
| First Unique Character | Frequency Count |
| Longest Substring Without Repeating Characters | Sliding Window |
| Custom Sort String | Frequency |
| Letter Case Permutation | Backtracking |

---

# 19. Simulation Patterns

Some problems don't require advanced algorithms.

Recognition:

- Follow instructions exactly.
- Maintain state.
- Simulate process.

## Problems

| Problem | Pattern |
|---|---|
| Add Binary | Simulation |
| Average Waiting Time | Queue Simulation |
| Count of Matches in Tournament | Mathematical Simulation |
| Create Target Array in Given Order | Array Simulation |
| Game of Life | Matrix Simulation |
| Check Array Formation Through Concatenation | Mapping + Simulation |

## Memory Sentence

> If constraints are small and operations are explicitly described, simulate first before overengineering.

---

# 20. SQL Patterns

Your repository also contains SQL problems.

## Basic Filtering

| Problem | Pattern |
|---|---|
| Big Countries | WHERE filter |
| Find Customer Referee | NULL / condition filtering |

## JOIN Problems

| Problem | Pattern |
|---|---|
| Customers Who Never Order | LEFT JOIN / NOT EXISTS |

## Conditional Logic

| Problem | Pattern |
|---|---|
| Calculate Special Bonus | CASE WHEN |

## Data Cleanup

| Problem | Pattern |
|---|---|
| Delete Duplicate Emails | Self Join / Window Function / MIN(id) |

---

# 21. Full Repository Problem Mapping

This section is the quick lookup index.

| # | Problem | Primary Pattern | Secondary Pattern |
|---|---|---|---|
| 1 | 3Sum | Sort + Two Pointers | Duplicate Handling |
| 2 | Add Binary | Simulation | Carry |
| 3 | Add Two Numbers | Linked List | Carry |
| 4 | Arithmetic Slices | DP | Sequence |
| 5 | Average Waiting Time | Simulation | Queue |
| 6 | Balanced Binary Tree | Tree DFS | Bottom-up |
| 7 | Beautiful Arrangement | Backtracking | Pruning |
| 8 | Best Sightseeing Pair | DP/Greedy | Running Maximum |
| 9 | Best Time to Buy and Sell Stock | Greedy | Running Minimum |
| 10 | Best Time to Buy and Sell Stock II | Greedy | Upward Slopes |
| 11 | Stock with Cooldown | DP | State Machine |
| 12 | Stock with Transaction Fee | DP | State Machine |
| 13 | Big Countries | SQL | Filtering |
| 14 | Binary Search | Binary Search | Sorted Array |
| 15 | Binary Tree Inorder Traversal | Tree DFS | Traversal |
| 16 | Binary Tree Level Order Traversal | BFS | Queue |
| 17 | Binary Tree Maximum Path Sum | Tree DFS | Global Maximum |
| 18 | Binary Tree Paths | DFS | Backtracking |
| 19 | Binary Tree Postorder Traversal | DFS | Traversal |
| 20 | Binary Tree Preorder Traversal | DFS | Traversal |
| 21 | Binary Tree Right Side View | BFS | Level Processing |
| 22 | Boats to Save People | Greedy | Two Pointers |
| 23 | Calculate Special Bonus | SQL | CASE |
| 24 | Can Place Flowers | Greedy | Array Scan |
| 25 | Check Array Formation | HashMap | Simulation |
| 26 | Check 1's K Places Apart | Array Scan | Last Seen Index |
| 27 | Check Rows and Columns | Matrix | Set/Frequency |
| 28 | Check String Arrays Equivalent | Two Pointers | String |
| 29 | Climbing Stairs | 1D DP | Fibonacci |
| 30 | Coin Change | DP | Unbounded Knapsack |
| 31 | Coin Change II | DP | Counting Combinations |
| 32 | Combination Sum IV | DP | Ordered Combinations |
| 33 | Container With Most Water | Two Pointers | Greedy |
| 34 | Contains Duplicate | HashSet | Frequency |
| 35 | Count Good Meals | HashMap | Complement |
| 36 | Count Matches in Tournament | Math | Simulation |
| 37 | Count Special Quadruplets | Enumeration | HashMap |
| 38 | Create Target Array | Simulation | ArrayList |
| 39 | Custom Sort String | Frequency | HashMap |
| 40 | Customers Who Never Order | SQL | LEFT JOIN |
| 41 | Decode Ways | DP | String |
| 42 | Delete and Earn | DP | House Robber |
| 43 | Delete Duplicate Emails | SQL | Deduplication |
| 44 | Delete Node in Linked List | Linked List | Pointer |
| 45 | Design Linked List | Data Structure | Pointer |
| 46 | Edit Distance | 2D DP | String |
| 47 | Evaluate RPN | Stack | Expression |
| 48 | Fibonacci Number | DP | Recursion |
| 49 | Find Customer Referee | SQL | Filtering |
| 50 | Even Number of Digits | Simulation | Digit Count |
| 51 | Most Competitive Subsequence | Monotonic Stack | Greedy |
| 52 | First Bad Version | Binary Search | Boundary |
| 53 | First Unique Character | Frequency | HashMap |
| 54 | Flood Fill | DFS/BFS | Grid |
| 55 | Game of Life | Matrix | Simulation |
| 56 | Gas Station | Greedy | Prefix Sum |
| 57 | Generate Parentheses | Backtracking | Constraints |
| 58 | Guess Number | Binary Search | API |
| 59 | House Robber | DP | Take/Skip |
| 60 | House Robber II | DP | Circular Array |
| 61 | Queue Using Stacks | Stack | Data Structure |
| 62 | Stack Using Queues | Queue | Data Structure |
| 63 | Implement strStr | String Search | Two Pointers |
| 64 | Insert Into BST | BST | Ordering |
| 65 | Integer Break | DP | Mathematical |
| 66 | Intersection Arrays II | HashMap | Frequency |
| 67 | Invert Binary Tree | DFS | Swap |
| 68 | Is Subsequence | Two Pointers | String |
| 69 | Jump Game | Greedy | Reachability |
| 70 | Jump Game II | Greedy | Range Expansion |
| 71 | K-th Symbol Grammar | Recursion | Divide |
| 72 | Knight Probability | DP | Matrix State |
| 73 | Kth Missing Positive | Binary Search | Missing Count |
| 74 | Kth Smallest BST | BST | Inorder |
| 75 | Largest Divisible Subset | DP | LIS-style |
| 76 | Length of Last Word | String | Reverse Scan |
| 77 | Letter Case Permutation | Backtracking | DFS |
| 78 | Linked List Cycle | Fast/Slow | Floyd |
| 79 | Linked List Cycle II | Fast/Slow | Floyd |
| 80 | Linked List in Binary Tree | Tree DFS | Pattern Matching |
| 81 | Longest Common Prefix | String | Horizontal Scan |
| 82 | Longest Common Subsequence | 2D DP | String |
| 83 | Longest Increasing Subsequence | DP | Binary Search Optimization |
| 84 | Longest Palindrome | HashMap | Frequency |
| 85 | Longest Palindromic Subsequence | DP | Interval |
| 86 | Longest Palindromic Substring | Expand Center | DP Alternative |
| 87 | Longest Substring Without Repeating | Sliding Window | HashSet |
| 88 | Longest Word Through Deleting | Two Pointers | Subsequence |
| 89 | LCA of BST | BST | Ordering |
| 90 | LCA of Binary Tree | Tree DFS | Recursive Search |
| 91 | Majority Element | Boyer-Moore | HashMap Alternative |
| 92 | Matchsticks to Square | Backtracking | Pruning |
| 93 | Matrix Block Sum | 2D Prefix Sum | Matrix |
| 94 | Matrix Diagonal Sum | Matrix Traversal | Simulation |
| 95 | Max Area of Island | DFS/BFS | Grid |
| 96 | Max Consecutive Ones | Array Scan | Sliding Window |
| 97 | Max Number K-Sum Pairs | Two Pointers | HashMap |
| 98 | Maximal Square | 2D DP | Matrix |
| 99 | Maximum Depth Binary Tree | DFS | Height |
| 100 | Maximum Erasure Value | Sliding Window | HashSet |
| 101 | Course Schedule | Directed Graph | DFS Cycle Detection |
| 102 | Graph Valid Tree | Undirected Graph | DFS + Parent |

---

# 22. Pattern Clusters You Should Revise Together

Do not randomly solve problems.

Study related patterns together.

---

## Cluster 1: Hashing

```text
Contains Duplicate
First Unique Character
Intersection of Arrays
Count Good Meals
Majority Element
```

Learn:

```text
Set
Frequency Map
Complement Lookup
```

---

## Cluster 2: Two Pointers

```text
3Sum
Container With Most Water
Boats to Save People
Is Subsequence
Longest Word Through Deleting
```

Learn:

```text
Opposite Direction
Same Direction
Sort First
```

---

## Cluster 3: Sliding Window

```text
Longest Substring Without Repeating
Maximum Erasure Value
Max Consecutive Ones
```

Learn:

```text
Expand Right
Check Validity
Shrink Left
Update Answer
```

---

## Cluster 4: Tree DFS

```text
Maximum Depth
Balanced Tree
Maximum Path Sum
Binary Tree Paths
LCA Binary Tree
Subtree
```

Learn:

```text
What does child return?
Top-down vs Bottom-up?
Global answer vs returned answer?
```

---

## Cluster 5: Graph

```text
Course Schedule
Graph Valid Tree
Flood Fill
Max Area of Island
```

Learn:

```text
Directed vs Undirected
DFS vs BFS
Cycle detection
Visited
Parent
3 States
```

---

## Cluster 6: Backtracking

```text
Generate Parentheses
Letter Case Permutation
Beautiful Arrangement
Matchsticks to Square
```

Learn:

```text
Choose
Explore
Undo
Prune
```

---

## Cluster 7: Core DP

```text
Fibonacci
Climbing Stairs
House Robber
Delete and Earn
Decode Ways
Coin Change
```

Learn:

```text
State
Transition
Base Case
Iteration Order
```

---

## Cluster 8: Advanced DP

```text
LCS
Edit Distance
LIS
Longest Palindromic Subsequence
Maximal Square
Stock Cooldown
Knight Probability
```

Learn:

```text
1D vs 2D state
Previous state dependency
Take/Skip
Matching
State Machine
```

---

# 23. The 10 Most Important Templates to Memorize

---

## Template 1: HashMap

```java
Map<Integer, Integer> map = new HashMap<>();

for (int num : nums) {
    map.put(num, map.getOrDefault(num, 0) + 1);
}
```

---

## Template 2: Two Pointers

```java
int left = 0;
int right = nums.length - 1;

while (left < right) {

    if (condition) {
        left++;
    } else {
        right--;
    }
}
```

---

## Template 3: Sliding Window

```java
int left = 0;

for (int right = 0; right < nums.length; right++) {

    add(nums[right]);

    while (invalid()) {
        remove(nums[left]);
        left++;
    }

    updateAnswer();
}
```

---

## Template 4: Binary Search

```java
while (left <= right) {

    int mid = left + (right - left) / 2;

    if (condition) {
        right = mid - 1;
    } else {
        left = mid + 1;
    }
}
```

---

## Template 5: Tree DFS

```java
int dfs(TreeNode node) {

    if (node == null) {
        return 0;
    }

    int left = dfs(node.left);
    int right = dfs(node.right);

    return combine(left, right);
}
```

---

## Template 6: Graph DFS

```java
void dfs(int node) {

    visited[node] = true;

    for (int neighbor : graph.get(node)) {

        if (!visited[neighbor]) {
            dfs(neighbor);
        }
    }
}
```

---

## Template 7: Directed Cycle

```java
if (state[node] == 1) return true;
if (state[node] == 2) return false;

state[node] = 1;

for (int neighbor : graph.get(node)) {
    if (hasCycle(neighbor)) return true;
}

state[node] = 2;

return false;
```

---

## Template 8: Undirected Cycle

```java
boolean dfs(int node, int parent) {

    visited[node] = true;

    for (int neighbor : graph.get(node)) {

        if (neighbor == parent) continue;

        if (visited[neighbor]) return true;

        if (dfs(neighbor, node)) return true;
    }

    return false;
}
```

---

## Template 9: Backtracking

```java
void backtrack() {

    if (baseCase) {
        saveAnswer();
        return;
    }

    for (choice : choices) {

        choose(choice);

        backtrack();

        undo(choice);
    }
}
```

---

## Template 10: Dynamic Programming

```java
// 1. Define dp state
// 2. Define transition
// 3. Define base case
// 4. Decide iteration order

dp[i] = transition(dp[previous states]);
```

---

# 24. Interview Problem-Solving Framework

Before coding, say:

## Step 1: Clarify

```text
What are the constraints?
Can input be empty?
Are duplicates possible?
Is input sorted?
```

## Step 2: Identify Pattern

```text
Array?
Tree?
Graph?
DP?
Backtracking?
```

## Step 3: State the Brute Force

```text
The straightforward approach would be...
```

## Step 4: Optimize

```text
We can avoid repeated work by...
```

## Step 5: Define Invariant

Examples:

```text
Sliding Window:
Window always satisfies constraint.

Binary Search:
Answer always exists within search range.

DFS:
Visited nodes are already processed.

DP:
dp[i] represents...
```

## Step 6: Code

## Step 7: Dry Run

Use:

```text
Normal case
Edge case
Minimum input
Duplicate/cycle/null case
```

---

# 25. Ultimate Memory Sheet

```text
DUPLICATES / FREQUENCY
→ HashMap / HashSet

SORTED + PAIR
→ Two Pointers

CONTIGUOUS SUBARRAY / SUBSTRING
→ Sliding Window

SORTED / MONOTONIC ANSWER SPACE
→ Binary Search

NEXT GREATER / SMALLER
→ Monotonic Stack

MATCHING / NESTED
→ Stack

LINKED LIST CYCLE
→ Fast & Slow Pointer

TREE LEVEL
→ BFS

TREE PATH / HEIGHT
→ DFS

BST
→ Use ordering

GRID
→ DFS/BFS

DEPENDENCIES
→ Directed Graph

DIRECTED CYCLE
→ DFS + 3 States

UNDIRECTED CYCLE
→ DFS + Parent

ALL POSSIBILITIES
→ Backtracking

MAX / MIN / COUNT WAYS
→ DP

TAKE OR SKIP
→ DP

RANGE SUM
→ Prefix Sum

LOCAL BEST DECISION
→ Greedy
```

---

# 26. Personal Revision Strategy

## Daily 90-Minute Revision

### 20 minutes

Review one pattern.

```text
Read trigger
Read template
Explain aloud
```

### 40 minutes

Solve 2 problems from the same pattern.

```text
Easy → Medium
```

### 20 minutes

Solve without looking at previous solution.

### 10 minutes

Write:

```text
What was the trigger?
What did I initially miss?
What invariant made the solution work?
```

---

# 27. Final Principle

The goal is not:

> "I have solved 300 LeetCode problems."

The goal is:

> "When I see a problem, I can classify it into one of 15–20 patterns within a few minutes."

The progression should be:

```text
Problem
   ↓
Recognize Signal
   ↓
Identify Pattern
   ↓
Recall Template
   ↓
Adapt Template
   ↓
Solve
```

Once pattern recognition becomes automatic, DSA interviews become significantly less about memorization and more about applying familiar building blocks.

---

# Personal Pattern Checklist

Before every problem, ask:

```text
[ ] Is it contiguous?
[ ] Is it sorted?
[ ] Do I need frequency/count?
[ ] Is it a tree?
[ ] Is it a graph?
[ ] Directed or undirected?
[ ] Do I need all possibilities?
[ ] Is there repeated computation?
[ ] Is there a local greedy choice?
[ ] Can I define dp[i]?
[ ] Do I need a stack for unresolved elements?
[ ] Can two pointers eliminate search space?
```

If you can answer these questions consistently, you will recognize most common interview patterns quickly.