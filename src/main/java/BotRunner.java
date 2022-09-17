import Bots.StatisticsBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class BotRunner {
    public static void main(String[] args) throws TelegramApiException, ParseException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        StatisticsBot statisticsBot = new StatisticsBot();
        telegramBotsApi.registerBot(statisticsBot);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse("2022-09-17 17:30:00");

        Timer timer = new Timer();
        timer.schedule(new MyTimeTask(statisticsBot), date, 10000);
    }
}
