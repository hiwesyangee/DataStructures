package recursion;

/**
 * 尝试数组递归求和
 */
public class Sum {

    // 递归方式数组求和
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    // 计算数组中arr[l,...,n]这个区间内所有数字的和————————真正的递归函数
    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(sum(arr));
    }

}
