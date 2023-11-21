package seoultech.startapp.partner.adapter.out;

import org.springframework.stereotype.Component;
import seoultech.startapp.partner.domain.PartnerType;

@Component
public class PartnerTypeMapper {

	public PartnerType toDomainPartnerType(JpaPartnerType jpaPartnerType) {
		return PartnerType.builder()
				.id(jpaPartnerType.getId())
				.name(jpaPartnerType.getName())
				.build();
	}

	public JpaPartnerType toJpaPartnerType(PartnerType partnerType) {
		return JpaPartnerType.builder()
				.id(partnerType.getId() == null ? null : partnerType.getId())
				.name(partnerType.getName())
				.build();
	}
}
