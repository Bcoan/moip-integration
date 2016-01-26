package bcoan.moip.service

import bcoan.moip.domain.Coupon
import bcoan.moip.exception.NotFoundException
import bcoan.moip.repository.CouponRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by bruno on 20/01/16.
 */
@Service
class CouponService {

    CouponRepository repository

    @Autowired
    CouponService(CouponRepository repository) {
        assert repository, 'repository must not be null'
        this.repository = repository
    }

    Coupon findByKey(String key) {
        repository.findByKey(key).orElseThrow(new NotFoundException("coupon not found"))
    }
}
