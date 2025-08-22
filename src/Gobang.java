import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * 功能：五子棋<br>
 * 实现方式：<br>
 * 初始化棋盘（initBoard）->打印棋盘（printBoard）->接收输入并落子（main中）->电脑落子（botPlay）<br>
 * 电脑落子（botPlay）->打印棋盘（printBoard）->检查胜利（checkWin，checkLocal）<br>
 * 检查胜利（checkWin，checkLocal）->{胜利 棋盘占满平局（empty） 接受输入并落子（main中）}<br>
 */

public class Gobang {

    private String[][] board;
    private static int BOARD_SIZE = 15;
    private static String WHITE = "0";
    private static String BLACK = "1";
    private static String CROSS = "+";
    private int empty = BOARD_SIZE*BOARD_SIZE;
    public static void main(String[] args) throws Exception {
        Gobang gb = new Gobang();
        gb.initBoard();
        gb.printBoard();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr;
        System.out.println("请输入您下棋的坐标，应以x,y（0到15）的格式：");
        while ((inputStr = br.readLine()) != null){
            String[] posStrArr = inputStr.split(",");
            int x = Integer.parseInt(posStrArr[0]);
            int y = Integer.parseInt(posStrArr[1]);
            if (x>0&&x<=15&&y>0&&y<=15 && gb.board[x-1][y-1] == CROSS) {
                gb.board[x-1][y-1] = WHITE;
                gb.empty -= 1;
            }else {
                System.out.println("请输入您下棋的坐标，应以x,y（0到15）的格式：");
                continue;
            }
            // 题目要求：随机生成坐标，坐标不能重复，判断胜利
            gb.botPlay();
            gb.printBoard();
            if (gb.checkWin()) {
                System.out.println("WIN!");
                br.close();
                return;
            }else if(gb.empty > 0){
                System.out.println("请输入您下棋的坐标，应以x,y（0到15）的格式：");
            }else {
                System.out.println("平局！");
                br.close();
                return;
            }
        }
    }
    private void initBoard(){
        board = new String[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = CROSS;
            }
        }
    }
    private void printBoard(){
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private void botPlay(){
        if (empty == 0) {
            return;
        }
        Random random = new Random();
        int x = random.nextInt(15);
        int y = random.nextInt(15);
        while (board[x][y]!=CROSS){
            x=random.nextInt(15);
            y = random.nextInt(15);
        }
        board[x][y] = BLACK;
    }

    private boolean checkWin(){
        for (int i = 4; i < 11; i++) {
            for (int j = 4; j < 11; j++) {
                if (board[i][j] != CROSS && checkLocal(i,j, board[i][j])) {
                    System.out.print(board[i][j]);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkLocal(int i, int j, String point) {
        // 对八个方向分别进行判定，代码虽然丑陋但是不好改
        for (int k = 0; k < 8; k++) {
            for (int l = 0; l < 4; l++) {
                String localPoint = switch (k) {
                    case 0 -> board[i - 1 - l][j - 1 - l];
                    case 1 -> board[i - 1 - l][j];
                    case 2 -> board[i - 1 - l][j + 1 + l];
                    case 3 -> board[i][j + 1 + l];
                    case 4 -> board[i + 1 + l][j + 1 + l];
                    case 5 -> board[i + 1 + l][j];
                    case 6 -> board[i + 1 + l][j - 1 - l];
                    case 7 -> board[i][j - 1 - l];
                    default -> "";
                };
                if (localPoint !=point) {
                    break;
                }
                if (l == 3) {
                    return true;
                }
            }

        }
        return false;
    }

}
