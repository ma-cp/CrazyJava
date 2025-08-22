import javax.xml.transform.Source;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 由于是和“字节”相关的，所以做出做基本的假设：<br>
 * 1. 认为java的string用的是utf16编码，即字母和中文在堆中都是2字节大小<br>
 * （utf8编码中英文1字节，中文3字节，不利于处理）<br>
 * （结论：默认string底层的utf16实现，并默认print的utf8实现）<br>
 * 2. 不考虑字符串语义，只考虑对字节的正确分割。<br>
 * （结论：哪怕中文是两个字节，如果请求从中间分割，也切实的执行）<br>
 * 总的思路：字符串输入->使用substring循环切片，判断字符中英同时判断byte数组切点<br>
 * ->从字符串得到byte数组切割并转回字符串->返回切割后的字符串<br>
 */

public class SubStringByte {
    public static void main(String[] args) {
        String letter = "中国abc"; // 内部表示（UTF-16）
        System.out.println(substringByte(letter, 2,5));
    }

    /**
     * 传入str->substring用utf8循环切片，每次切一个字符，记录上一片长度和当前片，判断切片长度变化来判断中英<br>
     * ->当长度变化为1，则为英，长度变化为3（不为1），则为中->最终切片在utf16中进行，传入的start和end用来标记最终切片位置<br>
     * ->当遇到英文，则start和end同步+1，当遇到中文，start和end不变，等待池tostart、toend大小同步变化<br>
     * @param source 源串
     * @param start 切片开始位置
     * @param end 切片结束位置（开区间）
     * @return 按字节的切片结果
     */
    static String substringByte(String source, int start, int end){
        for (int i = 1, oldlen = 0, tostart = start, toend = end; i <= source.length(); i++) {
            int bytesLen = source.substring(0, i).getBytes(StandardCharsets.UTF_8).length;
            if (tostart <=0 && toend <=0) {
                break;
            }
            if (bytesLen-oldlen != 1) {
                tostart -=2;
                toend -=2;
            } else if (bytesLen-oldlen == 1 && tostart>0) {
                start +=1;
                end +=1;
                tostart -=1;
                toend -=1;
            } else if (bytesLen-oldlen == 1 && toend>0) {
                end +=1;
                toend -=1;
            }
            oldlen = bytesLen;
        }
        return new String(Arrays.copyOfRange(source.getBytes(StandardCharsets.UTF_16BE), start, end), StandardCharsets.UTF_16BE);
    }
}
