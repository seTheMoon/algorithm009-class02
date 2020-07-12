### 第 16 课
+ 位运算
    + 位运算符
    + 算数移位与逻辑移位
    + 位运算的应用
    + 判断奇偶
        + x%2 == 1 ----> (x&1) == 1
        + x%2 == 0 ----> (x&1) == 0
        + 除 2
            + x/2 ----> x >> 1
        + 清零最低位 的 1
            + x = x & (x-1)
        + 取最低位的 1
            + x & (-x)
        + 除法是向 0 取整,右移是向下取整


### 第 17 课
+ 布隆过滤器、LRU Cache
    + 布隆过滤器(类似于哈希表,只不过哈希表存储一个东西的额外信息,布隆过滤器只能存储一个东西有还是没有)
        + 一个很长的二进制向量和一系列随机映射函数.布隆过滤器可以用于检索一个元素是否在一个集合中
        + 优点是空间效率和查询时间都远远超过一般的算法
        + 缺点是有一定的误识别率和删除困难
        + 如果经过判断,一个元素不在布隆过滤器里,那他肯定不在.如果经过判断一个元素在布隆过滤器里,那他不可能存在
+ LRU 缓存机制
    + least recently use
    + 两个要素 : 大小、替换策略
    + Hash Table + Double LInkedList
    + O(1) 查询    O(1)修改、更新

### 第 18 课
+ 排序算法
    + 比较类排序
        + 通过比较来决定元素间的相对次序,由于其时间复杂度不能突破 O(nlogn),因此也被称为非线性时间比较类排序
        + 交换排序
            + 冒泡排序
            + 快速排序(重点看)
        + 插入排序
            + 简单插入排序
            + 希尔排序
        + 选择排序
            + 简单选择排序
            + 堆排序(重点看)
        + 归并排序
            + 二路归并排序(重点看)
            + 多路归并排序
    + 非比较类排序
        + 不通过比较来决定元素间的相对次序 ,他可以突破基于 比较排序的时间下界,以线性时间运行,因此也称为线性时间非比较排序
        + 但只能用于整形数据类型
        + 计数排序
        + 桶排序
        + 基数排序
+ 高级排序
    + 快速排序
        + 数组取标杆 pivot,将小元素放 pivot 左边,大元素放右边,然后依次对左边和右边的子数组继续快排;以达到整个序列有序
        + 从外而内的排序,与归并排序相反
```
public static void quickSort(int[] array, int begin, int end) {
    if (end <= begin) return;
    int pivot = partition(array, begin, end);
    quickSort(array, begin, pivot - 1);
    quickSort(array, pivot + 1, end);
}

static int partition(int[] a, int begin, int end) {
    // pivot: 标杆位置，counter: 小于pivot的元素的个数
    int pivot = end, counter = begin;
    for (int i = begin; i < end; i++) {
        if (a[i] < a[pivot]) {
            //  a[counter]是小于标杆元素的最后一个元素
            int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
            counter++;
        }
    }
    int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
    return counter;
}
```
+ 高级排序 
    + 归并排序-分治
        + 把长度为 n 的输入序列分成两个长度为 n/2 的子序列
        + 对这两个子序列分别采用归并排序
        + 将两个排序好的子序列合并成一个最终的排序序列
        + 从内而外的排序,跟快速排序相反
```
public static void mergeSort(int[] array, int left, int right) {
    if (right <= left) return;
    int mid = (left + right) >> 1; // (left + right) / 2

    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
}

public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 中间数组
        int i = left, j = mid + 1, k = 0;

        // 两个有序的数组合并在一起,永远是三段的
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid)   temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
        // 也可以用 System.arraycopy(a, start1, b, start2, length)
    }
```

+ 高级排序
    + 堆排序-堆插入 O(logN),取最大/最小 O(1)
    + 数组元素一次建立小顶堆(建议利用自带的大顶堆或小顶堆)
    + 依次取堆顶元素,并删除
```
static void heapify(int[] array, int length, int i) {
    int left = 2 * i + 1, right = 2 * i + 2；
    int largest = i;
    if (left < length && array[left] > array[largest]) {
        largest = left;
    }
    if (right < length && array[right] > array[largest]) {
        largest = right;
    }
    if (largest != i) {
        int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
        heapify(array, length, largest);
    }
}
public static void heapSort(int[] array) {
    if (array.length == 0) return;
    int length = array.length;
    // 遍历所有元素放入堆中
    for (int i = length / 2-1; i >= 0; i--) 
        heapify(array, length, i);
    // 取出
    for (int i = length - 1; i >= 0; i--) {
        int temp = array[0]; array[0] = array[i]; array[i] = temp;
        heapify(array, i, 0);
    }
}
```