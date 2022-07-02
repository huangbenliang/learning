fucking-algorithm review

# 链表要点小结

1. 范围问题采用虚拟头节点，可避免处理头节点为空问题。
2. 快慢指针可处理倒数节点问题（先让快指针走k步，再同时走，当快指针走到末尾，慢节点即为倒数第k节点）
3. 全局变量不会随着函数栈变化，在后序遍历时，可以**存进入路径信息或者左右指针**。
4. 递归终止条件：如果需要在最后一个节点就运行后续遍历代码 `if(head==null)`,如果需要再倒数第二个节点就运行后续遍历代码`if head.next==null`.**反转链表都是在倒数第二个节点运行后序遍历代码。**

### 反转链表

#### 递归思路：（类似链表的后序遍历）

终止条件：如果需要在最后一个节点就运行后续遍历代码 `if(head==null)`,如果需要再倒数第二个节点就运行后续遍历代码`if head.next==null`.**反转链表都是在倒数第二个节点运行后序遍历代码。**

1. 反转整个链表

   ```java
   ListNode reverse(ListNode head) {
       //倒数第二个节点运行后续遍历代码
       if (head.next == null) return head;
       ListNode last = reverse(head.next);
       //当前进行指针反转
       head.next.next = head;
       //当前节点的下一节点进行断开，主要是为了第一个节点设置的（第一个节点引用第二个节点，第二个节点由于反转引用第一个节点），所以可以单独进行设置
       head.next = null;
       return last;
   }
   ```

2. 反转链表前N个节点

```java
ListNode successor = null; // 后驱节点,全局参数不会随着函数栈变化。

// 反转以 head 为起点的 n 个节点，返回新的头结点
ListNode reverseN(ListNode head, int n) {
    if (n == 1) { 
        // 记录第 n + 1 个节点
        successor = head.next;
        return head;
    }
    // 以 head.next 为起点，需要反转前 n - 1 个节点
    ListNode last = reverseN(head.next, n - 1); //总体而言范围需要缩小，

    head.next.next = head;
    // 让反转之后的 head 节点和后面的节点连起来
    head.next = successor;
    return last;
}
```

3.反转部分节点

```java
ListNode reverseBetween(ListNode head, int m, int n) {
    // base case
    if (m == 1) {
        return reverseN(head, n);
    }
    // 前进到反转的起点触发 base case
    head.next = reverseBetween(head.next, m - 1, n - 1);
    return head;
}
```

#### 迭代思路（保存前驱和后继节点）

```java
// 反转以 a 为头结点的链表
ListNode reverse(ListNode a) {
    ListNode pre, cur, nxt;
    pre = null; cur = a; nxt = a;
    while (cur != null) {
        nxt = cur.next;
        // 逐个结点反转
        cur.next = pre;
        // 更新指针位置
        pre = cur;
        cur = nxt;
    }
    // 返回反转后的头结点
    return pre;
}
```

#### 反转k个一组链表

要点：通过全局变量存储左指针

```java
public class P234回文链表 {
    // 左侧指针
    ListNode left;

    boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    boolean traverse(ListNode right) {
        if (right == null) return true;
        boolean res = traverse(right.next);
        // 后序遍历代码
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }
    //带Self的是自己写的代码
    boolean isPalindromeSelf(ListNode head) {
        left = head; //全局变量单独存储
        return traverseSelf(head);
    }

    private boolean traverseSelf(ListNode right) {
        if (right == null) return true;
        boolean res = traverseSelf(right.next);
        if (res == false) return false; //当已经不是回文时，直接返回
        res = right.val == left.val; //左侧指针采用全局变量存储，右侧指针通过函数栈存储。
        left = left.next;//改变全局左侧指针
        return res;
    }
}
```

# 二叉树框架

## 思维模式

**1、是否可以通过遍历一遍二叉树得到答案**？如果可以，用一个 `traverse` 函数配合外部变量来实现，这叫「遍历」的思维模式。

**2、是否可以定义一个递归函数，通过子问题（子树）的答案推导出原问题的答案**？如果可以，写出这个递归函数的定义，并充分利用这个函数的返回值，这叫「分解问题」的思维模式。

无论使用哪种思维模式，你都需要思考：

**如果单独抽出一个二叉树节点，它需要做什么事情？需要在什么时候（前/中/后序位置）做**？其他的节点不用你操心，递归函数会帮你在所有节点上执行相同的操作。

