package orders.service;

import orders.dao.IPaymentDao;
import orders.dao.OrdersDaoImpl;
import orders.dao.PaymentDaoImpl;
import orders.vo.PaymentVO;

public class PaymentServiceImpl implements IPaymentService {
	
	private IPaymentDao pDao;
	
	private static IPaymentService pService;
	
	private PaymentServiceImpl() {
		pDao = PaymentDaoImpl.getInstance();
	}
	
	public static IPaymentService getInstance() {
		if (pService == null) {
			pService = new PaymentServiceImpl();
		}
		return pService;
	}

	@Override
	public int paysuccess(PaymentVO pv) {
		return pDao.insertPayment(pv);
	}

}
