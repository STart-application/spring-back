package seoultech.startapp.partner.adapter.out;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "partner")
@Builder
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor
public class JpaPartner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "partner_id")
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