## 前中后序理解

**前中后序是遍历二叉树过程中处理每一个节点的三个特殊时间点**，绝不仅仅是三个顺序不同的 List：

前序位置的代码在刚刚进入一个二叉树节点的时候执行；

后序位置的代码在将要离开一个二叉树节点的时候执行；（左子树、右子树都遍历完成时。可以获取到左右子树的信息）

中序位置的代码在一个二叉树节点左子树都遍历完，即将开始遍历右子树的时候执行。

## 执行逻辑

![image-20220531201351955](算法刷题.assets/image-20220531201351955.png)

![image-20220531201411025](算法刷题.assets/image-20220531201411025.png)

P104:二叉树遍历最大深度

```java
// 记录最大深度
int res = 0;
// 记录遍历到的节点的深度
int depth = 0;

// 主函数
int maxDepth(TreeNode root) {
    traverse(root);
    return res;
}

// 二叉树遍历框架
void traverse(TreeNode root) {
    if (root == null) {
        // 到达叶子节点，更新最大深度
        res = Math.max(res, depth);
        return;
    }
    // 前序位置
    depth++;
    traverse(root.left);
    traverse(root.right);
    // 后序位置
    depth--;
}
```



### 层序遍历

```java
// 输入一棵二叉树的根节点，层序遍历这棵二叉树
void levelTraverse(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    // 从上到下遍历二叉树的每一层
    while (!q.isEmpty()) {
        int sz = q.size();
        // 从左到右遍历每一层的每个节点
        for (int i = 0; i < sz; i++) {
            TreeNode cur = q.poll();
            // 将下一层节点放入队列
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
    }
}
```

![image-20220520115252357](算法刷题.assets/image-20220520115252357.png)

### 二叉树节点打印框架（层序遍历）

```java
//Definition for a binary tree node.
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        if (this == null) {
            System.out.println("[]");
        }
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(this);
        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                TreeNode cur = q.poll();
                if (cur == null) {
                    sb.append("* ");
                    continue;
                }
                sb.append(cur.val + " ");

                if (cur.left != null) {
                    q.offer(cur.left);
                } else {
                    q.offer(null);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                } else {
                    q.offer(null);
                }

            }
        }
        int k = sb.length();
        while (k > 0) {
            if (sb.charAt(k - 2) == '*') {
                k -= 2;
            } else {
                break;
            }
        }
        return sb.substring(0, k);
    }
}
```

# 二叉搜索树

### 传递父节点信息

**通过使用辅助函数，增加函数参数列表，在参数中携带额外信息，将这种约束传递给子树的所有节点，这也是二叉树算法的一个小技巧**

```java
boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
}

/* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */
boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
    // base case
    if (root == null) return true;
    // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
    if (min != null && root.val <= min.val) return false;
    if (max != null && root.val >= max.val) return false;
    // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
    return isValidBST(root.left, min, root) 
        && isValidBST(root.right, root, max);
}

```

### 插入一个节点

```java
TreeNode insertIntoBST(TreeNode root, int val) {
    // 找到空位置插入新节点
    if (root == null) return new TreeNode(val);
    // if (root.val == val)
    //     BST 中一般不会插入已存在元素
    if (root.val < val) 
        root.right = insertIntoBST(root.right, val);
    if (root.val > val) 
        root.left = insertIntoBST(root.left, val);
    return root;
}

```

### 删除节点

```java
/*
1. 书写删除框架
2. 找到了 情况 1，2 
3. 情况三 找到右子树最小节点；删除最小节点；将最小节点替换成root(3步) 共7步
*/
TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;
    if (root.val == key) {
        // 这两个 if 把情况 1 和 2 都正确处理了
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        // 处理情况 3
        // 获得右子树最小的节点
        TreeNode minNode = getMin(root.right);
        // 删除右子树最小的节点
        root.right = deleteNode(root.right, minNode.val);
        // 用右子树最小的节点替换 root 节点
        minNode.left = root.left;
        minNode.right = root.right;
        root = minNode;
    } else if (root.val > key) {
        root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
        root.right = deleteNode(root.right, key);
    }
    return root;
}

TreeNode getMin(TreeNode node) {
    // BST 最左边的就是最小的
    while (node.left != null) node = node.left;
    return node;
}

```



# 二分搜索

**注意搜索区间**

查找左侧边界时，移动**右侧边界**。左侧边界返回左边，但是左侧边界可能越界。需要考虑。

