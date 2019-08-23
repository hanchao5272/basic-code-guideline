package pers.hanchao.basiccodeguideline;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import pers.hanchao.basiccodeguideline.stream.Person;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p></P>
 *
 * @author hanchao 2018/10/30 下午6:49
 */
public class SimpleTest {

    /**
     * 包含测试
     */
    @Test
    public void containsTest() {
        String indirectShardingColumn = "id,news_id";
        String column = "id";
        assert indirectShardingColumn.contains(column);
    }

    /**
     * ThreadLocalRandom
     */
    @Test
    public void testThreadLocalRandom() {
        for (int i = 0; i < 10; i++) {
            System.out.println(ThreadLocalRandom.current().nextInt(0));
        }
    }

    /**
     * 合并list
     */
    @Test
    public void mergeList() {
        List<List<Integer>> listList = new ArrayList<>();
        List l1 = new ImmutableList.Builder<Integer>().add(1, 3, 5).build();
        List l2 = new ImmutableList.Builder<Integer>().add(2, 4, 6).build();
        listList.add(l1);
        listList.add(l2);
        List<Integer> list = listList.stream().map(list1 -> {
            Integer[] arrays = new Integer[list1.size()];
            list1.toArray(arrays);
            return arrays;
        }).flatMap(Arrays::stream).collect(Collectors.toList());

        list.forEach(System.out::println);
    }

