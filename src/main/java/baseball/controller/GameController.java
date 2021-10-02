package baseball.controller;

import baseball.model.GameData;
import baseball.service.GameService;
import nextstep.utils.Console;

public class GameController {
    public void playGame(){
        GameData data = new GameData();
        GameService service = new GameService();
        data.setAnswer(service.setRandomAnswer());
        service.inGame(data);
        //System.out.println(data.getAnswer());
    }
}
