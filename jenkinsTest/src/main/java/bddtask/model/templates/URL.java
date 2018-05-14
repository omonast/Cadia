package bddtask.model.templates;

import static bddtask.model.constants.TestData.KEY;
import static bddtask.model.constants.TestData.URL;

public class URL {
    public final static String FORECAST_FOR_CITY = URL + "weather?q=%s" + KEY;
    public final static String FORECAST_FOR_FIVE_DAYS = URL + "forecast?q=%s,%s" + KEY;
    public final static String FORECAST_BY_COORDS = URL + "weather?lat=%s&lon=%s" + KEY;
}
