package segmenttree;

/**
 * 自定义融合器接口
 */
public interface Merger<E> {

    // 将两个任意元素融合，返回一个类型的值
    E merge(E a, E b);

}
