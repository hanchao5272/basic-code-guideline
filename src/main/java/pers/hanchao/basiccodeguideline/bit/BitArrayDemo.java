package pers.hanchao.basiccodeguideline.bit;

/**
 * <p> </P>
 *
 * @author hanchao
 */
public class BitArrayDemo {

    public static void main(String[] args) {
//        int[] a = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12};
//        System.out.println(missingNumberInByBitSet(a));
//        System.out.println();
//
//        a = new int[]{11, 7, 2, 3, 8, 5, 6, 1, 9, 10, 0, 12};
//        System.out.println(missingNumberInByBitSet(a));
//        System.out.println();

        // 5
        int[] b = new int[]{0,1,2,3,4,5,5,6,7,8};
        System.out.println(repeatNumber(b));
        System.out.println();

        // 10
        b = new int[]{10, 7, 2, 3, 8, 5, 6, 1, 9, 10, 0, 4};
        System.out.println(repeatNumber(b));
        System.out.println();

        // 8
        b = new int[]{10, 7, 2, 3, 8, 5, 6, 1, 8, 9, 0, 4};
        System.out.println(repeatNumber(b));
        System.out.println();
    }

    /**
     * 长度为n的数组，存在n个不重复的数据，其中最后一个元素为n，找出漏掉的那个。
     * 如 [0,1,2,4] 长度为4，最后一个元素为4，缺失元素为3
     */
    public static int missingNumberInByBitSet(int[] array) {
        int bitSet = 0;
        for (int element : array) {
            //i-1个元素在bit数组中的情况
            System.out.println("bitSet: " + Integer.toBinaryString(bitSet));
            //i元素放在bit数组的最左+1位置
            int elementLeft1 = 1 << element;
            System.out.println("eleBit: " + Integer.toBinaryString(elementLeft1));
            //合并之后，就是从开始至i元素的存在情况
            bitSet = bitSet | elementLeft1;
            System.out.println("bitSet: " + Integer.toBinaryString(bitSet));
            System.out.println();
        }

        //左移n位-1，得到n个元素都存在的bit位，例如： 1111
        int max = (2 << array.length) - 1;
        System.out.println("maxBit: " + Integer.toBinaryString(max));
        //与元素的真实存在情况异或，例如： 1011 ^ 1111 = 100
        int result = bitSet ^ (max);
        System.out.println("result: " + Integer.toBinaryString(result));
        //取长度就是元素所在位置，如 100 即 3
        result = String.valueOf(Integer.toBinaryString(result)).length() - 1;
        System.out.println("result: " + result);

        return result;
    }

    /**
     * 长度为n的数组，存在n个数据，其中有两个数据重复其中最后一个元素为n，找出漏掉的那个。
     * 如 [0,1,2,2,3] 长度为5，最后一个元素为n-2，其中重复的元素为2
     */
    public static int repeatNumber(int[] a) {
        int bitSet = 0;
        for (int element : a) {
            System.out.println("bitSet: " + Integer.toBinaryString(bitSet));
            int eleBit = 1 << element;
            System.out.println("eleBit: " + Integer.toBinaryString(eleBit));
            bitSet = eleBit ^ bitSet;
            System.out.println("bitSet: " + Integer.toBinaryString(bitSet));
            System.out.println();
        }

        int maxBit = (1 << (a.length - 1)) - 1;
        System.out.println("maxBit: " + Integer.toBinaryString(maxBit));
        int resBit = maxBit ^ bitSet;
        System.out.println("resBit: " + Integer.toBinaryString(resBit));
        int result = Integer.toBinaryString(resBit).length() - 1;
        System.out.println("result: " + result);

        return result;
    }

}
