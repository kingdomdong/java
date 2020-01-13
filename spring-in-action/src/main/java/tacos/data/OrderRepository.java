package tacos.data;

import tacos.Order;

/**
 * Order repository interface
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2019-12-31
 */
public interface OrderRepository {

    Order save(Order order);

}
