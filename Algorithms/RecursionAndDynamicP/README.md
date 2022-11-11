# Recursion

## Backtracking
This is a technique to solve problems recursively, that look for every possible combination in order to solve a computational problem. It adds one option at time, and removes those solutions that fail to satisfy the constraints of the problem at any point of time.
Some types of problems can be tacked with backtracking:
- Decision problems: Searching for **a** feasible solution.
- Optimization problems: Searching for **the best** solution. 
- Enumeration problems: Searching for **all possibles** solutions.

However, normaly is not the best solution, as the algorithm runs exponentially in both, time and space. 

[Backtracking exercises](https://github.com/Luisa13/Algorithms/tree/main/Algorithms/RecursionAndDynamicP/exercises/recursion)

## Dynamic Programming
This is a technique to optimize a recursive approach by breaking it down into simpler subproblems. 
Any problem has optimal substructure property if its overall optimal solution can be constructed from the optimal solutions of its subproblems.
[Here](https://leetcode.com/discuss/general-discussion/662866/Dynamic-Programming-for-Practice-Problems-Patterns-and-Sample-Solutions) is possible to find a little discussion about the main problems where this technique applies alongside the [patterns](https://leetcode.com/discuss/general-discussion/458695/dynamic-programming-patterns). Also, it's worth reading [this guide from StackOverflow](https://stackoverflow.blog/2022/01/31/the-complete-beginners-guide-to-dynamic-programming/). Dynamic Programming offers two main approaches to address the problem:

Given a general problem statement
> Get the minimum/ maximum cost to reach a target

The approach is choose the min/max cost **among all the possible paths before the current state**, and then add the value for the current state.
```
route[i] = Min(route[i-1], route[i-2], ... route[i-n]) + cost[i]
```

</br>

- **MEMOIZATION** (Top-down)
```
  for (int i = 0; i< ways.size(); ++i) {
      result = Min(result, topDown(target - ways[i]) + cost);
  }
  return  result[i];
```


</br>

- **TABULATION** (Bottom-up)
```
for (int i = 1; i <= target; ++i) {
   for (int j = 0; j < ways.size(); ++j) {
       if (ways[j] <= i) {
           dp[i] = min(dp[i], dp[i - ways[j]] + cost) ;
       }
   }
}
 
return dp[target]
```


[Dynamic Programming exercises](https://github.com/Luisa13/Algorithms/tree/main/Algorithms/RecursionAndDynamicP/exercises/dynamicProgramming)


OTHER RESOURCES

- [Backtracking pattern](https://medium.com/leetcode-patterns/leetcode-pattern-3-backtracking-5d9e5a03dc26)
- [Backtracking patterns in most popular problems. A leetcode discussion](https://leetcode.com/problems/permutations/discuss/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning)
- [Backtracking explanation](https://www.programiz.com/dsa/backtracking-algorithm)
- [Gas station. A discussion](https://leetcode.com/problems/gas-station/discuss/1705957/Java-A-very-detailed-explanation-or-Intuition-behind-logic-or-Brute-Force-to-Optimised)
