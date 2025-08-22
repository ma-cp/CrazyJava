import java.util.Arrays;

/**
 * 注意：这个程序的大部分代码在课本中已经给出，综合时间成本以及学习效果，改动将在课本代码的基础上进行。<br>
 * 目标：这个类的主要功能是，将double类型的一个“金钱数额”转化成str类型的“汉语读法”<br>
 * 适用范围：由于double最多精确存储15位，故只考虑15位以内的数字<br>
 * 解题思路（graphviz语法）：<br>
 *    输入double钱数 -> 分割成小数部分和整数部分（divide） -> {处理整数部分 处理小数部分}<br>
 *    处理小数部分 -> 直接转化（xiaotoRmb） -> 拼接（trans）<br>
 *    处理整数部分 -> 分为四位一组转化（toHanStr） -> 为每个转化的组添加单位（groupTrans） -> 拼接（trans）<br>
 */

public class Num2Rmb {

    private String[] hanArr = {"零", "一", "二", "三", "四", "五", "六", "七","八","九"};
    private String[] unitArr = {"十","百","千"};
    private String[] rmbArr = {"角", "分"};

    public static void main(String[] args) {
        Num2Rmb nr = new Num2Rmb();
        System.out.println(Arrays.toString(nr.divide(236711125.123)));
        System.out.println(nr.toHanStr("6009"));
        System.out.println(nr.xiaotoHanStr(nr.divide(236711125.123)[1]));
        System.out.println(nr.trans(23400600.1));
    }

    public String trans(double num){
        String[] bothStr = divide(num);
        return groupTrans(bothStr[0])+"元"+xiaotoHanStr(bothStr[1]);
    }

    private String groupTrans(String s) {
        int strLen = s.length();
        String result = "";
        int iCount = 0;
        for (int i = strLen; i > 0; i-=4) {
            iCount +=1;
            result = toHanStr(s.substring(i-4, i)) +(iCount==2? "万" :"")+(iCount==3? "亿" : "")+ result;
        }
        return result;
    }

    /**
     * 用来将一个double精度的“数”分成“整数部分”和“小数部分”两部分的“字符串数组”
     * @param num num,一个double类型的数，将被看作有“整数部分”和“小数部分”
     * @return 返回一个内容如{"整数部分","小数部分"}的拥有两个元素的数组，小数部分必为2位或空
     */
    private String[] divide(double num){
        long zheng = (long)num;
        long xiao = Math.round((num-zheng)*100);  // round起一个四舍五入的作用
        return new String[]{zheng+"", String.valueOf(xiao)};
    }

    /**
     * 处理四位整数的转译问题
     * @param numStr 一个小于一万的整数字符串
     * @return 返回一个最高为千位的转译好的字符串。
     */
    private String toHanStr(String numStr) {
        String result = "";
        int numLen = numStr.length();

        boolean followZero = false;
        for (int i = 0; i < numLen; i++) {
            // 字符型转整形，char类型的'4'会被转成int类型的4
            int num = numStr.charAt(i) - 48; // 字符串的charAt方法实际上是将字符串看作是一个数组，并在字符串上索引

            // 仅当一个数不是零，而且不是个位时，需要补单位
            // 当一个数是零，仅当其前方不是零，且后方不全是零时，输出零
            result += ((num != 0 && followZero)?hanArr[0]:"") +
                    ((num != 0)?hanArr[num]:"") +
                    ((num != 0 && i != numLen-1)?unitArr[numLen-2-i]:"");
            followZero = (num == 0);

        }
        return result;
    }

    private String xiaotoHanStr(String numStr) {
        String result = "";
        int numLen = numStr.length();
        for (int i = 0; i < numLen; i++) {
            // 字符型转整形，char类型的'4'会被转成int类型的4
            int num = numStr.charAt(i) - 48; // 字符串的charAt方法实际上是将字符串看作是一个数组，并在字符串上索引

            result += (num==0&&i==1?"":hanArr[num]) + (num==0?"":rmbArr[i]);
        }
        return result;
    }
}
