package seoultech.startapp.partner.adapter.in;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import seoultech.startapp.partner.application.PartnerTypeInfoResponse;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetPartnerTypeRequest {

	private List<PartnerTypeInfoResponse> partnerTypeList;

	public static GetPartnerTypeRequest of(List<PartnerTypeInfoResponse> partnerTypeInfoResponses) {
		return GetPartnerTypeRequest.builder()
				.partnerTypeList(partnerTypeInfoResponses)
				.build();
	}
}
