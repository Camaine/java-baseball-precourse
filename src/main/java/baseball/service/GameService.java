package baseball.service;

import baseball.model.GameData;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class GameService {

    public void inGame(GameData data){
        System.out.print("숫자를 입력해주세요 : ");
        data.setInput(Console.readLine());
        judge(data);
        System.out.println(printStrike(data)+printBall(data)+printNothing(data));
        if(data.getStrike() == 3){
            endGame(data);
            return;
        }
        resetGameData(data);
        inGame(data);
        return;
    }

    public void endGame(GameData data){
        resetGameData(data);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 ");
        data.setNextGame(Console.readLine());
        if(data.getNextGame().equals("1")){
            data.setAnswer(setRandomAnswer());
            inGame(data);
        }
        return;
    }

    public void resetGameData(GameData data){
        data.setBall(0);
        data.setStrike(0);
        data.setOut(0);
        data.setInput("");
    }


    public String setRandomAnswer(){
        int first = Randoms.pickNumberInRange(1,9);
        int second = Randoms.pickNumberInRange(1,9);
        int third = Randoms.pickNumberInRange(1,9);
        while(first == second || first == third || second == third){
            first = Randoms.pickNumberInRange(1,9);
            second = Randoms.pickNumberInRange(1,9);
            third = Randoms.pickNumberInRange(1,9);
        }
        return Integer.toString(first) + Integer.toString(second) + Integer.toString(third);
    }

    public String printStrike(GameData data){
        if(data.getStrike() == 0){
            return "";
        }
        return Integer.toString(data.getStrike()) + " 스트라이트 ";
    }

    public String printBall(GameData data){
        if(data.getBall() == 0){
            return "";
        }
        return Integer.toString(data.getBall()) + " 볼 ";
   }

   public String printNothing(GameData data){
       if(data.getBall() == 0 && data.getStrike() == 0){
           return "낫싱";
       }
       return "";
   }

    private void judge(GameData data){
        for(int i = 0 ; i < 3 ; i++){
            ballOrStrike(data,i);
        }
    }

    private void ballOrStrike(GameData data, int pos){
        if(isStrike(data,pos) == 1){
            data.setStrike(data.getStrike()+1);
            return;
        }
        if(isBall(data, pos) == 1){
            data.setBall(data.getBall()+1);
            return;
        }
        return;
    }

    private int isBall(GameData data, int pos){
        if(data.getAnswer().contains(Character.toString(data.getInput().charAt(pos)))){
            return 1;
        }
        return 0;
    }

    private int isStrike(GameData data, int pos){
        if(data.getAnswer().charAt(pos) == data.getInput().charAt(pos)){
            return 1;
        }
        return 0;
    }
}
