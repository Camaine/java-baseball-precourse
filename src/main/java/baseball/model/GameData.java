package baseball.model;

public class GameData {
    private String answer;
    private String input;
    private String nextGame;
    private int ball;
    private int strike;

    public String getNextGame() {
        return nextGame;
    }

    public void setNextGame(String nextGame) {
        this.nextGame = nextGame;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        this.out = out;
    }

    private int out;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
