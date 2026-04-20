package pro1.reports.report5.reportDataModel;

import java.util.List;

public class ExamStats {
    public Long realizedExamsCount;
    public List<Long> teacherIds;

    public ExamStats(Long realizedExamsCount, List<Long> teacherIds) {
        this.realizedExamsCount = realizedExamsCount;
        this.teacherIds = teacherIds;
    }
}