```java
int binarySearch(int[] nums, int target) {
    int left = 0; 
    int right = nums.length - 1; // 注意,区间是[0,length-1]

    while(left <= right) { //当相等时，搜索自己。结束条件是left=right+1
        int mid = left + (right - left) / 2;
        if(nums[mid] == target)
            return mid; 
        else if (nums[mid] < target)
            left = mid + 1; // 注意,此时mid已经被搜索过了，下一个区间不必包含mid
        else if (nums[mid] > target)
            right = mid - 1; // 注意
    }
    return -1;
}
```

```java
int binary_search(int[] nums, int target) {
    int left = 0, right = nums.length - 1; 
    while(left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid - 1; 
        } else if(nums[mid] == target) {
            // 直接返回
            return mid;
        }
    }
    // 直接返回
    return -1;
}
//左侧边界需要考虑越界情况。
int left_bound(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid - 1;
        } else if (nums[mid] == target) {
            // 别返回，锁定左侧边界
            right = mid - 1;
        }
    }
    // 最后要检查 left 越界的情况。当要查找的target比nums所有数字都大时，推出while时left=right+1=nums.length。至于right也会小于0,但是我们返回的left,所以不关关心。第二个nums[left]!=target是由于left可能没有动过，此时left=0，默认返回left.需要判断left是否符合条件
    if (left >= nums.length || nums[left] != target)
        return -1;
    return left;
}


int right_bound(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid - 1;
        } else if (nums[mid] == target) {
            // 别返回，锁定右侧边界
            left = mid + 1;
        }
    }
    // 最后要检查 right 越界的情况
    if (right < 0 || nums[right] != target)
        return -1;
    return right;
}
```





![](算法刷题.assets/image-20220524155949637-16537088395701-16537090081754.png)

## 回溯算法（排列组合问题，分支问题）

#### 框架

![image-20220528112728775](算法刷题.assets/image-20220528112728775.png)

1. 画递归树（根节点一般为空）

![image-20220528113157605](算法刷题.assets/image-20220528113157605-16537087237131.png)

2.写框架(无重复数字的全排列)

```java
List<List<Integer>> res = new LinkedList<>();

/* 主函数，输入一组不重复的数字，返回它们的全排列 */
List<List<Integer>> permute(int[] nums) {
    // 记录「路径」
    LinkedList<Integer> track = new LinkedList<>();
    backtrack(nums, track);
    return res;
}

// 路径：记录在 track 中
// 选择列表：nums 中不存在于 track 的那些元素
// 结束条件：nums 中的元素全都在 track 中出现
void backtrack(int[] nums, LinkedList<Integer> track) {
    // 触发结束条件
    if (track.size() == nums.length) {
        res.add(new LinkedList(track));
        return;
    }

    for (int i = 0; i < nums.length; i++) {
        // 排除不合法的选择
        if (track.contains(nums[i]))
            continue;
        // 做选择
        track.add(nums[i]);
        // 进入下一层决策树
        backtrack(nums, track);
        // 取消选择
        track.removeLast();
    }
}
```

**形式一、元素无重不可复选，即`nums`中的元素都是唯一的，每个元素最多只能被使用一次**，`backtrack`核心代码如下：

root:[1，2，3]  res = [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]

```java
/* 组合/子集问题回溯算法框架 */
void backtrack(int[] nums, int start) {
    // 回溯算法标准框架
    for (int i = start; i < nums.length; i++) { //子集，组合问题 全是start开始
        // 做选择
        track.addLast(nums[i]);
        // 注意参数
        backtrack(nums, i + 1);
        // 撤销选择
        track.removeLast();
    }
}
//res = [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]  全排列 track.size()=nums.lenght
/* 排列问题回溯算法框架 */
void backtrack(int[] nums) {
    if (nums.length == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }
    for (int i = 0; i < nums.length; i++) { //排列问题： start=0 通过 user[i] 去掉使用过的
        // 剪枝逻辑
        if (used[i]) {
            continue;
        }
        // 做选择
        used[i] = true;
        track.addLast(nums[i]);

        backtrack(nums);
        // 取消选择
        track.removeLast();
        used[i] = false;
    }
}
```

**形式二、元素可重不可复选，即`nums`中的元素可以存在重复，每个元素最多只能被使用一次**，其关键在于排序和剪枝，`backtrack`核心代码如下：

