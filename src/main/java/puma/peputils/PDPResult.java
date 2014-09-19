package puma.peputils;

public class PDPResult {

	private PDPDecision decision;
	private String status;
	
	public PDPResult(PDPDecision decision, String status) {
		this.decision = decision;
		this.status = status;
	}
	
	public PDPDecision getDecision() {
		return decision;
	}
	
	public String getStatus() {
		return status;
	}
}
