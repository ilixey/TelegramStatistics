import Bots.StatisticsBot;
import com.itextpdf.text.DocumentException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.TimerTask;

public class MyTimeTask extends TimerTask {

    public StatisticsBot statisticsBot;

    public MyTimeTask(StatisticsBot statisticsBot){
        this.statisticsBot = statisticsBot;
    }
    @Override
    public void run() {
        try {
            statisticsBot.sendStatistics();
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }
}