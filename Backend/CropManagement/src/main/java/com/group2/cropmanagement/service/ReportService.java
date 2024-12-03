package com.group2.cropmanagement.service;

import Group1.Crop_Management.Model.Report;

import java.util.List;

public interface ReportService {

    Report createReport(Report report);

    Report getReport(Long id);

    List<Report> getAllReports();

    List<Report> getReportsByFarmId(Long id);

    Report updateReport(Long id, Report report);
}
