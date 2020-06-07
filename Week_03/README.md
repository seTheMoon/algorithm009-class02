### 第七课
#### 递归模板
```
public void recur(int level, int param) { 
  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 
  process(level, param); 
  // drill down 
  recur( level: level + 1, newParam); 
  // restore current status 
}
```
+ 递归模板总结起来就是四个部分
   + 递归终结的条件
   + 当前层的逻辑处理
   + 下探进入下一层
   + 当前层的状态、变量处理
+ 递归的思维要点
   + 不要人肉进行递归（人肉递归是最大的误区）
   + 找到重复子问题
   + 数学归纳法
+ 爬楼梯
   + 之前讲过的一道题，可以使用递归实现，但用递归实现的时候一定要注意存储中间结果，避免重复计算
+ 括号生成
   + 解法：https://leetcode-cn.com/problems/generate-parentheses/submissions/
   + 思路
      + 可以使用递归实现，每一次都可以添加左括号或者右括号，但要注意总个数不要超过 2*n
      + 然后对其进行优化，总共有 n 对括号，则左括号和右括号的个数都是 n
      + 如果左括号的个数<n，则可以添加左括号。如果右括号的个数小于左括号的个数，则可以添加右括号
   + 要点
      + 注意递归的四要素（终结条件，当前层逻辑，下探层逻辑，清理当前层状态）
      + 括号合法性的校验