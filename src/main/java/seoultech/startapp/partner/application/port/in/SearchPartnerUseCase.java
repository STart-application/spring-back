package seoultech.startapp.partner.application.port.in;

import java.util.List;
import seoultech.startapp.partner.domain.Partner;

public interface SearchPartnerUseCase {

	List<Partner> searchPartner(String keyword, Long TypeId, int page, int count);
}
