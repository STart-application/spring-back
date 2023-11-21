package seoultech.startapp.partner.application;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seoultech.startapp.partner.application.port.in.GetPartnerTypeUseCase;
import seoultech.startapp.partner.application.port.out.LoadPartnerTypePort;

@Service
@RequiredArgsConstructor
public class GetPartnerTypeService implements GetPartnerTypeUseCase {

	private final LoadPartnerTypePort loadPartnerTypePort;

	@Override
	public List<PartnerTypeInfoResponse> getPartnerType() {
		return loadPartnerTypePort
				.loadAll()
				.stream()
				.map(PartnerTypeInfoResponse::from)
				.collect(Collectors.toList());
	}
}
