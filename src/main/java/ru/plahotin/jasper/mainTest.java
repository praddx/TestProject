package ru.plahotin.jasper;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignSection;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.xml.JasperDesignFactory;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import net.sf.jasperreports.repo.JasperDesignReportResource;
import ru.plahotin.jasper.model.CostsByMonthReportResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class mainTest {
    public static void main(String[] args) {

        final String REPORT_TITLE = "Затраты по месяцам";
        final String REPORT_TABLE_TITLE = "Стоимость услуг в рублях";
        final String TEST_CLIENT = "ООО \"Тестовыая Организация\"";
        final String GRAPH_TITLE = "Затраты на деловые поездки";


        String path = "src/main/resources";
        String sourceFileName = path +"/jasperreports/byMonthReportDesign.jrxml";
        String mainReportWithCrosstab = path + "/jasperreports/byMonthReportDesignWithCrosstab.jrxml";
        String subreportPath = path + "/jasperreports/byMonthTableSubReportDesign.jrxml";
        String graphSubReportPath = path + "/jasperreports/byMonthGraphSubReportDesign.jrxml";
        String crosstabDataSubReport = path + "/jasperreports/byMonthDataCrosstab.jrxml";
        //String compiledReportFileName = path +"/compiled/byMonthReportTemplate.jasper";
        String exportFilePDF = path + "/exportedpdf/byMonthReport.pdf";
        String exportFileXLS = path + "/exportedpdf/byMonthReportExcel.xls";

        String testExportFilePDF = path + "/exportedpdf/testByMonthReport.pdf";
        String testSourceFileName = path + "/jasperreports/Test.jrxml";

        String printFileName;

        CostsByMonthReportResponse reportData = getReportData();

        List<CostsByMonthReportResponse> data = Collections.singletonList(reportData);
        JRBeanCollectionDataSource beanColDataSource = new
                JRBeanCollectionDataSource(data);

        Map<String, Object> parameters = new HashMap();
        parameters.put("reportTableTitle", REPORT_TABLE_TITLE);
        parameters.put("reportTitle", REPORT_TITLE);
        parameters.put("comparePeriod", reportData.getComparePeriod());
        parameters.put("selectedPeriod", reportData.getSelectedPeriod());
        parameters.put("client", TEST_CLIENT);
        parameters.put("reportGraphTitle", GRAPH_TITLE);
        LocalDateTime createdDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String createdDateString = formatter.format(createdDate);
        parameters.put("createdDate", createdDateString);

//        Map<String, Object> testParameters = new HashMap();
//        testParameters.put("title", REPORT_TABLE_TITLE);

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(sourceFileName);
            //JasperDesign design = new JasperDesign();

            //JasperReport jasperReport = JasperCompileManager.compileReport(mainReportWithCrosstab);
            JasperReport byMonthInfoSubReport = JasperCompileManager.compileReport(subreportPath);
            parameters.put("reportDataSubReport", byMonthInfoSubReport);
            JasperReport byMonthGraphSubRep = JasperCompileManager.compileReport(graphSubReportPath);
            parameters.put("reportGraphSubReport", byMonthGraphSubRep);

            //JasperReport byMonthDataCrosstabReport = JasperCompileManager.compileReport(crosstabDataSubReport);
            //List<CrosstabData> crosstabDataList = reportData.getItems().stream()
//                    .flatMap(i -> createCrosstab(i, reportData).stream())
//                    .collect(Collectors.toList());


            //parameters.put("corsstabReport", byMonthDataCrosstabReport);
            //parameters.put("crosstabDataList", crosstabDataList);

            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    jasperReport, parameters, beanColDataSource);

            JasperExportManager.exportReportToPdfFile(jasperPrint, exportFilePDF);

            JasperExportManager.exportReportToPdf(jasperPrint);

//            JasperReport testJasperReport = JasperCompileManager.compileReport(testSourceFileName);
//            JasperPrint testJasperPrint = JasperFillManager.fillReport(
//                    testJasperReport, parameters, beanColDataSource);
//            JasperExportManager.exportReportToPdfFile(testJasperPrint, testExportFilePDF);

            //JRXlsxExporter exporter = new JRXlsxExporter();
//            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//
//            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(exportFileXLS));
//            SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
//            configuration.setDetectCellType(true);//Set configuration as you like it!!
//            configuration.setCollapseRowSpan(false);
//            exporter.setConfiguration(configuration);
//            exporter.exportReport();
//
//            exporter.exportReport();
        } catch (JRException e) {
            e.printStackTrace();
        }

    }

    private static class CrosstabData {
        public String period;
        public String monthName;
        public Double amount;

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
        }

        public String getMonthName() {
            return monthName;
        }

        public void setMonthName(String monthName) {
            this.monthName = monthName;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }
    }

    private static List<CrosstabData> createCrosstab(CostsByMonthReportResponse.CostByMonthReportItem item, CostsByMonthReportResponse response) {
        List<CrosstabData> result = new ArrayList<>();
        CrosstabData data1 = new CrosstabData();
        data1.setAmount(item.getSelectedPeriodAmount());
        data1.setPeriod(response.getSelectedPeriod());
        data1.setMonthName(item.getMonthName());

        CrosstabData data2 = new CrosstabData();
        data2.setAmount(item.getComparePeriodAmount());
        data2.setPeriod(response.getComparePeriod());
        data2.setMonthName(item.getMonthName());

        result.add(data1);
        result.add(data2);
        return result;
    }

    private static CostsByMonthReportResponse getReportData() {
        CostsByMonthReportResponse reportData = new CostsByMonthReportResponse();

        reportData.setSelectedPeriod("Ноя.2017-Июл.2018");
        reportData.setComparePeriod("Ноя.2016-Июл.2017");
        reportData.setShowCompareData(true);


        CostsByMonthReportResponse.CostByMonthReportItem item1 = new CostsByMonthReportResponse.CostByMonthReportItem();
        item1.setMonthName("Ноябрь");
        item1.setSelectedPeriodAmount(100);
        item1.setComparePeriodAmount(50);
        item1.setDynamic(100);

        CostsByMonthReportResponse.CostByMonthReportItem item2 = new CostsByMonthReportResponse.CostByMonthReportItem();
        item2.setMonthName("Декабрь");
        item2.setSelectedPeriodAmount(100);
        item2.setComparePeriodAmount(50);
        item2.setDynamic(100);

        CostsByMonthReportResponse.CostByMonthReportItem item3 = new CostsByMonthReportResponse.CostByMonthReportItem();
        item3.setMonthName("Январь");
        item3.setSelectedPeriodAmount(100);
        item3.setComparePeriodAmount(50);
        item3.setDynamic(100);

        CostsByMonthReportResponse.CostByMonthReportItem item4 = new CostsByMonthReportResponse.CostByMonthReportItem();
        item4.setMonthName("Февраль");
        item4.setSelectedPeriodAmount(100);
        item4.setComparePeriodAmount(50);
        item4.setDynamic(100);

        CostsByMonthReportResponse.CostByMonthReportItem item5 = new CostsByMonthReportResponse.CostByMonthReportItem();
        item5.setMonthName("Март");
        item5.setSelectedPeriodAmount(100);
        item5.setComparePeriodAmount(50);
        item5.setDynamic(100);

        CostsByMonthReportResponse.CostByMonthReportItem item6 = new CostsByMonthReportResponse.CostByMonthReportItem();
        item6.setMonthName("Апрель");
        item6.setSelectedPeriodAmount(100);
        item6.setComparePeriodAmount(50);
        item6.setDynamic(100);

        CostsByMonthReportResponse.CostByMonthReportItem item7 = new CostsByMonthReportResponse.CostByMonthReportItem();
        item7.setMonthName("Май");
        item7.setSelectedPeriodAmount(100);
        item7.setComparePeriodAmount(50);
        item7.setDynamic(100);

        CostsByMonthReportResponse.CostByMonthReportItem item8 = new CostsByMonthReportResponse.CostByMonthReportItem();
        item8.setMonthName("Июнь");
        item8.setSelectedPeriodAmount(100);
        item8.setComparePeriodAmount(50);
        item8.setDynamic(100);

        CostsByMonthReportResponse.CostByMonthReportItem item9 = new CostsByMonthReportResponse.CostByMonthReportItem();
        item9.setMonthName("Июль");
        item9.setSelectedPeriodAmount(100);
        item9.setComparePeriodAmount(50);
        item9.setDynamic(100);

        CostsByMonthReportResponse.CostByMonthReportItem item10 = new CostsByMonthReportResponse.CostByMonthReportItem();
        item10.setMonthName("Август");
        item10.setSelectedPeriodAmount(100);
        item10.setComparePeriodAmount(50);
        item10.setDynamic(100);

        CostsByMonthReportResponse.CostByMonthReportItem item11 = new CostsByMonthReportResponse.CostByMonthReportItem();
        item11.setMonthName("Сентябрь");
        item11.setSelectedPeriodAmount(100);
        item11.setComparePeriodAmount(50);
        item11.setDynamic(100);

        CostsByMonthReportResponse.CostByMonthReportItem item12 = new CostsByMonthReportResponse.CostByMonthReportItem();
        item12.setMonthName("Октябрь");
        item12.setSelectedPeriodAmount(200);
        item12.setComparePeriodAmount(50);
        item12.setDynamic(400);

        reportData.getItems().add(item1);
        reportData.getItems().add(item2);
        reportData.getItems().add(item3);
        reportData.getItems().add(item4);
        reportData.getItems().add(item5);
        reportData.getItems().add(item6);
        reportData.getItems().add(item7);
        reportData.getItems().add(item8);
        reportData.getItems().add(item9);
        reportData.getItems().add(item10);
        reportData.getItems().add(item11);
       // reportData.getItems().add(item12);

        CostsByMonthReportResponse.CostByMonthReportItem total = new CostsByMonthReportResponse.CostByMonthReportItem();
        total.setSelectedPeriodAmount(1200);
        total.setComparePeriodAmount(600);
        total.setDynamic(100);

        reportData.setTotal(total);
        return reportData;
    }
}
