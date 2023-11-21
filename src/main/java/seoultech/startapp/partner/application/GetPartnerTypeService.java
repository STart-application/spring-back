package seoultech.startapp.partner.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seoultech.startapp.partner.application.port.in.GetPartnerTypeUseCase;
import seoultech.startapp.partner.application.port.out.LoadPartnerTypePort;
import seoultech.startapp.partner.domain.PartnerType;

@Service
@RequiredArgsConstructor
public class GetPartnerTypeService implements GetPartnerTypeUseCase {

	private final LoadPartnerTypePort loadPartnerTypePort;

	@Override
	public List<PartnerType> getPartnerType() {
		return loadPartnerTypePort.loadAll();
	}
}
