package ru.plahotin.jasper.model;

import java.util.ArrayList;
import java.util.List;

public class CostsByMonthReportResponse extends BaseRestResponse {

    private final List<CostByMonthReportItem> items = new ArrayList<>();

    private String selectedPeriod;

    private String comparePeriod;

    private CostByMonthReportItem total;

    private boolean showCompareData;

    public CostByMonthReportItem getTotal() {
        return total;
    }

    public void setTotal(CostByMonthReportItem total) {
        this.total = total;
    }

    public List<CostByMonthReportItem> getItems() {
        return items;
    }

    public String getSelectedPeriod() {
        return selectedPeriod;
    }

    public void setSelectedPeriod(String selectedPeriod) {
        this.selectedPeriod = selectedPeriod;
    }

    public String getComparePeriod() {
        return comparePeriod;
    }

    public void setComparePeriod(String comparePeriod) {
        this.comparePeriod = comparePeriod;
    }

    public boolean isShowCompareData() {
        return showCompareData;
    }

    public void setShowCompareData(boolean showCompareData) {
        this.showCompareData = showCompareData;
    }

    public static class CostByMonthReportItem extends BaseReportItem {

        private String monthName;

        public String getMonthName() {
            return monthName;
        }

        public void setMonthName(String monthName) {
            this.monthName = monthName;
        }

    }
}
