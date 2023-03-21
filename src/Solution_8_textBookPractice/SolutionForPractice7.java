package Solution_8_textBookPractice;

import java.util.Scanner;

public class SolutionForPractice7 {

    private enum player {PLAYER1, PLAYER2, AI}
    private enum rockPaperScissors {ROCK, PAPER, SCISSORS}
    player p1;
    player p2;

    SolutionForPractice7(){
        //创建对象时调用游戏菜单
        gameMenu();
    }
    //在对局中两个玩家身份的 setter和getter
    private void setP1(player p){
        this.p1 = p;
    }

    private void setP2(player p){
        this.p2 = p;
    }

    private player getP1(){
        return this.p1;
    }

    private player getP2(){
        return this.p2;
    }

    //Shows game menu and call openingSelector() to get selection
    private void gameMenu(){
        boolean exitCode = false;
        while (!exitCode){
            System.out.println("1.PVP");
            System.out.println("2.PVS");
            System.out.println("3.EXIT");
            int sel = openingSelector();
            //选择模式会返回一个boolean值的退出码，决定是否退出游戏
            exitCode = modeChoose(sel);
        }
        System.out.println("Thanks for playing!");
    }

    //Gets the selection from game menu
    public int openingSelector(){
        System.out.print("Choose mode or exit: ");
        Scanner in = new Scanner(System.in);
        boolean isCorrectSelection = false;
        int sel = 1;
        while(!isCorrectSelection){
            try{
                sel = in.nextInt();
                if (sel != 1 && sel != 2 && sel != 3){
                    throw new GameInputException();
                }
                break;
            }catch (GameInputException e){
                e.menuInputError();
            }
        }
        return sel;
    }

    //Selects an item and return true to demonstrate exiting game
    public boolean modeChoose(int mode) {
        if (mode == 3)
            return true;
        int sel = 0;
        if (mode == 2){
            System.out.println("1.Player");
            System.out.println("2.AI");
            sel = playerSelector();
        }
        //根据模式和选择的先后手确定p1和p2
        setPlayer(mode, sel);
        //设置好以后调用startPlay()开始游戏
        startPlay();
        //若游戏退出，返回菜单
        return false;
    }

    //Sets the offender if the mode is PVE
    private int playerSelector(){
        System.out.print("Select who is the first: ");
        Scanner in = new Scanner(System.in);
        int sel = 1;
        boolean isCorrectSelection = false;
        while (!isCorrectSelection){
            try{
                sel = in.nextInt();
                if (sel != 1 && sel !=2){
                    throw new GameInputException();
                }
                break;
            }catch (GameInputException e){
                e.setFasterError();
            }
        }
        return sel;
    }

    //Sets p1 and p2 by game mode and selected offender
    private void setPlayer(int mode, int sel){
        if (mode == 1){
            setP1(player.PLAYER1);
            setP2(player.PLAYER2);
        }else if (mode == 2){
            if (sel == 1){
                setP1(player.PLAYER1);
                setP2(player.AI);
            }else{
                setP1(player.AI);
                setP2(player.PLAYER1);
            }
        }
    }

    //Game starts, input scissors, rock or paper to play the game
    private void startPlay(){
        boolean ctn = true;
        Scanner in = new Scanner(System.in);
        while(ctn){
            //Declares two items
            rockPaperScissors s1, s2;
            int i = 1;  //Ensure the number the string to show
            //Gets item from input or AI(random)
            s1 = getP1() == player.AI ? aiPlay() : playerPlay(i++);
            s2 = getP2() == player.AI ? aiPlay() : playerPlay(i);
            //平局的情况
            if (s1 == s2){
                System.out.println("Draw!!");
            }else{
                //Condition that is not draw
                player winner = getWinner(s1, s2);
                System.out.println("The winner is " + winner.toString()+ "!");
            }
            //Inquires if continue the game or not
            System.out.print("The round ends, press 1 to continue, otherwise return to menu: ");
            ctn = in.nextInt() == 1 ? true : false;
        }
    }

    //使用随机数来确定电脑要出的选项
    private rockPaperScissors aiPlay(){
        rockPaperScissors res = rockPaperScissors.values()[(int)(Math.random()*3)];
        System.out.println("AI played: " + res.toString());
        return res;
    }

    //从键盘输入晚间的选项
    private rockPaperScissors playerPlay(int i){
        Scanner in = new Scanner(System.in);
        System.out.print("Player"+i+" input from ROCK, PAPER, SCISSORS: ");
        String s = in.nextLine();
        rockPaperScissors res;
        while (true){
            try{
                //If input string is not correct, throw an exception
                res = rockPaperScissors.valueOf(s);
                break;
            }catch (IllegalArgumentException err){
                //Handles the error input item
                System.out.print("Input error, reinput: ");
                s = in.nextLine();
            }
        }
        return res;
    }

    //根据出的选项判定p1 p2的胜负情况
    private player getWinner(rockPaperScissors s1, rockPaperScissors s2){
        if (s1 == rockPaperScissors.SCISSORS && s2 == rockPaperScissors.ROCK
            || s1 == rockPaperScissors.PAPER && s2 == rockPaperScissors.SCISSORS
            || s1 == rockPaperScissors.ROCK && s2 == rockPaperScissors.PAPER){
            return getP2();
        }else{
            return getP1();
        }
    }

    public static void main(String[] args) {
        //Creates an instance of the game, game starts
        SolutionForPractice7 game = new SolutionForPractice7();
    }
}
