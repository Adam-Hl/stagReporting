package pro1.reports.report4;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.apiDataModel.ThesisList;
import pro1.reports.report4.reportDataModel.ThesisAverage;

import java.util.ArrayList;
import java.util.List;

public class ThesisDurationReporting {
    public static List<ThesisAverage> GetReport(DataSource dataSource, String katedra, String[] years) {
        var result = new ArrayList<ThesisAverage>();
        for (var year : years){
            var ThesisListJson = dataSource.getKvalifikacniPrace(year, katedra);
            var ThesisList = new Gson().fromJson(ThesisListJson, ThesisList.class);
            var averageDuration = ThesisList.items.stream()
                    .filter(t -> t.startDate.toLocalDate() != null && t.endDate.toLocalDate() != null)
                    .mapToLong(t -> java.time.Duration.between(t.startDate.toLocalDate().atStartOfDay(), t.endDate.toLocalDate().atStartOfDay()).toDays())
                    .average()
                    .orElse(0);
            result.add(new ThesisAverage(year, Math.round(averageDuration)));
        }
        return result;
    }
}
