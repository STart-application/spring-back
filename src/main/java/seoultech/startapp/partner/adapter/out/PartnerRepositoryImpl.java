package seoultech.startapp.partner.adapter.out;

import static seoultech.startapp.partner.adapter.out.QJpaPartner.jpaPartner;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
public class PartnerRepositoryImpl implements CustomPartnerRepository {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<JpaPartner> findAllByKeywordAndTypeIdByPaging(
			String keyword,
			Long typeId,
			PageRequest pageRequest) {
		return queryFactory.selectFrom(jpaPartner)
				.where(containKeyword(keyword).and(samePartnerTypeId(typeId)))
				.offset(pageRequest.getOffset())
				.limit(pageRequest.getPageSize())
				.fetch();
	}

	private BooleanExpression containKeyword(String keyword) {
		return StringUtils.hasText(keyword)
				? jpaPartner.name.contains(keyword).or(jpaPartner.description.contains(keyword))
				: null;
	}

	private BooleanExpression samePartnerTypeId(Long typeId) {
		return typeId != null
				? jpaPartner.partnerTypeId.eq(typeId)
				: null;
	}
}
