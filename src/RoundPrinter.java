/**
 * 想“打印”出一个圆，应该考虑到“画笔”<br>
 * 在命令行里可以认为“每一笔”是一个长方形<br>
 * 假设这个长方形的长宽比是一个整数，默认为3，并且可以调节<br>
 * 如果要画圆，首先是要确定圆心的位置<br>
 * 当确定了圆心的位置，可以在打印时判断打印空格还是星星<br>
 * 通过圆心的位置，可以计算横向输出多少格、纵向输出多少行<br>
 * 假设半径最小是1，最大无限制<br>
 * 假设一格的长是1，圆心在某一格的中心，与圆心距离为1的格都表现为星星<br>
 * 改变“格长”实际上只需改变半径<br>
 */

public class RoundPrinter {
    public static void main(String[] args) {
        int cube_ratio = 3; // 打印格的长宽比，默认为3
        int radius = 5; // 半径，最小为1，最大无限制
        double brush_width = 0.1; // 画笔宽度，由于是方格子，画笔的宽度不可忽略

        // 圆心位置（横坐标，纵坐标），横坐标=横纵比x半径格数+1，纵坐标=半径格数+1
        int[] round_center = new int[] {cube_ratio*radius+1, radius+1};

        // 行数小于2倍的圆心纵坐标，列数小于2倍的圆心横坐标，for循环外层控制行数，内层控制列数
        for (int i = 1; i < 2*round_center[1]; i++) {
            for (int j = 1; j < 2*round_center[0]; j++) {
                // 计算当前打印点与圆心之间的距离
                double distance = Math.sqrt(Math.pow((double)(round_center[0]-j)/cube_ratio,2)+Math.pow(round_center[1]-i,2));
                // 由于是方格子，星到圆心的最短距离由半径限制，最长距离由画笔宽度限制
                if (distance >= radius && distance < radius + brush_width) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            // 打印完一行之后换行
            System.out.println();
        }
    }
}
