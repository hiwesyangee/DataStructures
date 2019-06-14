package segmenttree;

/**
 * 线段树的测试方法
 */
public class Main {
    public static void main(String[] args) {

        Integer[] nums = {-2, 0, 3, -5, 2, -1};
//        SegmentTree<Integer> segTree = new SegmentTree<>(nums, new Merger<Integer>() {
//            @Override
//            public Integer merger(Integer a, Integer b) {
//                return a + b; // 如求和
//            }
//        });
        SegmentTree<Integer> segTree = new SegmentTree<>(nums, (a, b) -> a + b); // 使用λ表达式进行求和表示

        System.out.println(segTree);

        System.out.println(segTree.query(0, 2));
        System.out.println(segTree.query(2, 5));
        System.out.println(segTree.query(0, 5));

    }
}