    /**
     * 找到列表中的distinct元素
     */
    @Test
    public void listDistinct() {
        List<Integer> testList = new ImmutableList.Builder<Integer>()
                .add(110945, 111025, 111028, 111097, 111097, 111097, 111416, 111556, 112069, 112120, 112666, 112730, 113305, 113305, 113661, 113754, 113853, 113857, 113861, 113861, 114441, 114441, 114441, 114441, 114441, 114441, 114441, 114441, 114441, 114441, 114441, 114441, 114591, 114591, 114917, 115140, 115140, 115559, 115575, 115580, 115582, 115583, 115589, 115601, 115686, 115884, 115884, 116262, 116544, 117281, 117443, 117443, 117542, 117542, 117804, 117842, 118354, 118482, 118547, 118547, 118957, 119285, 119347, 119878, 120076, 120076, 120076, 120076, 120076, 120076, 120076, 120076, 120076, 120076, 120373, 120373, 120381, 120381, 120389, 120432, 120447, 121148, 121173, 121173, 121311, 121489, 121795, 122156, 122553, 122553, 122553, 122553, 122596, 122692, 122692, 122692, 123143, 123144, 123144, 123144, 123144, 123144, 123144, 123144, 123144, 123199, 123199, 123237, 123713, 123719, 123737, 123741, 124561, 124561, 124994, 125068, 126944, 127365, 127692, 128581, 128945, 128945, 128956, 129108, 129543, 129815, 129815, 129815, 129815, 131089, 131090, 131091, 131092, 131093, 131094, 131095, 131096, 131096, 131097, 131097, 131098, 131099, 131101, 131102, 131103, 131104, 131106, 131108, 131108, 131109, 131109, 131110, 131110, 131111, 131112, 131113, 131113, 131114, 131115, 131115, 131116, 131117, 131117, 131120, 131121, 131122, 131123, 131124, 131124, 131125, 131125, 131126, 131127, 131127, 131128, 131129, 131130, 131130, 131131, 131132, 131133, 131133, 131134, 131135, 131136, 131138, 131140, 131141, 131142, 131142, 131143, 131144, 131145, 131145, 131147, 131148, 131149, 131646, 132037, 132078, 132078, 132134, 132353, 132789, 132800, 132910, 132910, 133061, 133390, 133428, 133428, 133440, 133440, 133670, 133706, 134045, 134136, 134914, 134914, 135043, 135292, 135468, 135470, 135506, 135506, 135811, 136416, 136416, 136416, 136416, 136416, 136430, 136483, 136483, 136483, 136965, 136965, 137782, 137858, 137858, 138170, 138170, 138238, 138700, 138705, 138707, 138712, 138713, 138715, 139115, 139595, 141542, 141542, 141606, 142050, 142050, 142208, 142408, 142529, 142529, 142672, 143184, 143396, 143482, 143556, 143901, 143901, 144566, 144781, 144813, 144939, 144942, 145231, 145238, 145581, 145583, 145656, 145798, 145798, 146048, 146132, 147426, 148233, 148263, 148507, 148507, 148507, 148507, 148527, 149425, 149558, 149783, 150186, 150276, 150326, 150570, 150814, 150860, 150990, 150990, 151503, 151633, 151811, 152377, 152871, 152871, 152871, 153055, 153300, 153325, 153687, 153687, 154270, 154270, 154379, 154458, 154458, 154459, 154459, 154460, 154460, 154779, 154779, 154781, 154781, 154781, 154785, 154785, 154787, 154787, 154788, 154788, 154790, 154790, 154792, 154792, 154793, 154793, 154795, 154795, 154797, 154797, 154798, 154798, 154798, 154800, 154800, 154802, 154802, 154803, 154803, 154804, 154804, 154900, 154900, 154903, 154903, 154905, 154905, 154914, 154946, 155038, 155038, 155038, 155038, 155038, 155038, 155038, 155610, 156187, 156561, 156907, 156922, 157614, 157627, 158664, 158731, 159264, 159377, 159377, 160431, 160448, 160624, 160826, 161023, 161091, 161603, 161781, 162305, 162341, 162805, 162805, 162916, 163482, 163760, 163971, 164128, 164253, 165161, 165662, 165662, 165744, 167394, 167499, 167994, 168010, 168325, 168493, 168658, 169874, 171487, 171489, 172275, 172362, 173204, 173705, 173712, 173725, 173734, 173847, 173848, 173848, 173848, 173848, 173848, 173848, 174040, 174040, 174383, 174385, 174451, 174637, 174637, 174637, 175162, 176079, 177368, 177496, 177794, 178612, 178925, 179265, 179265, 179357, 179505, 179596, 179705, 179705, 179908, 180093, 180338, 180991, 180991, 181972, 182134, 182163, 182376, 183689, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183724, 183940, 183943, 184089, 184872, 184944, 184998, 185087, 185087, 185791, 185791, 187474, 187535, 187535, 187576, 187835, 187856, 187976, 188448, 188661, 189155, 189183, 189378, 190004, 190004, 190425, 190466, 191242, 191268, 191508, 191670, 193468, 194009, 194021, 194062, 194312, 194473, 194473, 194889, 194889, 194939, 194939, 194939, 195587, 195587, 195612, 195971, 195971, 197918, 198311, 198311, 198420, 198629, 198629, 199163, 199203, 200118, 200364, 200760, 200769, 200846, 201672, 201672, 202082, 202137, 202137, 202137, 202517, 204073, 204073, 204397, 205329, 205329, 206317, 206844, 207436, 207441, 208869, 208869, 209084, 209087, 209091, 209386, 209386, 209724, 209842, 209939, 210498, 210498, 211661, 214668, 214966, 214966, 215606, 215931, 215931, 216084, 219579, 220060, 220230, 220230, 220230, 220230, 220376, 220446, 220446, 221054, 221297, 222467, 222894, 223312, 223624, 223624, 223624, 224996, 225071, 225071, 227051, 227108, 228871, 229006, 229213, 232954, 234361, 236674, 236722, 238199, 238199, 238199, 239333, 240039, 240090, 240429, 240429, 242107, 242418, 243237, 243405, 244086, 244569, 244569, 245727, 248119, 248119, 248123, 248128, 250963, 251853, 252056, 252749, 255550, 255550, 257174, 257626, 258297, 258297, 259969, 260832, 260960, 262903, 262903, 263515, 263542, 265556, 266402, 266402, 271456, 271456, 273321, 273849, 278773, 282139, 282139, 282428, 282428, 282428, 282428, 282577, 287716, 287716, 289341, 290659, 290659, 291866, 296991, 296991, 310340, 310340, 314939, 319838, 320118, 321626, 325961, 325961, 326830, 328552, 330780, 331753, 334909, 334909, 334909, 334983, 335012, 335016, 337582, 338611, 339149, 339149, 341358, 343083, 343430, 348152, 348495, 351695, 351888, 354809, 356010, 356010, 356010, 356010, 356010, 360104, 360104, 363764, 363764, 365808, 369310, 369318, 369417, 369418, 369728, 369850, 380013, 380013, 380990, 381806, 385054, 391093, 399455, 402381, 409624, 409998, 409998, 412249, 412674, 412674, 416170, 416172, 416173, 416174, 416180, 416181, 416182, 416183, 416187, 416194, 416199, 416202, 416203, 416205, 416206, 416207, 416211, 416213, 416216, 416217, 416218, 416219, 416220, 416221, 416223, 416226, 416227, 416228, 416230, 416233, 416233, 416235, 416241, 416242, 416243, 416247, 416254, 416255, 416256, 416257, 416258, 416262, 416265, 416278, 416282, 416285, 416288, 416294, 416296, 416301, 416303, 416308, 416310, 416320, 416329, 417840, 421104, 421104, 421104, 421547, 421719, 424709, 424893, 425043, 430264, 430277, 430315, 440652, 440655, 444032, 444032, 444039, 450936, 450936, 450936, 451390, 452609, 455411, 464411, 464928, 482063, 483075, 483075, 487890, 492370, 500775, 500775, 502106, 502823, 502823, 502823, 502823, 511877, 513045, 514568, 520995, 538484, 553152, 553152, 553152, 558397, 561170, 561170, 561170, 561170, 561170, 561170, 561170, 561170, 561170, 561170, 561170, 561170, 561170, 561170, 561170, 561170, 561170, 561170, 561170, 561170, 561578, 561579, 561580, 561581, 561582, 561582, 561583, 561584, 561584, 561585, 561586, 561587, 561587, 561588, 561589, 561590, 561591, 561593, 561594, 561595, 561596, 561597, 561597, 561598, 561599, 561600, 561601, 561602, 561603, 561604, 561605, 561606, 561608, 561609, 561610, 561611, 561612, 561613, 561614, 561615, 561616, 561617, 561618, 561620, 561621, 561622, 561624, 561625, 561723, 561748, 561753, 561944, 561945, 561946, 561947, 561948, 561950, 561950, 561951, 561952, 564387, 564387, 564940, 564940, 564956, 564956, 565521, 565521, 567439, 573751, 573751, 575171, 575401, 576342, 576659, 584199, 586429, 586429, 586573, 587347, 597245, 597477, 597477, 598642, 599497, 599500, 599504, 599608, 599610, 599611, 603428, 603428, 603431, 603431, 603497, 603497, 603528)
                .build();
        testList = testList.stream().distinct().collect(Collectors.toList());
        System.out.println(testList.size());
    }

