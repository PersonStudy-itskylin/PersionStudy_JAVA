package models;

/**
 * 单据查询参数对象
 *
 */
public class BillQuery {
	private String code;
	private String codeFrom;
	private String codeTo;
	private String dateFrom;
	private String dateTo;
	private Integer intercourseId;
	private Integer depotId;
	private Integer depot2Id;
	
	public String getCodeFrom() {
		return codeFrom;
	}
	public void setCodeFrom(String codeFrom) {
		this.codeFrom = codeFrom;
	}
	public String getCodeTo() {
		return codeTo;
	}
	public void setCodeTo(String codeTo) {
		this.codeTo = codeTo;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	public Integer getIntercourseId() {
		return intercourseId;
	}
	public void setIntercourseId(Integer intercourseId) {
		this.intercourseId = intercourseId;
	}
	public Integer getDepotId() {
		return depotId;
	}
	public void setDepotId(Integer depotId) {
		this.depotId = depotId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getDepot2Id() {
		return depot2Id;
	}
	public void setDepot2Id(Integer depot2Id) {
		this.depot2Id = depot2Id;
	}
}