```java
//[2,1,1]  res = [[], [1], [1, 1], [1, 1, 2], [1, 2], [2]]
Arrays.sort(nums);
/* 组合/子集问题回溯算法框架 */
void backtrack(int[] nums, int start) {
    // 回溯算法标准框架
    for (int i = start; i < nums.length; i++) {
        // 剪枝逻辑，跳过值相同的相邻树枝
        if (i > start && nums[i] == nums[i - 1]) {    //可重复不可复选，先排序，如果相同则继续
            continue;
        }
        // 做选择
        track.addLast(nums[i]);
        // 注意参数
        backtrack(nums, i + 1);
        // 撤销选择
        track.removeLast();
    }
}

//[2,1,1]  res=[[1, 1, 2], [1, 2, 1], [2, 1, 1]]
Arrays.sort(nums);
/* 排列问题回溯算法框架 */
void backtrack(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        // 剪枝逻辑
        if (used[i]) {
            continue;
        }
        // 剪枝逻辑，固定相同的元素在排列中的相对位置
        if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {   //排序，不可复选，前一个元素必须没有用过。
            continue;
        }
        // 做选择
        used[i] = true;
        track.addLast(nums[i]);

        backtrack(nums);
        // 取消选择
        track.removeLast();
        used[i] = false;
    }
}
```

**形式三、元素无重可复选，即`nums`中的元素都是唯一的，每个元素可以被使用若干次**，只要删掉去重逻辑即可，`backtrack`核心代码如下：

```java
//[1,2,3] res = [[1, 1, 1], [1, 1, 2], [1, 1, 3], [1, 2, 2], [1, 2, 3], [1, 3, 3], [2, 2, 2], [2, 2, 3], [2, 3, 3], [3, 3, 3]]
/* 组合/子集问题回溯算法框架 */
void backtrack(int[] nums, int start) {
    // 回溯算法标准框架
    for (int i = start; i < nums.length; i++) {
        // 做选择
        track.addLast(nums[i]);
        // 注意参数
        backtrack(nums, i);    //可以复选，则不需要剪枝
        // 撤销选择
        track.removeLast();
    }
}

//res = [[1, 1, 1], [1, 1, 2], [1, 1, 3], [1, 2, 1], [1, 2, 2], [1, 2, 3], [1, 3, 1], [1, 3, 2], [1, 3, 3], [2, 1, 1], [2, 1, 2], [2, 1, 3], [2, 2, 1], [2, 2, 2], [2, 2, 3], [2, 3, 1], [2, 3, 2], [2, 3, 3], [3, 1, 1], [3, 1, 2], [3, 1, 3], [3, 2, 1], [3, 2, 2], [3, 2, 3], [3, 3, 1], [3, 3, 2], [3, 3, 3]]
/* 排列问题回溯算法框架 */
void backtrack(int[] nums) {
    if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
    for (int i = 0; i < nums.length; i++) {   //排列可以复选，都不用干。
        // 做选择
        track.addLast(nums[i]);

        backtrack(nums);
        // 取消选择
        track.removeLast();
    }
}
```

# 滑动窗口：适用于寻找子串题目

思路：

**现在开始套模板，只需要思考以下四个问题**：

1、当移动`right`扩大窗口，即加入字符时，应该更新哪些数据？

2、什么条件下，窗口应该暂停扩大，开始移动`left`缩小窗口？

3、当移动`left`缩小窗口，即移出字符时，应该更新哪些数据？

4、我们要的结果应该在扩大窗口时还是缩小窗口时进行更新？

```java
import java.util.HashMap;
import java.util.Map;

class P76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        //存入need
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        int start = 0, len = s.length() + 1;
        //第一层：移动右侧指针
        while (right < s.length()) {
            Character key = s.charAt(right++);
            if (need.containsKey(key)) {
                window.put(key, window.getOrDefault(key, 0) + 1);
                if (window.get(key).equals(need.get(key))) {
                    valid++;
                }
            }
            /*** debug 输出的位置 ***/
            System.out.printf("window: [%d, %d)\n", left, right);
            
            //第二层while,移动左侧指针  若要固定长度：right-left==s1.size()
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char c = s.charAt(left++);
                if (need.containsKey(c)) {
                    if (window.get(c).equals(need.get(c))) {
                        valid--;
                    }
                    window.put(c, window.get(c) - 1);
                }
            }
        }

        return len == s.length() + 1 ? "" : s.substring(start, start + len);
    }
}
```

