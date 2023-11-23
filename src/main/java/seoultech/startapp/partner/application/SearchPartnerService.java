package seoultech.startapp.partner.application;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import seoultech.startapp.partner.application.port.in.SearchPartnerUseCase;
import seoultech.startapp.partner.application.port.out.LoadPartnerPort;

@Service
@RequiredArgsConstructor
public class SearchPartnerService implements SearchPartnerUseCase {

	private final LoadPartnerPort loadPartnerPort;

	@Override
	public List<PartnerInfoResponse> searchPartner(String keyword, Long TypeId, int page, int count) {
		PageRequest pageRequest = PageRequest.of(page, count);
		return loadPartnerPort.loadByKeywordAndTypeIdByPaging(
				keyword,
				TypeId,
				pageRequest)
				.stream()
				.map(PartnerInfoResponse::from)
				.collect(Collectors.toList());
	}
}
