package ru.plahotin.jasper.model;

public class BaseReportItem {

    private double selectedPeriodAmount;

    private double comparePeriodAmount;

    private double dynamic;

    public double getDynamic() {
        return dynamic;
    }

    public void setDynamic(double dynamic) {
        this.dynamic = dynamic;
    }

    public double getSelectedPeriodAmount() {
        return selectedPeriodAmount;
    }

    public void setSelectedPeriodAmount(double selectedPeriodAmount) {
        this.selectedPeriodAmount = selectedPeriodAmount;
    }

    public double getComparePeriodAmount() {
        return comparePeriodAmount;
    }

    public void setComparePeriodAmount(double comparePeriodAmount) {
        this.comparePeriodAmount = comparePeriodAmount;
    }
}
