package pers.hanchao.basiccodeguideline.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * <p>Description: </P>
 *
 * @author hanchao
 * @date 2018/9/27 上午10:22
 */
public class FindVirusImpl implements FindVirus {
    /**
     * <p>Description: </p>
     *
     * @param target 被感染的数组
     * @return 感染的数字
     * @author hanchao
     * @date 2018/9/27 上午10:21
     */
    @Override
    public int findVirus(List<Integer> target) {
        //空
        if (target == null || target.isEmpty()) {
            return -1;
        }
        //排序
        target.sort(Integer::compareTo);
        //重复元素集合
        List<RepeatedItem> repeatedItems = new ArrayList<>();
        RepeatedItem tempItem = new RepeatedItem();
        for (int i = 0; i < target.size(); i++) {
            tempItem.setValue(target.get(i));
            //有值累加
            if (repeatedItems.contains(tempItem)) {
                //找到返回
                if (repeatedItems.get(repeatedItems.indexOf(tempItem)).getCount() >= target.size() / 2) {
                    return target.get(i);
                } else {
                    //没找到累加
                    repeatedItems.get(repeatedItems.indexOf(tempItem)).increment();
                }
            } else {
                //无值新增
                repeatedItems.add(new RepeatedItem(target.get(i), 1));
            }
        }
        return -1;
    }

    class RepeatedItem {
        int value;
        int count;

        public RepeatedItem(int value, int count) {
            this.value = value;
            this.count = count;
        }

        public RepeatedItem() {

        }

        public void increment() {
            count++;
        }


        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof RepeatedItem)) {
                return false;
            }
            RepeatedItem that = (RepeatedItem) o;
            return Objects.equals(getValue(), that.getValue());
        }

        @Override
        public int hashCode() {

            return Objects.hash(getValue());
        }
    }
}
