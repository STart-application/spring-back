package seoultech.startapp.partner.adapter.in;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import seoultech.startapp.partner.domain.Partner;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchPartnerRequest {

	private List<Partner> partnerList;

	public static SearchPartnerRequest of(List<Partner> partners) {
		return SearchPartnerRequest.builder()
				.partnerList(partners)
				.build();
	}
}
