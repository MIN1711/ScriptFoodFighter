package orders.dao;

import comm.dao.MyBatisDao;
import orders.vo.PaymentVO;

public class PaymentDaoImpl extends MyBatisDao implements IPaymentDao {

	private static IPaymentDao pDao;
	
	public PaymentDaoImpl() {
		
	}
	
	public static IPaymentDao getInstance() {
		if (pDao == null) {
			pDao = new PaymentDaoImpl();
		}
		return pDao;
	}

	@Override
	public int insertPayment(PaymentVO pv) {
		return insert("orders.paySuccess", pv);
	}

}
