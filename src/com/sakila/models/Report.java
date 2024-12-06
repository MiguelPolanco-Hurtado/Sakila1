package com.sakila.models;

public class Report {
    private String reportName;
    private String reportType;

    public Report(String reportName, String reportType) {
        this.reportName = reportName;
        this.reportType = reportType;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }
}
