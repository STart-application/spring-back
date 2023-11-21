package seoultech.startapp.partner.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import seoultech.startapp.partner.domain.Partner;

@Getter
@Builder
@AllArgsConstructor
public class PartnerInfoResponse {

	private Long id;
	private Long partnerTypeId;
	private String name;
	private String description;
	private String imageUrl;
	private String phoneNumber;
	private String address;
	private int coordinateX;
	private int coordinateY;
	private String benefit;

	public static PartnerInfoResponse from(Partner partner) {
		return PartnerInfoResponse.builder()
				.id(partner.getId())
				.partnerTypeId(partner.getPartnerTypeId())
				.name(partner.getName())
				.description(partner.getDescription())
				.imageUrl(partner.getImageUrl())
				.phoneNumber(partner.getPhoneNumber())
				.address(partner.getAddress())
				.coordinateX(partner.getCoordinateX())
				.coordinateY(partner.getCoordinateY())
				.benefit(partner.getBenefit())
				.build();
	}
}
