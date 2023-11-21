package seoultech.startapp.partner.adapter.in;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import seoultech.startapp.partner.domain.PartnerType;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetPartnerTypeRequest {

	private List<PartnerType> partnerTypeList;

	public static GetPartnerTypeRequest of(List<PartnerType> partnerTypes) {
		return GetPartnerTypeRequest.builder()
				.partnerTypeList(partnerTypes)
				.build();
	}
}
