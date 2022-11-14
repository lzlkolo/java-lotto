package lotto.domain;

import lotto.SystemMessage;
import lotto.Utils;

import java.util.List;

public class Controller {
    Utils utils = new Utils();
    SystemMessage systemMessage = new SystemMessage();
    List<List<Integer>> lottoNumbers;
    List<Integer> winningNumbers;
    int bonusNumber;
    int money;


    public void run() {
        money = utils.inputMoney();
        int lottoTicket = utils.countTicket(money);
        createLotto(lottoTicket);
        setWinningNumbers();
        setBonusNumber();
        winningResult();
    }

    public void winningResult() {
        Judgment judgment = new Judgment(lottoNumbers, winningNumbers, bonusNumber);
        List<Integer> winningResult = judgment.result();
        systemMessage.printResult(winningResult);
    }

    public void createLotto(int lottoTicket) {
        NumberGenerator numberGenerator = new NumberGenerator();
        lottoNumbers = numberGenerator.createRandomNumbers(lottoTicket);
        systemMessage.printLottoNumbers(lottoNumbers);
    }

    public void setWinningNumbers() {
        winningNumbers = utils.inputWinningNumbers();
        new Lotto(winningNumbers);
    }

    public void setBonusNumber() {
        bonusNumber = utils.inputBonusNumber();
    }
}