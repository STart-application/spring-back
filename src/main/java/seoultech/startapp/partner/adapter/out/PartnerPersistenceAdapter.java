package seoultech.startapp.partner.adapter.out;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import seoultech.startapp.partner.application.port.out.LoadPartnerPort;
import seoultech.startapp.partner.domain.Partner;

@Component
@RequiredArgsConstructor
public class PartnerPersistenceAdapter implements LoadPartnerPort {

	private final PartnerRepository partnerRepository;
	private final PartnerMapper mapper;

	@Override
	public List<Partner> loadByKeywordAndTypeIdByPaging(String keyword, Long typeId, PageRequest pageRequest) {
		return partnerRepository
				.findAllByKeywordAndTypeIdByPaging(keyword, typeId, pageRequest)
				.stream()
				.map(mapper::toDomainPartner)
				.collect(Collectors.toList());
	}
}
