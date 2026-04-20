package pro1.reports.report5;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.reports.report5.reportDataModel.ExamStats;

public class DepartmentExamsStatsReporting {
    public static ExamStats GetReport(DataSource dataSource, String katedra) {
        var ExamListJson = dataSource.getTerminyZkousek2(katedra);
        var ExamList = new Gson().fromJson(ExamListJson, pro1.apiDataModel.ExamList.class);
        var count = ExamList.items.stream()
                .filter(e -> e.studentsCount > 0)
                .count();
        var teacherIds = ExamList.items.stream()
                .filter(e -> e.studentsCount > 0)
                .map(e -> e.teacherId)
                .distinct()
                .toList();
        return new ExamStats(count, teacherIds);
    }
}
