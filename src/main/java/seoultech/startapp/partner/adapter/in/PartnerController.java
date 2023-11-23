package seoultech.startapp.partner.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import seoultech.startapp.global.response.JsonResponse;
import seoultech.startapp.partner.application.port.in.GetPartnerTypeUseCase;
import seoultech.startapp.partner.application.port.in.SearchPartnerUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partner")
public class PartnerController {

	private final SearchPartnerUseCase searchPartnerUseCase;
	private final GetPartnerTypeUseCase getPartnerTypeUseCase;

	@GetMapping("/search")
	public ResponseEntity<?> search(
			@RequestParam("keyword") String keyword,
			@RequestParam("categoryId") Long categoryId,
			@RequestParam("page") int page,
			@RequestParam("count") int count
	) {
		SearchPartnerRequest response = SearchPartnerRequest.of(
				searchPartnerUseCase.searchPartner(keyword, categoryId, page, count));
		return JsonResponse.okWithData(HttpStatus.OK, "조회 성공", response);
	}

	@GetMapping("/category")
	public ResponseEntity<?> getPartnerCategory() {
		GetPartnerTypeRequest response = GetPartnerTypeRequest.of(
				getPartnerTypeUseCase.getPartnerType());
		return JsonResponse.okWithData(HttpStatus.OK, "조회 성공", response);
	}
}
