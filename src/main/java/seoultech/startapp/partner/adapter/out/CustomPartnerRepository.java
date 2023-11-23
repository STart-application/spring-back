package seoultech.startapp.partner.adapter.out;

import java.util.List;
import org.springframework.data.domain.PageRequest;

public interface CustomPartnerRepository {

	List<JpaPartner> findAllByKeywordAndTypeIdByPaging(String keyword, Long typeId, PageRequest pageRequest);
}
