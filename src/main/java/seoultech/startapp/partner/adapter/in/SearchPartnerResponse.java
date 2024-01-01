package seoultech.startapp.partner.adapter.in;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import seoultech.startapp.partner.application.PartnerInfoResponse;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchPartnerResponse {

	private List<PartnerInfoResponse> partnerList;

	public static SearchPartnerResponse of(List<PartnerInfoResponse> partnerInfoResponses) {
		return SearchPartnerResponse.builder()
				.partnerList(partnerInfoResponses)
				.build();
	}
}
