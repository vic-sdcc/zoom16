/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_report_type")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopReportType.findAll", query = "SELECT c FROM CoopReportType c"),
	@NamedQuery(name = "CoopReportType.findByReportTypeCode", query = "SELECT c FROM CoopReportType c WHERE c.reportTypeCode = :reportTypeCode"),
	@NamedQuery(name = "CoopReportType.findByReportType", query = "SELECT c FROM CoopReportType c WHERE c.reportType = :reportType"),
	@NamedQuery(name = "CoopReportType.findByReportDesc", query = "SELECT c FROM CoopReportType c WHERE c.reportDesc = :reportDesc")})
public class CoopReportType implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "report_type_code")
	private Integer reportTypeCode;
	@Size(max = 25)
    @Column(name = "report_type")
	private String reportType;
	@Size(max = 2147483647)
    @Column(name = "report_desc")
	private String reportDesc;
	@OneToMany(mappedBy = "reportTypeCode")
	private Collection<CoopReport> coopReportCollection;

	public CoopReportType() {
	}

	public CoopReportType(Integer reportTypeCode) {
		this.reportTypeCode = reportTypeCode;
	}

	public Integer getReportTypeCode() {
		return reportTypeCode;
	}

	public void setReportTypeCode(Integer reportTypeCode) {
		this.reportTypeCode = reportTypeCode;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getReportDesc() {
		return reportDesc;
	}

	public void setReportDesc(String reportDesc) {
		this.reportDesc = reportDesc;
	}

	@XmlTransient
	public Collection<CoopReport> getCoopReportCollection() {
		return coopReportCollection;
	}

	public void setCoopReportCollection(Collection<CoopReport> coopReportCollection) {
		this.coopReportCollection = coopReportCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (reportTypeCode != null ? reportTypeCode.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopReportType)) {
			return false;
		}
		CoopReportType other = (CoopReportType) object;
		if ((this.reportTypeCode == null && other.reportTypeCode != null) || (this.reportTypeCode != null && !this.reportTypeCode.equals(other.reportTypeCode))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopReportType[ reportTypeCode=" + reportTypeCode + " ]";
	}
	
}
