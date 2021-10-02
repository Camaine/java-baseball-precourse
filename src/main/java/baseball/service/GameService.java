package baseball.service;

import baseball.model.GameData;
import baseball.view.GameView;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class GameService {

    public void inGame(GameData data){
        data.setInput(GameView.reqUserGuessInput());
        judge(data);
        isGameComplete(data);
    }

    public int identifyWrongInput(GameData data){
        int input = 0;
        try{
            input = Integer.parseInt(data.getInput());
        }catch (Exception e){
            return 1;
        }
        if(input > 100 && input < 1000 && data.getInput().length() == 3){
            return 0;
        }
        return 1;
    }

    public void isGameComplete(GameData data){
        if(data.getStrike() == 3){
            endGame(data);
            return;
        }
        inGame(data);
    }

    public void endGame(GameData data){
        resetGameData(data);
        data.setNextGame(GameView.reqUserGameEndInput());
        if(data.getNextGame().equals("1")){
            data.setAnswer(setRandomAnswer());
            inGame(data);
        }
    }

    public void resetGameData(GameData data){
        data.setBall(0);
        data.setStrike(0);
        data.setOut(0);
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
        return Integer.toString(data.getStrike()) + "스트라이크";
    }

    public String printBall(GameData data){
        if(data.getBall() == 0){
            return "";
        }
        return Integer.toString(data.getBall()) + "볼";
   }

   public String printNothing(GameData data){
       if(data.getBall() == 0 && data.getStrike() == 0){
           return "낫싱";
       }
       return "";
   }

    private void judge(GameData data){
        resetGameData(data);
        if(identifyWrongInput(data) == 1){
            GameView.rspWrongInputError();
            return;
        }
        for(int i = 0 ; i < 3 ; i++){
            ballOrStrike(data,i);
        }
        GameView.rspUserInputResult(printStrike(data)+" "+printBall(data)+printNothing(data));
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
