package bcoan.moip.controller

import bcoan.moip.domain.Coupon
import bcoan.moip.service.CouponService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by bruno on 22/01/16.
 */
@RestController
@RequestMapping("/coupons")
class CouponController {

    CouponService service

    @Autowired
    CouponController(CouponService service) {
        assert service, "service must not be null"
        this.service = service
    }

    @RequestMapping("/{key}")
    Coupon findByKey(@PathVariable String key) {
        service.findByKey(key)
    }
}
