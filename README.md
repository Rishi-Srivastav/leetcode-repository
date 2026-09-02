# LeetCode Solutions

A curated collection of my **LeetCode solutions** focused on building strong problem-solving skills across **Data Structures, Algorithms, and Systematic Problem Solving**.

The repository contains solutions developed while preparing for **software engineering interviews**, with an emphasis on understanding patterns, improving time/space complexity, and writing clean, maintainable code.

## 🎯 Goals

This repository is primarily used to:

* Strengthen Data Structures & Algorithms fundamentals
* Practice common coding interview patterns
* Improve problem-solving and analytical thinking
* Develop optimized solutions with clear time and space complexity
* Prepare for Software Engineer, Senior Engineer, Staff Engineer, and Principal Engineer interviews
* Maintain a searchable reference of previously solved problems

## 📚 Topics Covered

The problems are organized around commonly used algorithmic patterns and data structures, including:

* Arrays & Strings
* Hashing
* Two Pointers
* Sliding Window
* Stack & Queue
* Linked Lists
* Binary Search
* Sorting
* Recursion
* Backtracking
* Trees & Binary Trees
* Binary Search Trees
* Heaps / Priority Queues
* Graphs
* BFS / DFS
* Greedy Algorithms
* Dynamic Programming
* Intervals
* Bit Manipulation
* Tries
* Union Find
* Design Problems

## 🧩 Problem-Solving Approach

For each problem, the focus is not only on getting an accepted solution, but on understanding:

1. **Problem interpretation** — identify what the problem is really asking.
2. **Brute-force approach** — establish a baseline solution where applicable.
3. **Optimization** — identify opportunities to reduce time or space complexity.
4. **Algorithm / Pattern** — recognize the reusable problem-solving technique.
5. **Complexity analysis** — evaluate time and space requirements.
6. **Edge cases** — consider boundary conditions and tricky inputs.
7. **Implementation** — write clean and readable code.

The goal is to recognize patterns rather than memorize individual solutions.

## 📂 Repository Structure

```text
leetcode-repository/
│
├── problems/
│   ├── ...
│   └── LeetCode problem solutions
│
├── .github/
│   └── workflows/
│       └── GitHub Actions workflows
│
└── README.md
```

## 🚀 Interview Preparation

This repository is particularly useful for revising the patterns that frequently appear in coding interviews.

### Recommended Revision Order

```text
Arrays & Hashing
        ↓
Two Pointers
        ↓
Sliding Window
        ↓
Stack & Queue
        ↓
Binary Search
        ↓
Linked Lists
        ↓
Trees
        ↓
Heap / Priority Queue
        ↓
Graphs
        ↓
Backtracking
        ↓
Greedy
        ↓
Dynamic Programming
        ↓
Advanced Data Structures
```

## ⏱️ Complexity Matters

Solutions are evaluated with complexity in mind.

Typical analysis includes:

```text
Time Complexity:  O(n)
Space Complexity: O(1)
```

Where appropriate, the repository also compares multiple approaches to understand the trade-offs between:

* Time vs. space
* Simplicity vs. optimization
* Iterative vs. recursive approaches
* Sorting vs. hashing
* DFS vs. BFS
* Greedy vs. Dynamic Programming

## 💡 Key Patterns to Master

Some of the most reusable patterns include:

### Sliding Window

Useful for contiguous subarray / substring problems.

### Two Pointers

Useful for sorted arrays, linked lists, and pair-based problems.

### Fast & Slow Pointers

Useful for linked-list cycle detection, finding the middle, and related problems.

### Binary Search

Useful whenever the search space can be reduced logarithmically.

### DFS / BFS

Useful for trees, graphs, grids, and connected-component problems.

### Backtracking

Useful for problems involving permutations, combinations, subsets, and constraint-based search.

### Dynamic Programming

Useful when a problem contains:

* Overlapping subproblems
* Optimal substructure
* Multiple possible decisions
* A reusable state


# DSA Pattern Notes — leetcode-repository (Rishi-Srivastav)

