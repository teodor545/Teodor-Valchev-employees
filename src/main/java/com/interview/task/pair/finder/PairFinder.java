package com.interview.task.pair.finder;

import com.interview.task.parser.CsvParser;
import com.interview.task.parser.model.EmployeeRow;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PairFinder {

    private final CsvParser parser = new CsvParser();

    public List<EmployeePair> determineEmployeePairs(Path csvPath) throws Exception {
        List<EmployeeRow> allRows = parser.parse(csvPath);

        Set<Short> projectIds = getProjectIds(allRows);

        PairFinder pairFinder = new PairFinder();

        List<EmployeePair> maxOverlapsPerProject = new ArrayList<>();

        for (Short projectId : projectIds) {
            EmployeePair resultPair = null;
            List<EmployeeRow> allRowsPerProject = filterByProjectId(allRows, projectId);

            for (int i = 0; i < allRowsPerProject.size(); i++) {
                EmployeeRow employee = allRowsPerProject.get(i);
                for (int y = i + 1; y < allRowsPerProject.size(); y++) {
                    EmployeeRow toCompare = allRowsPerProject.get(y);
                    EmployeePair empPair = pairFinder.findOverlapDays(employee, toCompare);
                    if (empPair != null) {
                        if (resultPair == null || resultPair.getOverlapDays() < empPair.getOverlapDays()) {
                            resultPair = empPair;
                        }
                    }
                }
            }

            if (resultPair != null) {
                maxOverlapsPerProject.add(resultPair);
            }
        }

        return maxOverlapsPerProject;
    }

    private EmployeePair findOverlapDays(EmployeeRow e1, EmployeeRow e2) {
        if (!e1.getEndDate().isBefore(e1.getStartDate()) && !e2.getEndDate().isBefore(e2.getStartDate())) {
            long overlapDays = Math.min(e1.getEndDate().toEpochDay(), e2.getEndDate().toEpochDay())
                    - Math.max(e1.getStartDate().toEpochDay(), e2.getStartDate().toEpochDay());
            if (overlapDays > 0) {
                return new EmployeePair(e1.getEmployeeId(), e2.getEmployeeId(), e1.getProjectId(), overlapDays);
            }
        } else {
            throw new RuntimeException("Invalid csv data: start date is before end date");
        }
        return null;
    }

    private Set<Short> getProjectIds(List<EmployeeRow> allRows) {
        return allRows.stream()
                .map(EmployeeRow::getProjectId)
                .collect(Collectors.toSet());
    }

    private List<EmployeeRow> filterByProjectId(List<EmployeeRow> allRows, short projectId) {
        return allRows.stream()
                .filter(e -> e.getProjectId() == projectId)
                .toList();
    }
}
