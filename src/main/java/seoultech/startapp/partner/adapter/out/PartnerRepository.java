package seoultech.startapp.partner.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<JpaPartner, Long>, CustomPartnerRepository {

}
