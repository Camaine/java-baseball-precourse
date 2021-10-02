package baseball.view;

import nextstep.utils.Console;

public class GameView {
    public static String reqUserGuessInput(){
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static String reqUserGameEndInput(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 ");
        return Console.readLine();
    }

    public static void rspWrongInputError(){
        System.out.println("[ERROR]");
    }

    public static void rspUserInputResult(String result){
        System.out.println(result);
    }
}
