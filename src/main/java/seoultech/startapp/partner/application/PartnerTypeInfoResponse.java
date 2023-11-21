package seoultech.startapp.partner.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import seoultech.startapp.partner.domain.PartnerType;

@Getter
@Builder
@AllArgsConstructor
public class PartnerTypeInfoResponse {

	private Long id;
	private String name;

	public static PartnerTypeInfoResponse from(PartnerType partnerType) {
		return PartnerTypeInfoResponse.builder()
				.id(partnerType.getId())
				.name(partnerType.getName())
				.build();
	}
}