Organized by **pattern**, not by problem, because that's how you actually recognize what to do in an interview: you see a shape in the problem statement, and it should trigger a template in your head. Each section has: **when you'll recognize it**, the **core template**, and **which problems in this repo use it**.

---

# Summary Of Patterns : 
## 1. Two Pointers (opposite ends / same direction)
**Recognize:** sorted array, "pair/triplet that sums to X," partitioning in-place, comparing from both ends.
**Template:**
```
left = 0, right = n-1
while left < right:
    if condition_met: do_work(); left++; right--
    elif need_bigger: left++
    else: right--
```
**Problems:** `3sum`, `two_sum_ii_-_input_array_is_sorted`, `container_with_most_water`, `trapping_rain_water`, `valid_mountain_array`, `squares_of_a_sorted_array`, `remove_duplicates_from_sorted_array(_ii)`, `remove_element`, `move_zeroes`, `sort_colors` (Dutch flag = 3-pointer), `merge_sorted_array` (from the back), `boats_to_save_people`, `is_subsequence`

## 2. Sliding Window (variable/fixed size)
**Recognize:** "longest/shortest substring/subarray with property X," contiguous window.
**Template:**
```
left = 0
for right in range(n):
    add(arr[right]) to window
    while window_invalid:
        remove(arr[left]); left++
    update_answer(right - left + 1)
```
**Problems:** `longest_substring_without_repeating_characters`, `permutation_in_string`, `max_consecutive_ones`, `maximum_erasure_value`, `maximum_length_of_subarray_with_positive_product`

## 3. Binary Search
**Recognize:** sorted/monotonic search space, "find target / find boundary," O(log n) is hinted.
**Template:**
```
lo, hi = 0, n-1
while lo <= hi:
    mid = (lo+hi)//2
    if arr[mid] == target: return mid
    elif arr[mid] < target: lo = mid+1
    else: hi = mid-1
```
Variant — **binary search on the answer** (search a value, not an index): used when you can binary-search a monotonic yes/no predicate.
**Problems:** `binary_search`, `search_insert_position`, `search_a_2d_matrix`, `first_bad_version`, `guess_number_higher_or_lower`, `kth_missing_positive_number`

