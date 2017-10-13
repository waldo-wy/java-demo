def bill = $_thxInquiryBillDao.getByInquiryCode(inquiryCode)
log.info("billId=" + bill.inquiryId)
log.info("orgCode=" + bill.orgCode)
return bill