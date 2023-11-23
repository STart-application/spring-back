package seoultech.startapp.partner.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PUBLIC)
public class PartnerType {

	private Long id;
	private String name;
}
