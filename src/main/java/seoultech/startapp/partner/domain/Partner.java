package seoultech.startapp.partner.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Partner {

	private Long id;
	private Long partnerTypeId;
	private String name;
	private String description;
	private String imageUrl;
	private String phoneNumber;
	private String address;
	private int coordinateX;
	private int coordinateY;
	private String benefit;
}
