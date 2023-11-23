package seoultech.startapp.partner.application.port.out;

import java.util.List;
import org.springframework.data.domain.PageRequest;
import seoultech.startapp.partner.domain.Partner;

public interface LoadPartnerPort {

	List<Partner> loadByKeywordAndTypeIdByPaging(String keyword, Long typeId, PageRequest pageRequest);
}