## 4. Fast & Slow Pointers (linked list)
**Recognize:** cycle detection, find middle, palindrome check on a list.
**Template:** `slow` moves 1 step, `fast` moves 2 steps; if they meet → cycle; when `fast` hits end → `slow` is the middle.
**Problems:** `linked_list_cycle`, `linked_list_cycle_ii` (Floyd's — after meeting, reset one pointer to head, move both by 1 to find cycle start), `middle_of_the_linked_list`, `palindrome_linked_list` (find middle → reverse second half → compare)

## 5. Linked List Manipulation (pointer surgery)
**Recognize:** reverse / reorder / remove nodes — always use a **dummy head** to avoid edge cases at index 0.
**Template (reverse):**
```
prev = None
while head:
    nxt = head.next
    head.next = prev
    prev = head
    head = nxt
```
**Problems:** `reverse_linked_list`, `swap_nodes_in_pairs`, `remove_nth_node_from_end_of_list` (two pointers, gap of n), `remove_duplicates_from_sorted_list(_ii)`, `remove_linked_list_elements`, `rotate_list`, `merge_two_sorted_lists`, `merge_k_sorted_lists` (min-heap of list heads, or divide & conquer merge), `add_two_numbers` (simulate addition + carry), `delete_node_in_a_linked_list` (copy next node's value, unusual trick), `design_linked_list`

## 6. Tree DFS — Recursion First
**Recognize:** anything with "binary tree," most solvable in 3 lines with `left = dfs(node.left); right = dfs(node.right); combine`.
**Template:**
```
def dfs(node):
    if not node: return base_case
    left = dfs(node.left)
    right = dfs(node.right)
    return combine(node, left, right)
```
**Problems:** `binary_tree_inorder/preorder/postorder_traversal`, `maximum_depth_of_binary_tree`, `invert_binary_tree`, `symmetric_tree`, `balanced_binary_tree`, `path_sum`, `sum_root_to_leaf_numbers`, `binary_tree_paths`, `binary_tree_maximum_path_sum` (global max + "path through node" vs "path to return upward" distinction — classic trap), `merge_two_binary_trees`, `smallest_string_starting_from_leaf`, `linked_list_in_binary_tree`

## 7. Tree BFS — Level Order
**Recognize:** "level by level," "right side view," "connect next pointers."
**Template:**
```
queue = [root]
while queue:
    level_size = len(queue)
    for _ in range(level_size):
        node = queue.pop(0)
        process(node)
        if node.left: queue.append(node.left)
        if node.right: queue.append(node.right)
```
**Problems:** `binary_tree_level_order_traversal`, `binary_tree_right_side_view` (take last node of each level), `populating_next_right_pointers_in_each_node`

## 8. Binary Search Tree — use ordering, don't brute force
**Recognize:** "BST" in the title — always exploit left < node < right.
**Problems:** `validate_binary_search_tree` (pass down valid range, or inorder must be sorted), `insert_into_a_binary_search_tree`, `search_in_a_binary_search_tree`, `kth_smallest_element_in_a_bst` (inorder traversal = sorted order), `minimum_distance_between_bst_nodes` (inorder, compare adjacent), `two_sum_iv_-_input_is_a_bst` (inorder + two pointers, or hashset), `lowest_common_ancestor_of_a_binary_search_tree` (compare values to decide direction — no full traversal needed), `lowest_common_ancestor_of_a_binary_tree` (general tree: post-order, return node if found on both sides), `unique_binary_search_trees` (DP/Catalan numbers)

## 9. Backtracking (build → check → undo)
**Recognize:** "all permutations/combinations," "generate all valid X," constraint satisfaction.
**Template:**
```
def backtrack(path, choices):
    if is_complete(path): record(path); return
    for choice in choices:
        if not valid(choice): continue
        path.append(choice)
        backtrack(path, remaining_choices)
        path.pop()   # undo
```
**Problems:** `permutations`, `generate_parentheses` (track open/close counts as constraints), `letter_case_permutation`, `matchsticks_to_square`, `partition_to_k_equal_sum_subsets`, `beautiful_arrangement`, `valid_sudoku` (validation, not generation — still grid-constraint pattern), `k-th_symbol_in_grammar` (recursive halves)

## 10. Dynamic Programming — 1D (state = index)
**Recognize:** "number of ways," "min/max cost," recurrence only depends on a few previous states.
**Template:** `dp[i] = f(dp[i-1], dp[i-2], ...)`. Always ask: *what does dp[i] mean, in one sentence?*
**Problems:** `climbing_stairs`, `fibonacci_number`, `n-th_tribonacci_number`, `min_cost_climbing_stairs`, `house_robber` (dp[i] = max(dp[i-1], dp[i-2]+nums[i])), `house_robber_ii` (circular → run linear version twice, excluding first or last), `decode_ways`, `delete_and_earn` (reduces to house_robber after bucketing), `integer_break`, `perfect_squares` (unbounded knapsack-ish), `arithmetic_slices`, `best_sightseeing_pair`, `ugly_number_ii` (three-pointer merge, DP-flavored)

## 11. DP — Stock Trading (state machine)
**Recognize:** "buy/sell stock," add a state dimension for "holding/not holding a share."
**Template:** `hold[i] = max(hold[i-1], sold[i-1]-price[i])`, `sold[i] = max(sold[i-1], hold[i-1]+price[i])`.
**Problems:** `best_time_to_buy_and_sell_stock` (single pass, track min price), `best_time_to_buy_and_sell_stock_ii` (greedy — sum all positive deltas), `best_time_to_buy_and_sell_stock_with_cooldown` (extra "cooldown" state), `best_time_to_buy_and_sell_stock_with_transaction_fee` (subtract fee on sell)

## 12. DP — 2D Grid
**Recognize:** grid traversal, "number of paths," "min cost path" — `dp[i][j]` depends on `dp[i-1][j]` / `dp[i][j-1]`.
**Problems:** `unique_paths`, `unique_paths_ii` (obstacles), `minimum_path_sum`, `minimum_falling_path_sum`, `triangle`, `maximal_square` (dp[i][j] = min of 3 neighbors + 1), `out_of_boundary_paths`, `knight_probability_in_chessboard`, `matrix_block_sum` (prefix-sum, not classic DP but same "build from smaller subgrids" instinct)

## 13. DP — Two Strings (LCS-family)
**Recognize:** two strings/arrays being compared position by position → 2D table `dp[i][j]`.
**Template:** `dp[i][j] = dp[i-1][j-1]+1 if s1[i]==s2[j] else combine(dp[i-1][j], dp[i][j-1])`.
**Problems:** `longest_common_subsequence`, `edit_distance` (insert/delete/replace = 3-way min), `longest_palindromic_subsequence` (LCS of string with its reverse), `longest_palindromic_substring` (expand-around-center is simpler than DP here), `repeated_substring_pattern` (string trick: check if s is in (s+s)[1:-1])

## 14. DP — Subset / Knapsack
**Recognize:** "can you partition into subsets with property X," "number of ways to make sum X" using each item once or unlimited times.
**Problems:** `partition_equal_subset_sum` (0/1 knapsack: can we hit sum/2), `coin_change` (unbounded knapsack, min coins), `coin_change_2` (unbounded knapsack, count ways — order of loops matters!), `combination_sum_iv` (permutations, not combinations — loop order flipped vs coin_change_2), `word_break` (dp[i] = can we segment s[:i]), `largest_divisible_subset` (sort + LIS-style DP), `longest_increasing_subsequence` (dp[i] = 1 + max(dp[j]) for j<i with nums[j]<nums[i]; know the O(n log n) patience-sorting version too)

## 15. Greedy
**Recognize:** local optimal choice provably leads to global optimum — usually needs a sort first.
**Problems:** `jump_game` (track farthest reachable), `jump_game_ii` (BFS-like level jumps), `gas_station` (if total gas ≥ total cost, an answer exists; reset start on deficit), `can_place_flowers`, `patching_array`, `remove_digit_from_number_to_maximize_result`, `maximum_units_on_a_truck` (sort by units/box, take greedily), `custom_sort_string`

## 16. Monotonic Stack / Stack Simulation
**Recognize:** "next greater/smaller element," matching brackets, needing to look back and discard dominated elements.
**Template:** push while maintaining stack order; pop while `stack.top` violates the order, before pushing new element.
**Problems:** `valid_parentheses`, `evaluate_reverse_polish_notation`, `find_the_most_competitive_subsequence` (monotonic stack, greedily drop bigger digits if you can still fill length), `implement_stack_using_queues`, `implement_queue_using_stacks`, `remove_palindromic_subsequences` (trick: answer is always 0, 1, or 2 — think before coding), `next_greater_element_iii` (next permutation algorithm)

## 17. Graph / Matrix Traversal (BFS/DFS on grid)
**Recognize:** grid of cells, "connected region," "shortest transformation," flood-fill style spread.
**Problems:** `flood_fill`, `max_area_of_island` (DFS/BFS counting connected 1s), `game_of_life` (in-place state encoding trick), `word_ladder` (BFS over word graph, one-letter transformations)

## 18. Hashing (O(1) lookup replaces nested loops)
**Recognize:** "have I seen this before," "complement/pair exists," counting frequency.
**Problems:** `two_sum`, `contains_duplicate`, `valid_anagram`, `majority_element` (Boyer-Moore voting is the O(1)-space alternative), `single_number` (XOR trick — no hashmap needed), `ransom_note`, `first_unique_character_in_a_string`, `intersection_of_two_arrays_ii`, `check_if_two_string_arrays_are_equivalent`, `longest_word_in_dictionary_through_deleting`, `unique_morse_code_words`, `count_special_quadruplets`, `pairs_of_songs_with_total_durations_divisible_by_60` (bucket by remainder mod 60), `check_array_formation_through_concatenation`, `count_good_meals` (target-sum pairs via powers of 2), `max_number_of_k-sum_pairs`

## 19. Array / Matrix Utility Patterns
**Problems:** `product_of_array_except_self` (prefix × suffix products, no division), `maximum_subarray` (Kadane's algorithm — `curr = max(nums[i], curr+nums[i])`), `maximum_sum_circular_subarray` (total - min_subarray, handle all-negative edge case), `maximum_product_subarray` (track running max AND min, because negatives flip them), `rotate_array` (reverse-whole, reverse-parts trick), `reshape_the_matrix`, `check_if_every_row_and_column_contains_all_numbers`, `matrix_diagonal_sum`, `find_numbers_with_even_number_of_digits`, `create_target_array_in_the_given_order`, `the_k_weakest_rows_in_a_matrix` (sort/heap by count then index), `monotonic_array`

## 20. String Manipulation
**Problems:** `longest_common_prefix` (vertical scanning or divide & conquer), `roman_to_integer` (map + look-ahead for subtractive cases like IV), `length_of_last_word`, `reverse_string`, `reverse_words_in_a_string_iii`, `custom_sort_string`, `add_binary`, `plus_one`, `palindrome_number` (reverse half the number, avoid overflow), `implement_strstr()` (or use KMP for O(n) if pressed), `reformat_phone_number`, `sequential_digits` (generate from a "123456789" sliding window)

## 21. Math / Bit Manipulation
**Problems:** `pow(x,_n)` (fast exponentiation — halve the exponent each step), `single_number` (XOR cancels pairs), `the_kth_factor_of_n`, `count_of_matches_in_tournament` (n-1 matches always — pure math, no simulation needed), `reach_a_number`, `number_of_steps_to_reduce_a_number_to_zero`

## 22. Concurrency
**Problems:** `print_in_order` (semaphores / locks to enforce execution order across threads — different skill set from the rest of this list)

## 23. SQL
**Problems:** `big_countries`, `customers_who_never_order` (LEFT JOIN ... WHERE right side IS NULL), `delete_duplicate_emails`, `find_customer_referee` (handle NULL with `IS NULL OR !=`), `recyclable_and_low_fat_products`, `swap_salary` (CASE WHEN, or single UPDATE with `sex = IF(...)`), `calculate_special_bonus`

---

## How to actually use this for memorization
1. **Don't memorize solutions — memorize the recognition cue.** Read the bolded "Recognize" line for each pattern until you can look at any problem title above and guess its bucket before opening the file.
2. **Drill by bucket, not alphabetically.** Do all of section 10 (1D DP) in one sitting so the recurrence-writing muscle gets reps back-to-back.
3. **For each solved problem, write the one-line `dp[i]` / invariant definition** before coding. If you can't state it in one sentence, you don't understand the solution yet — you just copied it.
4. **Watch the "gotcha" notes** sprinkled above (e.g. `coin_change_2` vs `combination_sum_iv` loop order, `house_robber_ii`'s circular trick, `binary_tree_maximum_path_sum`'s two-different-values trap) — these are the details that separate "seen this pattern" from "actually get it right under pressure."


## 📈 Progress

This repository is continuously updated as new problems are solved and previously solved problems are revisited for optimization and better understanding.

The objective is **consistent improvement rather than simply maximizing the number of solved problems**.

## 🛠️ Languages

The primary focus of this repository is **Java**, with solutions written to emphasize:

* Clean object-oriented design
* Readability
* Appropriate use of Java collections
* Efficient algorithms
* Correct handling of edge cases

## 🤝 Contributing

This is primarily a personal interview-preparation repository.

Suggestions, alternative approaches, and improvements are welcome through GitHub Issues or Pull Requests.

## ⭐ Useful Resources

* [LeetCode](https://leetcode.com/)
* [LeetCode Top Interview Questions](https://leetcode.com/studyplan/top-interview-150/)
* [LeetCode 75](https://leetcode.com/studyplan/leetcode-75/)

## 📌 Disclaimer

These solutions are intended for **learning and interview preparation**.

The goal is to understand the underlying algorithm and problem-solving pattern rather than directly copy solutions.

---

**Keep solving. Keep learning. Keep improving. 🚀**

[1]: https://github.com/Rishi-Srivastav/leetcode-repository "GitHub - Rishi-Srivastav/leetcode-repository: Leetcode submissions · GitHub"
