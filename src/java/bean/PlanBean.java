/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import model.CoopOrgUnit;
import model.CoopReport;
import model.CoopReportType;
import service.CoopOrgUnitFacadeREST;
import service.CoopReportFacadeREST;

/**
 *
 * @author mis
 */
@ManagedBean
@SessionScoped
public class PlanBean {

    @PersistenceUnit
    EntityManagerFactory emf;

    @EJB
    private CoopReportFacadeREST coopReportFacadeREST;
    private CoopReport selectedReport;
    private CoopReport report = new CoopReport();
    private List<CoopReport> reportList;
    private DataModel<CoopReport> reportModel;

    @EJB
    private CoopOrgUnitFacadeREST coopOrgUnitFacadeREST;
    private CoopOrgUnit selectedOrgUnit;
    private CoopOrgUnit orgUnit = new CoopOrgUnit();
    private List<CoopOrgUnit> orgUnitList;
    private DataModel<CoopOrgUnit> orgUnitModel;
    
    CoopReportType reportType = new CoopReportType();

    public void init() {
        reportList = coopReportFacadeREST.findAll();
        orgUnitList = coopOrgUnitFacadeREST.findAll();
    }

    public void beanclear() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("planBean", null);
    }

    /**
     * Creates a new instance of PlanBean
     */
    public PlanBean() {
    }

    public CoopReportFacadeREST getCoopReportFacadeREST() {
        return coopReportFacadeREST;
    }

    public void setCoopReportFacadeREST(CoopReportFacadeREST coopReportFacadeREST) {
        this.coopReportFacadeREST = coopReportFacadeREST;
    }

    public CoopReport getSelectedReport() {
        return selectedReport;
    }

    public void setSelectedReport(CoopReport selectedReport) {
        this.selectedReport = selectedReport;
    }

    public CoopReport getReport() {
        return report;
    }

    public void setReport(CoopReport report) {
        this.report = report;
    }

    public List<CoopReport> getReportList() {
        return reportList;
    }

    public void setReportList(List<CoopReport> reportList) {
        this.reportList = reportList;
    }

    public DataModel<CoopReport> getReportModel() {
        return reportModel;
    }

    public void setReportModel(DataModel<CoopReport> reportModel) {
        this.reportModel = reportModel;
    }

    public CoopOrgUnitFacadeREST getCoopOrgUnitFacadeREST() {
        return coopOrgUnitFacadeREST;
    }

    public void setCoopOrgUnitFacadeREST(CoopOrgUnitFacadeREST coopOrgUnitFacadeREST) {
        this.coopOrgUnitFacadeREST = coopOrgUnitFacadeREST;
    }

    public CoopOrgUnit getSelectedOrgUnit() {
        return selectedOrgUnit;
    }

    public void setSelectedOrgUnit(CoopOrgUnit selectedOrgUnit) {
        this.selectedOrgUnit = selectedOrgUnit;
    }

    public CoopOrgUnit getOrgUnit() {
        return orgUnit;
    }

    public void setOrgUnit(CoopOrgUnit orgUnit) {
        this.orgUnit = orgUnit;
    }

    public List<CoopOrgUnit> getOrgUnitList() {
        return orgUnitList;
    }

    public void setOrgUnitList(List<CoopOrgUnit> orgUnitList) {
        this.orgUnitList = orgUnitList;
    }

    public DataModel<CoopOrgUnit> getOrgUnitModel() {
        return orgUnitModel;
    }

    public void setOrgUnitModel(DataModel<CoopOrgUnit> orgUnitModel) {
        this.orgUnitModel = orgUnitModel;
    }

    public Date getD() {
        return new Date();
    }

    public static String formatDate(Date currentDate) {
        DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
        return dateFormat.format(currentDate);
        //<!--#{planBean.formatDate(planBean.d)}-->
    }

    public String savePlan() {
        report.setOuCode(orgUnit);
        reportType.setReportTypeCode(4);
        report.setReportTypeCode(reportType);
        coopReportFacadeREST.create(report);
        report = new CoopReport();
        beanclear();
        return "mainPlan";
    }

}
