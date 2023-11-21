package seoultech.startapp.partner.adapter.out;

import org.springframework.stereotype.Component;
import seoultech.startapp.partner.domain.Partner;

@Component
public class PartnerMapper {

	public Partner toDomainPartner(JpaPartner jpaPartner) {
		return Partner.builder()
				.id(jpaPartner.getId())
				.partnerTypeId(jpaPartner.getPartnerTypeId())
				.name(jpaPartner.getName())
				.description(jpaPartner.getDescription())
				.imageUrl(jpaPartner.getImageUrl())
				.phoneNumber(jpaPartner.getPhoneNumber())
				.address(jpaPartner.getAddress())
				.coordinateX(jpaPartner.getCoordinateX())
				.coordinateY(jpaPartner.getCoordinateY())
				.benefit(jpaPartner.getBenefit())
				.build();
	}

	public JpaPartner toJpaPartner(Partner partner) {
		return JpaPartner.builder()
				.id(partner.getId() == null ? null : partner.getId())
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
