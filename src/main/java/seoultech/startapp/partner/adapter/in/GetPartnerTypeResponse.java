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
public class GetPartnerTypeResponse {

	private List<PartnerTypeInfoResponse> partnerTypeList;

	public static GetPartnerTypeResponse of(List<PartnerTypeInfoResponse> partnerTypeInfoResponses) {
		return GetPartnerTypeResponse.builder()
				.partnerTypeList(partnerTypeInfoResponses)
				.build();
	}
}
