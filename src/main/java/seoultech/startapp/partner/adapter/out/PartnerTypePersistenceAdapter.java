package seoultech.startapp.partner.adapter.out;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import seoultech.startapp.partner.application.port.out.LoadPartnerTypePort;
import seoultech.startapp.partner.domain.PartnerType;

@Component
@RequiredArgsConstructor
public class PartnerTypePersistenceAdapter implements LoadPartnerTypePort {

	private final PartnerTypeRepository partnerTypeRepository;
	private final PartnerTypeMapper partnerTypeMapper;
	@Override
	public List<PartnerType> loadAll() {
		return partnerTypeRepository
				.findAll()
				.stream()
				.map(partnerTypeMapper::toDomainPartnerType)
				.collect(Collectors.toList());
	}
}
