package seoultech.startapp.partner.application.port.in;

import java.util.List;
import seoultech.startapp.partner.application.PartnerInfoResponse;

public interface SearchPartnerUseCase {

	List<PartnerInfoResponse> searchPartner(String keyword, Long TypeId, int page, int count);
}
