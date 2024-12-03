package com.group2.cropmanagement.service;


import com.group2.cropmanagement.model.Report;

import java.util.List;

public interface ReportService {

    Report createReport(Report report);

    Report getReport(Long id);

    List<Report> getAllReports();

    List<Report> getReportsByFarmId(Long id);

    Report updateReport(Long id, Report report);
}
