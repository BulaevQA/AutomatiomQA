package api.rest.employerreport.getforms_reports.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
public class GetFormReportsResponse {
	
	@JsonProperty("success")
	 private List<SuccessResponse> successesList;
}
