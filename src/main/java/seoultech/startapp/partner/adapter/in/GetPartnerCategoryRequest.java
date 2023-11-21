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
public class GetPartnerCategoryRequest {

	private List<PartnerType> partnerTypeList;

	public static GetPartnerCategoryRequest of(List<PartnerType> partnerTypes) {
		return GetPartnerCategoryRequest.builder()
				.partnerTypeList(partnerTypes)
				.build();
	}
}
