package seoultech.startapp.partner.application.port.in;

import java.util.List;
import seoultech.startapp.partner.application.PartnerTypeInfoResponse;
import seoultech.startapp.partner.domain.PartnerType;

public interface GetPartnerTypeUseCase {

	List<PartnerTypeInfoResponse> getPartnerType();
}