    /**
     *
     */
    @Test
    public void maximumDifferenceForPrimaryKey() {
        //时间戳为初始化
        Long minKey = 0b0L;
        Long maxKey = 9007199254740991L;
        double MAX_KEY = Math.pow(2, 53);
    }

    /**
     * map相同
     */
    @Test
    public void equalsOfMap() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("key", "value");
        map1.put("key1", "value1");
        Map<String, String> map2 = new HashMap<>();
        map2.put("key", "value");
        map2.put("key1", "value1");
        assert map1.equals(map2);
        assert map1 != map2;
        Map<String, String> map3 = new HashMap<>();
        map3.put("key", "value");
        map3.put("key11", "value11");
        String str1 = map1.toString();
        System.out.println(str1);
        String str3 = map3.toString().replace("[0-9]+", "1");
        System.out.println(str3);
    }

    /**
     * 拆分与合并
     */
    @Test
    public void splitAndJoin() {
        String str1 = ",,organization,organization";
        String str2 = "organization,organization,organization";
        String str3 = "organization";
        String str4 = "";

        System.out.println(Joiner.on(",").join(Stream.of(("organization" + "," + str1).split(",")).distinct().filter(i -> !i.isEmpty()).collect(Collectors.toList())));
        System.out.println(Joiner.on(",").join(Stream.of(("organization" + "," + str2).split(",")).distinct().filter(i -> !i.isEmpty()).collect(Collectors.toList())));
        System.out.println(Joiner.on(",").join(Stream.of(("organization" + "," + str3).split(",")).distinct().filter(i -> !i.isEmpty()).collect(Collectors.toList())));

        System.out.println(Joiner.on(",").join(Stream.of(("government" + "," + str1).split(",")).distinct().filter(i -> !i.isEmpty()).collect(Collectors.toList())));
        System.out.println(Joiner.on(",").join(Stream.of(("government" + "," + str2).split(",")).distinct().filter(i -> !i.isEmpty()).collect(Collectors.toList())));
        System.out.println(Joiner.on(",").join(Stream.of(("government" + "," + str3).split(",")).distinct().filter(i -> !i.isEmpty()).collect(Collectors.toList())));

        System.out.println(Joiner.on(",").join(Stream.of(("" + "," + str3).split(",")).distinct().filter(i -> !i.isEmpty()).collect(Collectors.toList())));
        System.out.println(Joiner.on(",").join(Stream.of(("" + "," + str4).split(",")).distinct().filter(i -> !i.isEmpty()).collect(Collectors.toList())));
        System.out.println("====");
    }

    /**
     * 获取合法的手机号
     */
    @Test
    public void getLegalPhone() {
        System.out.println(getLegalPhone("111"));
        System.out.println(getLegalPhone("11111111111"));
        System.out.println(getLegalPhone("111111111111"));
    }

    /**
     * 获取合法的手机号
     */
    private String getLegalPhone(String phone) {
        if (null != phone) {
            if (11 == phone.length()) {
                if (Pattern.matches("1\\d{10}", phone)) {
                    return phone;
                }
            }
        }
        return null;
    }

    /**
     * 日期测试1
     */
    @Test
    public void testDate() {
        Long end = System.currentTimeMillis() - 14 * DateUtils.MILLIS_PER_DAY;
        Long begin = end - DateUtils.MILLIS_PER_DAY;
        Long mid = end - DateUtils.MILLIS_PER_DAY / 2;
        System.out.println("14天前：" + end);
        System.out.println("14天半前：" + mid);
        System.out.println("15天前：" + begin);

        end = System.currentTimeMillis() - 30 * DateUtils.MILLIS_PER_DAY;
        mid = end - DateUtils.MILLIS_PER_DAY / 2;
        begin = end - DateUtils.MILLIS_PER_DAY;
        System.out.println("30天前：" + end);
        System.out.println("30天半前：" + mid);
        System.out.println("31天前：" + begin);

        System.out.println("40天前：" + (System.currentTimeMillis() - 40 * DateUtils.MILLIS_PER_DAY));
    }

    /**
     * 设置空字段
     */
    @Test
    public void setNullField() {
        Person person = new Person();
        System.out.println(person);
        person.setAge(null);
        System.out.println(person);
    }

    /**
     * switch空对象
     */
    @Test(expected = NullPointerException.class)
    public void switchNull() {
        Integer type = null;
        switch (type) {
            case 0:
                System.out.println(1111);
                break;
            default:
                System.out.println(222);
                break;
        }
    }

    /**
     * list转换成array
     */
    @Test
    public void listToArrays() {
        List<String> list = Lists.newArrayList("1", "2");
        System.out.println(Arrays.toString(list.toArray(new String[list.size()])));
        System.out.println(Arrays.toString(list.toArray(new String[0])));
    }

    /**
     * 日期格式化
     */
    @Test
    public void dateFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
        System.out.println(sdf.format(new Date(System.currentTimeMillis())));
        System.out.println(DateFormatUtils.format(System.currentTimeMillis(), "yyyy年MM月dd日 HH时mm分"));
    }

    @Test
    public void name() {
        int a = 1;
        System.out.println(a++ + ++a);

        a = 1;
        int b = a++ + ++a;
        System.out.println(a);
        System.out.println(b);

        a = 1;
        b = ++a + a++;
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void  name2() {
        List list = Lists.newArrayList(457226,57815,57815,57815,57815,57815,57815,92912,734809,715969,24382,89613,13027,133706,659184,659184,659184,659184,135470,11281,11281,11281,11281,11281,11281,11281,11281,561723,88424,88424,88424,84653,68884,195587,195587,659186,659186,659186,659186,659186,659186,659186,659186,659186,659186,659186,659186,659186,182163,182163,182163,182163,182163,182163,182163,182163,7089,56254,65880,99728,99728,99728,99728,198311,502823,11704,11705,1609463,1609464,92912,92912,92912,92912,92912,92912,162528,162528,162528,162528,209939,133061,3714,133061,73826,73827,73828,73829,73830,73831,73832,73833,117281,108381,4421,4422,4423,4424,4425,4426,4427,4428,173848,20082,191508,187856,37122,266402,47915,10209,14842,29529,383729,158664,47915,47915)
                .stream().distinct().collect(Collectors.toList());
        System.out.println(list.size());
        System.out.println(list);
    }

    @Test
    public void name3() {
        String str = "MCN管理员:110强制删除 MasterMediaID:21797旗下子账号 MemberMediaID:3833";
        String str2 = str.replaceFirst("强制删除.*","").replaceFirst("MCN管理员:","");
        System.out.println(str2);
    }

    @Test
    public void time() {
        Long end = System.currentTimeMillis() - 14 * DateUtils.MILLIS_PER_DAY;
        Long begin = end - DateUtils.MILLIS_PER_DAY;
        System.out.println(end);
        System.out.println(begin);

        end = System.currentTimeMillis() - 30 * DateUtils.MILLIS_PER_DAY;
        begin = end - DateUtils.MILLIS_PER_DAY;
        System.out.println(end);
        System.out.println(begin);
    }

    /**
     *
     */
    @Test
    public void testLongWithPow() {
        System.out.println(String.valueOf(Math.pow(2, 53)));
        System.out.println(String.valueOf(Math.pow(2, 50)));
        System.out.println(String.valueOf(Math.pow(2, 43)));
    }
}