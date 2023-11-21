package seoultech.startapp.partner.application.port.out;

import java.util.List;
import seoultech.startapp.partner.domain.PartnerType;

public interface LoadPartnerTypePort {

	List<PartnerType> loadAll();
}
