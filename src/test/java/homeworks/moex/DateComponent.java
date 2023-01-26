package homeworks.moex;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateComponent {

    private Locale localeRu = new Locale("ru", "RU");

    private SimpleDateFormat weekDayFormat = new SimpleDateFormat("EEEE", localeRu);

    private Date now = new Date();

    String weekDay = weekDayFormat.format(now);

}
