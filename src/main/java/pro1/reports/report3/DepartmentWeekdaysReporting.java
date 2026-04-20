package pro1.reports.report3;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.apiDataModel.ActionsList;
import pro1.reports.report3.reportDataModel.Weekday;

import java.util.ArrayList;
import java.util.List;

public class DepartmentWeekdaysReporting {
    public static List<Weekday> GetReport(DataSource dataSource, String rok, String katedra, String[] dny) {
        var actionsListJson = dataSource.getRozvrhByKatedra(rok, katedra);
        var actionsList = new Gson().fromJson(actionsListJson, ActionsList.class);
        var result = new ArrayList<Weekday>();
        for (var d : dny) {
            var count = actionsList.items.stream()
                    .map(a -> a.weekday)
                    .filter(w -> w != null)
                    .filter(w -> w.equals(d))
                    .count();
            result.add(new Weekday(d, count));
        }
        return result;
    }
}
