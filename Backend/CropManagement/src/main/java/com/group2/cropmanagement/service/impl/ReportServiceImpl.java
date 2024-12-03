package com.group2.cropmanagement.service.impl;

import com.group2.cropmanagement.model.Report;
import com.group2.cropmanagement.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Override
    public Report createReport(Report report) {
        return null;
    }

    @Override
    public Report getReport(Long id) {
        return null;
    }

    @Override
    public List<Report> getAllReports() {
        return List.of();
    }

    @Override
    public List<Report> getReportsByFarmId(Long id) {
        return List.of();
    }

    @Override
    public Report updateReport(Long id, Report report) {
        return null;
    }
}
